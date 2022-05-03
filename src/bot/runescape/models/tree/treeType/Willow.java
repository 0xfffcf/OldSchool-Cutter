package bot.runescape.models.tree.treeType;

import bot.runescape.models.log.LogType;
import bot.runescape.models.tree.TreeType;
import bot.runescape.models.tree.Tree;
import org.dreambot.api.methods.map.Area;

/**
 * Willow tree class.
 *
 * @author 0xfffcf
 * @version 1.0.0
 * @since 1.0.0
 */
public class Willow extends Tree {
    /**
     * Create a willow tree and assign it to a specific area.
     *
     * @see Tree
     */
    public Willow() {
        super(
                TreeType.WILLOW,
                new Area(3231, 3244, 3236, 3234),
                new Area(3207, 3217, 3210, 3220, 2),
                LogType.WILLOW
        );
    }
}
