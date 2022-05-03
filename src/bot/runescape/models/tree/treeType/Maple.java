package bot.runescape.models.tree.treeType;

import bot.runescape.models.log.LogType;
import bot.runescape.models.tree.Tree;
import bot.runescape.models.tree.TreeType;
import org.dreambot.api.methods.map.Area;


/**
 * Basic tree class.
 *
 * @author 0xfffcf
 * @version 1.0.0
 * @since 1.1.0
 */
public class Maple extends Tree {
    /**
     * Create a Maple.
     *
     * @see Tree
     */
    public Maple() {
        super(
                TreeType.MAPLE,
                new Area(2734, 3498, 2720, 3503, 0),
                new Area(2722, 3490, 2730, 3493, 0),
                LogType.MAPLE
        );
    }
}
