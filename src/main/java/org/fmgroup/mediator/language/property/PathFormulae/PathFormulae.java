package org.fmgroup.mediator.language.property.PathFormulae;

import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.property.BinaryOperatorFormulae;
import org.fmgroup.mediator.language.property.EnumBinaryOperatorTemporal;
import org.fmgroup.mediator.language.property.NotFormulae;
import org.fmgroup.mediator.language.property.StateFormulae.StateFormulae;

public interface PathFormulae extends StateFormulae {
    static PathFormulae parse(MediatorLangParser.PathFormulaeContext context, RawElement parent) throws ValidationException {

        if (context instanceof MediatorLangParser.NotPathFormulaeContext) {
            NotFormulae<PathFormulae> formula = new NotFormulae<PathFormulae>().setParent(parent);
            formula.setFormulae(
                    PathFormulae.parse(
                            ((MediatorLangParser.NotPathFormulaeContext) context).pathFormulae(),
                            formula
                    )
            );

            return formula;
        }
        else if (context instanceof MediatorLangParser.BinaryPathFormulaeContext) {
            BinaryOperatorFormulae<PathFormulae> formulae = new BinaryOperatorFormulae<PathFormulae>().setParent(parent);
            formulae.setOpr(EnumBinaryOperatorTemporal.fromString(((MediatorLangParser.BinaryPathFormulaeContext) context).opr.getText()));
            formulae.setLeft(
                    PathFormulae.parse(((MediatorLangParser.BinaryPathFormulaeContext) context).left, formulae)
            );
            formulae.setRight(
                    PathFormulae.parse(((MediatorLangParser.BinaryPathFormulaeContext) context).right, formulae)
            );
            return formulae;
        }
        else if (context instanceof MediatorLangParser.AllPathFormulaeContext) {
            return new AllPathFormulae().fromContext(context, parent);
        }
        else if (context instanceof MediatorLangParser.ExistsPathFormulaeContext) {
            return new ExistsPathFormulae().fromContext(context, parent);
        }
        else if (context instanceof MediatorLangParser.AtomicPathFormulaeContext) {
            return new AtomicPathFormulae().fromContext(context, parent);
        }
        else if (context instanceof MediatorLangParser.BracketPathFormulaeContext) {
            return PathFormulae.parse(((MediatorLangParser.BracketPathFormulaeContext) context).pathFormulae(), parent);
        }

        throw ValidationException.UnderDevelopment();
    }
}
