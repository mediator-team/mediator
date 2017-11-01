package org.fmgroup.mediator.language.type;

import com.sun.org.apache.xml.internal.security.Init;
import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.term.DoubleValue;
import org.fmgroup.mediator.language.term.Term;
import org.fmgroup.mediator.language.term.UtilTerm;

import javax.rmi.CORBA.Util;
import java.util.Map;

public class UtilType {
    public static boolean isFinite(Type type) {
        System.err.println("Unknown Type " + type.getName() + " @" + UtilType.class.toGenericString());
        return false;
    }

    public static Term getInitValue(Type type) throws ValidationException {
        // primitive types
        if (type instanceof DoubleType)
            return(Term) new DoubleValue().setValue(0).setParent(((DoubleType) type).parent);

        if (type instanceof InitType) return ((InitType) type).defaultValue;

        throw ValidationException.TypeNotInitialized(type);
    }

    public static MediatorLangParser.TypeContext getType(MediatorLangParser.TermContext term) {
        return null;
    }

    public static boolean isEqual(MediatorLangParser.TypeContext type0, MediatorLangParser.TypeContext type1) {
        return false;
    }

    public static Type refactor(Type rawType, Map<String, Type> typeRewriteMap, Map<String, Term> termRewriteMap) throws ValidationException {
        if (typeRewriteMap.containsKey(rawType.toString())) {
            return (Type) typeRewriteMap.get(rawType.toString()).clone(rawType.getParent());
        }

        if (rawType instanceof InitType) {
            ((InitType) rawType).defaultValue = UtilTerm.refactor(
                    ((InitType) rawType).defaultValue,
                    termRewriteMap
            );
            ((InitType) rawType).baseType = refactor(((InitType) rawType).baseType, typeRewriteMap, termRewriteMap);
        }

        if (rawType instanceof BoundedIntType) {
            ((BoundedIntType) rawType).upperBound = UtilTerm.refactor(
                    ((BoundedIntType) rawType).upperBound,
                    termRewriteMap
            );

            ((BoundedIntType) rawType).lowerBound = UtilTerm.refactor(
                    ((BoundedIntType) rawType).lowerBound,
                    termRewriteMap
            );
        }

        if (rawType instanceof InterfaceType) {
            // TODO
        }

        // TODO

        return rawType;
    }

    public static Type parse(MediatorLangParser.TypeContext tc, RawElement parent) throws ValidationException {

        if (tc instanceof MediatorLangParser.DoubleTypeContext) {
            return (Type) new DoubleType()
                    .setParent(parent)
                    .fromContext(tc);
        }
        if (tc instanceof MediatorLangParser.BoolTypeContext)
            return (Type) new BoolType()
                    .setParent(parent)
                    .fromContext(tc);
        if (tc instanceof MediatorLangParser.BoundedIntTypeContext)
            return (Type) new BoundedIntType()
                    .setParent(parent)
                    .fromContext(tc);
        if (tc instanceof MediatorLangParser.IntTypeContext)
            return (Type) new IntType()
                    .setParent(parent)
                    .fromContext(tc);
        if (tc instanceof MediatorLangParser.IdTypeContext)
            return (Type) new IdType()
                    .setParent(parent)
                    .fromContext(tc);
        if (tc instanceof MediatorLangParser.NullTypeContext)
            return (Type) new NullType()
                    .setParent(parent)
                    .fromContext(tc);

        if (tc instanceof MediatorLangParser.InitTypeContext)
            return (Type) new InitType()
                    .setParent(parent)
                    .fromContext(tc);
        if (tc instanceof MediatorLangParser.ListTypeContext)
            return (Type) new ListType()
                    .setParent(parent)
                    .fromContext(tc);
        if (tc instanceof MediatorLangParser.BracketTypeContext)
            return UtilType.parse(((MediatorLangParser.BracketTypeContext) tc).type(), parent);
        if (tc instanceof MediatorLangParser.UnionTypeContext)
            return (Type) new UnionType()
                    .setParent(parent)
                    .fromContext(tc);
        if (tc instanceof MediatorLangParser.InterfaceTypeContext)
            return (Type) new InterfaceType()
                    .setParent(parent)
                    .fromContext(tc);
        if (tc instanceof MediatorLangParser.AbstractTypeContext)
            return (Type) new AbstractType().setParent(parent);

        if (tc instanceof MediatorLangParser.StructTypeContext)
            return (Type) new StructType()
                    .setParent(parent)
                    .fromContext(tc);
        if (tc instanceof MediatorLangParser.EnumTypeContext)
            return (Type) new EnumType()
                    .setParent(parent)
                    .fromContext(tc);

        throw ValidationException.UnregisteredType(tc.getClass().toString());
    }
}