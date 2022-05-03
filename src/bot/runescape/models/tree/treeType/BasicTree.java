package bot.runescape.models.tree.treeType;

import bot.runescape.models.log.LogType;
import bot.runescape.models.tree.TreeType;
import bot.runescape.models.tree.Tree;
import org.dreambot.api.methods.map.Area;


/**
 * Basic tree class.
 *
 * @author 0xfffcf
 * @version 1.0.0
 * @since 1.0.0
 */
public class BasicTree extends Tree {
    /**
     * Create a basic tree and assign it to a specific area.
     *
     * @see Tree
     */
    public BasicTree() {
        super(
                TreeType.TREE,
                new Area(3171, 3449, 3145, 3462),
                new Area(3185, 3447, 3180, 3434),
                LogType.TREE
        );
    }
}