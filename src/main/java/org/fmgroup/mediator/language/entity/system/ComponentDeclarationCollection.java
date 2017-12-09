package org.fmgroup.mediator.language.entity.system;

import org.antlr.v4.runtime.ParserRuleContext;
import org.fmgroup.mediator.common.UtilCode;
import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.language.generated.MediatorLangParser;
import org.fmgroup.mediator.language.scope.DeclarationCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ComponentDeclarationCollection implements DeclarationCollection<ComponentDeclaration> {

    private RawElement parent = null;
    private List<ComponentDeclaration> declarationList = new ArrayList<>();

    /**
     * parses a context, basically a `components` segment and add all the component declarations to this object
     * **NOTE** different from other fromContext functions, it is designed to be executed several times. So if you
     * want to CommandGenerate a brand new ComponentDeclarationCollection, please manually create a new instance and call
     * fromContext again
     *
     * @param context
     * @param parent
     * @return
     * @throws ValidationException
     */
    @Override
    public ComponentDeclarationCollection fromContext(ParserRuleContext context, RawElement parent) throws ValidationException {
        if (!(context instanceof MediatorLangParser.ComponentSegmentContext)) {
            throw ValidationException.IncompatibleContextType(this.getClass(), "ComponentSegmentContext", context.toString());
        }

        if (this.parent != null && !this.parent.equals(parent)) {
            throw ValidationException.FromMessage("Cannot combine component segment from different systems.");
        }
        setParent(parent);

        for (MediatorLangParser.ComponentDeclContext comp : ((MediatorLangParser.ComponentSegmentContext) context).componentDecl()) {
            addDeclaration(new ComponentDeclaration().fromContext(comp, this));
        }

        return this;
    }

    @Override
    public String toString() {
        if (declarationList.size() == 0) return "";
        else {
            return String.format(
                    "declarationList {\n%s}\n",
                    UtilCode.addIndent(
                            declarationList.stream().map(
                                    componentDeclaration -> componentDeclaration.toString() + ";\n"
                            ).collect(Collectors.joining()),
                            1
                    )
            );
        }
    }

    @Override
    public RawElement getParent() {
        return parent;
    }

    @Override
    public ComponentDeclarationCollection setParent(RawElement parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public List<ComponentDeclaration> getDeclarationList() {
        return declarationList;
    }

    @Override
    public DeclarationCollection<ComponentDeclaration> addDeclaration(ComponentDeclaration declaration) {
        this.declarationList.add(declaration);
        declaration.setParent(this);
        return this;
    }

    @Override
    public DeclarationCollection<ComponentDeclaration> setDeclarationList(List<ComponentDeclaration> declarationList) {
        this.declarationList = new ArrayList<>();
        declarationList.forEach(this::addDeclaration);
        return this;
    }
}
