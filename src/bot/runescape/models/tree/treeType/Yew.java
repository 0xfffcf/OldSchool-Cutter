package bot.runescape.models.tree.treeType;

import bot.runescape.models.log.LogType;
import bot.runescape.models.tree.Tree;
import bot.runescape.models.tree.TreeType;
import org.dreambot.api.methods.map.Area;


/**
 * Willow tree class.
 *
 * @author 0xfffcf
 * @version 1.0.0
 * @since 1.1.0
 */
public class Yew extends Tree {
    /**
     * Create a new Yew Tree.
     *
     * @see Tree
     */
    public Yew() {
        super(
                TreeType.YEW,
                new Area(3203, 3506, 3224, 3498, 0),
                new Area(3168, 3493,  3161, 3486, 0),
                LogType.YEW
                );
    }
}
