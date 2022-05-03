package bot.runescape.tasks.woodCutting.client;

import bot.runescape.bot.BotWoodCutting;
import bot.runescape.models.tree.TreeFactory;
import bot.runescape.node.Node;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.wrappers.interactive.GameObject;
import org.dreambot.api.wrappers.interactive.Player;
import bot.runescape.models.log.Log;
import bot.runescape.models.tree.Tree;
import bot.runescape.tasks.woodCutting.gui.WoodCuttingMenu;

import javax.swing.*;

import static org.dreambot.api.Client.getLocalPlayer;
import static org.dreambot.api.methods.MethodProvider.sleepUntil;

/**
 * The code that executes when the skill Wood Cutting is selected.
 *
 * @author 0xfffcf
 * @version 1.0.0
 * @see Node
 * @since 1.0.0
 */
public class WoodCutting extends Node {
    private static WoodCutting botInstance = null;
    private final BotWoodCutting bot;
    private final Player localPlayer;
    private boolean startScript;
    private WoodCuttingMenu gui;

    /**
     * WoodCutting constructor.
     * Initialize localPlayer to your player.
     * Initialize bot via the condition of getBot.
     *
     * @param abstractScript to connect your node to AbstractScript class.
     * @see Node
     * @see bot.runescape.bot.Bot
     */
    private WoodCutting(AbstractScript abstractScript) {
        super(abstractScript);
        localPlayer = getLocalPlayer();
        bot = BotWoodCutting.getBot(localPlayer);
    }

    /**
     * Create a new instance of Wood Cutting or return the one already created.
     *
     * @param abstractScript to connect your node to AbstractScript class.
     * @return botInstance might be a new instance or one already created.
     * @see Node
     */
    public static WoodCutting getWoodCutting(AbstractScript abstractScript) {
        if (botInstance == null) {
            botInstance = new WoodCutting(abstractScript);
        }
        return botInstance;
    }

    /**
     * Set if the script is started or not.
     *
     * @param startScript can take true or false.
     */
    public void setStartScript(boolean startScript) {
        this.startScript = startScript;
    }

    /* Class Function */

    /**
     * Create the GUI for the wood cutting.
     *
     * @see WoodCuttingMenu
     */
    public void openMenu() {
        Runnable guiRunnable = () -> {
            gui = new WoodCuttingMenu(this);
            gui.setVisible(true);
        };
        SwingUtilities.invokeLater(guiRunnable);
    }

    /**
     * execute the loop that do the task for the wood cutting skill.
     */
    @Override
    public void execute() {
        if (startScript) {
            Tree tree = TreeFactory.getTreeType(gui.getTreeComboName());
            GameObject treeInArea = bot.getTreeInArea(tree);
            Area treeArea = tree.getTreeArea();
            Log log = new Log(tree.getLog());
            log.setAreLogDrop(gui.getDropLog());

            if (Inventory.isFull()) {
                if (log.getAreLogDrop()) {
                    if (Inventory.dropAllExcept(item -> item.getName().contains(" axe"))) {
                        sleepUntil(Inventory::isEmpty, 9000);
                    }
                } else {
                    Area bankArea = tree.getBankArea();
                    if (bankArea.contains(localPlayer)) {
                        bot.bankAllExcept(" axe");
                    } else {
                        bot.walkTo(bankArea);
                    }
                }
            } else {
                if (treeArea.contains(localPlayer)) {
                    if (treeInArea == null) {
                        bot.hopWorld();
                    } else {
                        bot.interactObject(treeInArea, "Chop down");
                    }
                } else {
                    bot.walkTo(treeArea);
                }
            }
        }
    }
}