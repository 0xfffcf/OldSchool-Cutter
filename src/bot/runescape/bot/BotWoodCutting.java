package bot.runescape.bot;

import bot.runescape.models.tree.Tree;
import org.dreambot.api.methods.interactive.GameObjects;
import org.dreambot.api.wrappers.interactive.GameObject;
import org.dreambot.api.wrappers.interactive.Player;

/**
 * BotWoodCutting contains the methods that concern the wood cutting skills. <br/>
 * It is basically a bot with the capability to chop tree, so it extends Bot.
 *
 * @author 0xfffcf
 * @version 1.1.0
 * @since 1.0.0
 */
public class BotWoodCutting extends BotSkill {
    private static BotWoodCutting botInstance = null;

    /**
     * BotWoodCutting constructor takes a local player.
     *
     * @param localPlayer being the player that the bot is running on.
     */
    private BotWoodCutting(Player localPlayer) {
        super(localPlayer);
    }

    /**
     * Create or return an instance of BotWoodCutting.
     *
     * @param localPlayer The player that the bot is running on.
     * @return botInstance if not null return the old one, else a new one.
     */
    public static BotWoodCutting getBot(Player localPlayer) {
        if (botInstance == null) {
            botInstance = new BotWoodCutting(localPlayer);
        }
        return botInstance;
    }

    public GameObject getTreeInArea(Tree tree) {
        return (GameObjects.closest(
                gameObject -> {
                    boolean isTreeNameRight = gameObject.getName().equals(tree.getName().toString());
                    boolean isDistanceLess30 = gameObject.distance() < 30;
                    boolean isActionChop = gameObject.hasAction("Chop down");

                    return isTreeNameRight && isDistanceLess30 && isActionChop;
                }
        ));
    }
}