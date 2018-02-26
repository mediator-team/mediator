package org.fmgroup.mediator.language.type;

import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.term.Term;
import org.fmgroup.mediator.language.type.paramType.AbstractType;
import org.fmgroup.mediator.language.type.paramType.TemplateType;
import org.fmgroup.mediator.language.type.termType.*;

import java.util.Map;

public interface Type extends RawElement {

    @Deprecated
    static boolean isFinite(Type type) {
        System.err.println("Unknown Type " + type.toString() + " @" + Type.class.toGenericString());
        return false;
    }

    static Type parse(MediatorLangParser.TypeContext tc, RawElement parent) throws ValidationException {

        if (tc == null) return null;

        if (tc instanceof MediatorLangParser.DoubleTypeContext) {
            return new DoubleType().fromContext(tc, parent);
        }
        if (tc instanceof MediatorLangParser.BoolTypeContext)
            return new BoolType().fromContext(tc, parent);
        if (tc instanceof MediatorLangParser.BoundedIntTypeContext)
            return new BoundedIntType().fromContext(tc, parent);
        if (tc instanceof MediatorLangParser.IntTypeContext)
            return new IntType().fromContext(tc, parent);
        if (tc instanceof MediatorLangParser.IdTypeContext)
            return new IdType().fromContext(tc, parent);
        if (tc instanceof MediatorLangParser.NullTypeContext)
            return new NullType().fromContext(tc, parent);

        if (tc instanceof MediatorLangParser.TupleTypeContext)
            return new TupleType().fromContext(tc, parent);
        if (tc instanceof MediatorLangParser.InitTypeContext)
            return new InitType().fromContext(tc, parent);
        if (tc instanceof MediatorLangParser.ListTypeContext)
            return new ListType().fromContext(tc, parent);
        if (tc instanceof MediatorLangParser.BracketTypeContext)
            return Type.parse(((MediatorLangParser.BracketTypeContext) tc).type(), parent);
        if (tc instanceof MediatorLangParser.UnionTypeContext)
            return new UnionType().fromContext(tc, parent);
        if (tc instanceof MediatorLangParser.TemplateTypeContext)
            return new TemplateType().fromContext(tc, parent);
        if (tc instanceof MediatorLangParser.AbstractTypeContext)
            return new AbstractType().setParent(parent);

        if (tc instanceof MediatorLangParser.StructTypeContext)
            return new StructType().fromContext(tc, parent);
        if (tc instanceof MediatorLangParser.EnumTypeContext)
            return new EnumType().fromContext(tc, parent);

        throw ValidationException.UnregisteredType(tc.getClass().toString());
    }

    @Override
    default Type copy(RawElement parent) throws ValidationException {
        throw ValidationException.UnderDevelopment();
    }

    @Override
    default Type copy() throws ValidationException {
        return this.copy(this.getParent());
    }

    default Term getInitValue() throws ValidationException {
        throw ValidationException.TypeNotInitialized(this);
    }

    /**
     * default function of extractRawType, returns the copy of itself
     * definition of raw type : no aliases are permitted in so called `raw types`
     * NOTE: anyone who overwrites this function should follow this advice,
     * <b>NO impact is permitted on the original type</b>
     * @return the corresponding raw type
     * @throws ValidationException
     */
    default Type extractRawType() throws ValidationException {
        return this.copy();
    }

    Type refactor(Map<String, Type> typeRewriteMap, Map<String, Term> termRewriteMap) throws ValidationException;

    default boolean isSubtypeOf(Type parentType) {
        return false;
    }

    default boolean isEqualTo(Type anotherType) {
        return this.isSubtypeOf(anotherType) && anotherType.isSubtypeOf(this);
    }
}
