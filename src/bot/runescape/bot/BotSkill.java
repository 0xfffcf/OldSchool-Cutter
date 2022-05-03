package bot.runescape.bot;

import bot.runescape.helpers.BankHelper;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.methods.dialogues.Dialogues;
import org.dreambot.api.wrappers.interactive.GameObject;
import org.dreambot.api.wrappers.interactive.Player;

import static org.dreambot.api.methods.MethodProvider.sleepUntil;

/**
 * Bot skills contains the methods that all the type of bot who do skill task can have. <br/>
 * Bot Skill is a singleton. Only one instance of this bot be created.
 *
 * @author 0xfffcf
 * @version 1.1.0
 * @since 1.0.0
 */
public class BotSkill extends Bot {
    private static BotSkill bot = null;

    /**
     * Bot constructor takes a local player.
     *
     * @param localPlayer The player that the bot is running on.
     */
    protected BotSkill(Player localPlayer) {
        super(localPlayer);
    }

    public static BotSkill getBot(Player localPlayer) {
        if (bot == null) {
            bot = new BotSkill(localPlayer);
        }
        return bot;
    }

    /* Class Methods*/

    /**
     * Interact with the object if the conditions are respected.
     * The object must exist and the inventory can not be full.
     * Else, if the conditions aren't true after 100000 ms. It will interact.
     *
     * @param objectInArea The closest object from the local player.
     */
    public void interactObject(GameObject objectInArea, String action) {
        if (objectInArea != null && objectInArea.interact(action)) {
            sleepUntil(() -> !objectInArea.exists() || Inventory.isFull() || Dialogues.canContinue(), 100000);
        }
    }

    /**
     * Bank all the objects in your inventory if the conditions are respected.
     * The x object will be the only item that won't be stored in the bank.
     * Else, if the conditions aren't true after 8000 ms. It will interact.
     */
    public void bankAllExcept(String object) {
        if (BankHelper.isBankUsable()) {
            if (Bank.depositAllExcept(item -> item != null && item.getName().contains(object))) {
                if (sleepUntil(() -> !Inventory.isFull(), 8000)) {
                    if (Bank.close()) {
                        sleepUntil(() -> !Bank.isOpen(), 8000);
                    }
                }
            }
        }
    }
}