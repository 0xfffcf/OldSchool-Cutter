package bot.runescape.models.tree.treeType;

import bot.runescape.models.log.LogType;
import bot.runescape.models.tree.TreeType;
import bot.runescape.models.tree.Tree;
import org.dreambot.api.methods.map.Area;

/**
 * Oak tree class.
 *
 * @author 0xfffcf
 * @version 1.0.0
 * @since 1.0.0
 */
public class Oak extends Tree {
    /**
     * Create an oak tree and assign it to a specific area.
     *
     * @see Tree
     */
    public Oak() {
        super(
                TreeType.OAK,
                new Area(3159, 3410, 3170, 3423),
                new Area(3185, 3447, 3180, 3434),
                LogType.OAK
        );
    }
}
