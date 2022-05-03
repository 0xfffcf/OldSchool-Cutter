package bot.runescape.models.tree;

import bot.runescape.models.tree.treeType.*;

/**
 * Tree Factory class.
 *
 * @author 0xfffcf
 * @version 1.1.0
 * @since 1.0.0
 */
public class TreeFactory {
    /**
     * Factory for the type of tree selected in the WoodCuttingMenu.
     *
     * @param treeType The type of tree got from the GUI.
     * @return A tree object that correspond to the string.
     * @see bot.runescape.tasks.woodCutting.gui.WoodCuttingMenu
     */
    public static Tree getTreeType(String treeType) {
        Tree tree = null;

        switch (treeType) {
            case "Tree":
                tree = new BasicTree();
                break;
            case "Oak":
                tree = new Oak();
                break;
            case "Willow":
                tree = new Willow();
                break;
            case "Yew":
                tree = new Yew();
                break;
            case "Maple":
                tree = new Maple();
                break;
        }
        return tree;
    }
}
