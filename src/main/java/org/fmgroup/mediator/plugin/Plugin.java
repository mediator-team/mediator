package org.fmgroup.mediator.plugin;

public interface Plugin {
    String getName();

    /**
     * the version of current plugin, should be like `x.x.x`
     * @return
     */
    String getVersion();
    String getDescription();

    /**
     * Since a lot of features are also developed in form of plugins,
     * we do not want users confused by a huge plugin list when they start
     * Mediator. A plugin labelled `built-in` will not be displayed in
     * some places.
     *
     * @return whether you want the plugin displayed as built-in
     */
    default boolean isBuiltIn() {
        return false;
    }
}
