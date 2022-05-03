package bot.runescape.tasks.walker.client;

import bot.runescape.Main;
import bot.runescape.bot.Bot;
import bot.runescape.models.location.LocationFactory;
import bot.runescape.node.Node;
import bot.runescape.tasks.walker.gui.WalkerMenu;
import org.dreambot.api.Client;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.methods.walking.path.impl.LocalPath;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.wrappers.interactive.Player;

import javax.swing.*;

import java.util.Arrays;

import static org.dreambot.api.Client.getLocalPlayer;
import static org.dreambot.api.methods.MethodProvider.log;
import static org.dreambot.api.methods.MethodProvider.sleepUntil;


/**
 * The code that executes when the Walker is selected.
 *
 * @author 0xfffcf
 * @version 1.0.0
 * @see Node
 * @since 1.0.0
 */
public class Walker extends Node {
    private static Walker botInstance = null;
    private final Bot bot;
    private final Player localPlayer;
    private boolean startScript;
    private WalkerMenu gui;

    /**
     * Walker constructor.
     * Initialize localPlayer to your player.
     * Initialize bot via the condition of getBot.
     *
     * @param abstractScript to connect your node to AbstractScript class.
     * @see Node
     * @see bot.runescape.bot.Bot
     */
    private Walker(AbstractScript abstractScript) {
        super(abstractScript);
        localPlayer = getLocalPlayer();
        bot = Bot.getBot(getLocalPlayer());
    }

    /**
     * Create a new instance of Wood Cutting or return the one already created.
     *
     * @param abstractScript to connect your node to AbstractScript class.
     * @return botInstance might be a new instance or one already created.
     * @see Node
     */
    public static Walker getWalker(AbstractScript abstractScript) {
        if (botInstance == null) {
            botInstance = new Walker(abstractScript);
        }
        return botInstance;
    }

    public boolean getStartScript() {
        return startScript;
    }

    public void setStartScript(boolean startScript) {
        this.startScript = startScript;
    }

    /* Class Function */

    /**
     * Create the GUI for the walker.
     *
     * @see WalkerMenu
     */
    public void openMenu() {
        Runnable guiRunnable = () -> {
            gui = new WalkerMenu(this);
            gui.setVisible(true);
        };
        SwingUtilities.invokeLater(guiRunnable);
    }

