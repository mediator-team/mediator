package org.fmgroup.mediator.language.scope;

import org.fmgroup.mediator.generator.framework.UtilCode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VariableDeclarationCollection implements Declarations {

    public List<VariableDeclaration> vardecls = new ArrayList<>();

    public VariableDeclarationCollection() { }

    @Override
    public List<Declaration> getDeclarationList() {
        return new ArrayList<>(vardecls);
    }

    @Override
    public String toString() {
        if (vardecls.size() > 0) {
            return String.format(
                    "variables {\n %s}\n",
                    UtilCode.addIndent(
                            vardecls.stream().map(
                                    vardecl -> vardecl.toString() + ";\n"
                            ).collect(Collectors.joining("")),
                            1
                    )
            );
        } else
            return "";
    }
}
