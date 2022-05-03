package bot.runescape.models.tree;

/**
 * All the type of tree are here.
 *
 * @author 0xfffcf
 * @version 1.1.0
 * @since 1.0.0
 */
public enum TreeType {
    TREE("Tree"),
    OAK("Oak"),
    WILLOW("Willow"),
    YEW("Yew"),
    MAPLE("Maple tree");

    private final String name;

    /**
     * TreeType constructor, give a name to the tree.
     *
     * @param name The name of the tree.
     */
    TreeType(String name) {
        this.name = name;
    }

    /**
     * @return The name of the tree.
     */
    @Override
    public String toString() {
        return this.name;
    }
}
