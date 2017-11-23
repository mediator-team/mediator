package org.fmgroup.mediator.core.project;

public class ProjectException extends Exception {

    public ProjectException(String msg) {
        super(msg);
    }

    public static ProjectException ProjectNotFound(String projectPath) {
        return new ProjectException(
                String.format(
                        "project %s not found.",
                        projectPath
                )
        );
    }
}