    /**
     * execute the loop that do the task for the walker task.
     */
    @Override
    public void execute() {
        if (startScript) {
            if (gui.getLocationComboName().equals("Seers Village")) {
                // Made for low level player
                if (localPlayer.getTile().getX() >= 2860) {
                    // Entrance Mountain
                    bot.walkTo(new Area(2872, 3427, 2875, 3422, 0));
                    Tile[] tile = new Tile[]{
                            new Tile(2874, 3429, 0),
                            new Tile(2873, 3433, 0),
                            new Tile(2873, 3437, 0),
                            new Tile(2871, 3440, 0),
                            new Tile(2871, 3444, 0),
                            new Tile(2872, 3448, 0),
                            new Tile(2874, 3451, 0),
                            new Tile(2875, 3455, 0),
                            new Tile(2873, 3459, 0),
                            new Tile(2873, 3463, 0),
                            new Tile(2872, 3466, 0),
                            new Tile(2870, 3470, 0),
                            new Tile(2868, 3474, 0),
                            new Tile(2867, 3478, 0),
                            new Tile(2867, 3482, 0),
                            new Tile(2868, 3485, 0),
                            new Tile(2870, 3488, 0),
                            new Tile(2871, 3491, 0),
                            new Tile(2873, 3494, 0),
                            new Tile(2874, 3497, 0),
                            new Tile(2876, 3501, 0),
                            new Tile(2877, 3504, 0),
                            new Tile(2878, 3508, 0),
                            new Tile(2878, 3512, 0),
                            new Tile(2877, 3516, 0),
                            new Tile(2876, 3519, 0),
                            new Tile(2873, 3522, 0),
                            new Tile(2870, 3523, 0),
                            new Tile(2866, 3525, 0),
                            new Tile(2862, 3525, 0),
                            new Tile(2858, 3525, 0),
                            new Tile(2854, 3526, 0),
                            new Tile(2850, 3526, 0),
                            new Tile(2846, 3527, 0),
                            new Tile(2842, 3527, 0),
                            new Tile(2840, 3527, 0),
                            new Tile(2835, 3527, 0),
                            new Tile(2830, 3526, 0),
                            new Tile(2830, 3526, 0),
                            new Tile(2827, 3527, 0),
                            new Tile(2824, 3527, 0),
                            new Tile(2821, 3526, 0),
                            new Tile(2818, 3524, 0),
                            new Tile(2815, 3522, 0),
                            new Tile(2830, 3526, 0),
                            new Tile(2827, 3527, 0),
                            new Tile(2824, 3527, 0),
                            new Tile(2821, 3526, 0),
                            new Tile(2818, 3524, 0),
                            new Tile(2815, 3522, 0),
                            new Tile(2811, 3522, 0),
                            new Tile(2808, 3521, 0),
                            new Tile(2805, 3521, 0),
                            new Tile(2802, 3521, 0),
                            new Tile(2801, 3518, 0),
                            new Tile(2799, 3517, 0),
                            new Tile(2797, 3515, 0),
                            new Tile(2796, 3513, 0),
                            new Tile(2795, 3510, 0),
                            new Tile(2796, 3507, 0),
                            new Tile(2796, 3503, 0),
                            new Tile(2795, 3500, 0),
                            new Tile(2796, 3497, 0),
                            new Tile(2798, 3496, 0),
                            new Tile(2801, 3495, 0),
                            new Tile(2804, 3495, 0),
                            new Tile(2807, 3495, 0),
                            new Tile(2810, 3496, 0),
                            new Tile(2813, 3498, 0),
                            new Tile(2816, 3499, 0),
                            new Tile(2819, 3499, 0),
                            new Tile(2822, 3497, 0),
                            new Tile(2825, 3495, 0),
                            new Tile(2828, 3495, 0),
                            new Tile(2829, 3493, 0),
                            new Tile(2831, 3491, 0),
                            new Tile(2832, 3488, 0),
                            new Tile(2832, 3485, 0),
                            new Tile(2832, 3482, 0),
                            new Tile(2834, 3480, 0),
                            new Tile(2834, 3477, 0),
                            new Tile(2836, 3477, 0),
                            new Tile(2838, 3476, 0),
                            new Tile(2838, 3473, 0),
                            new Tile(2838, 3470, 0),
                            new Tile(2838, 3467, 0),
                            new Tile(2839, 3465, 0),
                            new Tile(2841, 3463, 0),
                            new Tile(2843, 3463, 0),
                            new Tile(2844, 3461, 0),
                            new Tile(2845, 3459, 0),
                            new Tile(2846, 3456, 0),
                            new Tile(2846, 3453, 0),
                            new Tile(2847, 3450, 0),
                            new Tile(2847, 3448, 0),
                            new Tile(2849, 3449, 0),
                            new Tile(2851, 3447, 0),
                            new Tile(2853, 3445, 0),
                            new Tile(2855, 3443, 0),
                            new Tile(2854, 3441, 0),
                            new Tile(2854, 3439, 0)
                    };
                    LocalPath<Tile> path = new LocalPath<>();
                    path.addAll(Arrays.asList(tile));
                    try {
                        for (Tile ignored : path) {
                            path.walk();
                            sleepUntil(() -> {
                                boolean isPlayerMoving = localPlayer.isMoving();
                                boolean isDistanceLessThan3 = localPlayer.distance(Client.getDestination()) < 3;

                                return !isPlayerMoving || isDistanceLessThan3;
                            }, 8000);
                        }
                    } catch (Exception e) {

                    }
                }
            }
            bot.walkTo(
                    LocationFactory.getLocation(gui.getLocationComboName()).getArea()
            );
        }
    }
}