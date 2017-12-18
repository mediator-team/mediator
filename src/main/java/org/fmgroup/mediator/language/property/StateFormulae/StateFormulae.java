package org.fmgroup.mediator.language.property.StateFormulae;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.property.BinaryOperatorFormulae;
import org.fmgroup.mediator.language.property.EnumBinaryOperatorTemporal;
import org.fmgroup.mediator.language.property.Formulae;
import org.fmgroup.mediator.language.property.NotFormulae;
import org.fmgroup.mediator.language.property.PathFormulae.PathFormulae;

public interface StateFormulae extends Formulae {
    static StateFormulae parse(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (context instanceof MediatorLangParser.PathStateFormulaeContext) {
            return PathFormulae.parse(
                    ((MediatorLangParser.PathStateFormulaeContext) context).pathFormulae(),
                    parent
            );
        }
        else if (context instanceof MediatorLangParser.NotStateFormulaeContext) {
            NotFormulae<StateFormulae> formulae = new NotFormulae<StateFormulae>().setParent(parent);
            formulae.setFormulae(
                    StateFormulae.parse(
                            ((MediatorLangParser.NotStateFormulaeContext) context).stateFormulae(),
                            formulae
                    )
            );
            return formulae;
        }
        else if (context instanceof MediatorLangParser.BinaryStateFormulaeContext) {
            BinaryOperatorFormulae<StateFormulae> formulae = new BinaryOperatorFormulae<StateFormulae>().setParent(parent);
            formulae.setOpr(EnumBinaryOperatorTemporal.fromString(((MediatorLangParser.BinaryStateFormulaeContext) context).opr.getText()));
            formulae.setLeft(
                    StateFormulae.parse(((MediatorLangParser.BinaryStateFormulaeContext) context).left, formulae)
            );
            formulae.setRight(
                    StateFormulae.parse(((MediatorLangParser.BinaryStateFormulaeContext) context).right, formulae)
            );
            return formulae;
        }
        else if (context instanceof MediatorLangParser.NextStateFormulaeContext) {
            return new NextStateFormulae().fromContext(context, parent);
        }
        else if (context instanceof MediatorLangParser.FinallyStateFormulaeContext) {
            return new FinallyStateFormulae().fromContext(context, parent);
        }
        else if (context instanceof MediatorLangParser.GloballyStateFormulaeContext) {
            return new GloballyStateFormulae().fromContext(context, parent);
        }
        else if (context instanceof MediatorLangParser.UntilStateFormulaeContext) {
            return new UntilStateFormulae().fromContext(context, parent);
        }
        else if (context instanceof MediatorLangParser.BracketStateFormulaeContext) {
            return StateFormulae.parse(((MediatorLangParser.BracketStateFormulaeContext) context).stateFormulae(), parent);
        }

        throw ValidationException.UnderDevelopment();
    }
}
