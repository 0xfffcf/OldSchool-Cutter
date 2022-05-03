package bot.runescape;

import bot.runescape.menu.Menu;
import bot.runescape.tasks.walker.client.Walker;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import bot.runescape.node.Node;
import bot.runescape.tasks.woodCutting.client.WoodCutting;

import javax.swing.*;

/**
 * The main class where everything run.
 *
 * @see AbstractScript
 * @author 0xfffcf
 * @version 1.1.0
 * @since 1.0.0
 */
@ScriptManifest(
        name = "Runescape Bot",
        author = "Sofia",
        version = 1.0,
        category = Category.MISC,
        image = "p6p96rL.png"
)
public class Main extends AbstractScript {
    private Menu menu;
    private final Node[] tasks = new Node[] {
            WoodCutting.getWoodCutting(this),
            Walker.getWalker(this)
    };

    /**
     * @see Menu
     * Create a new menu when the script starts.
     */
    public void onStart() {
        Runnable menuRunnable = () -> {
            menu = new Menu(this);
            menu.setVisible(true);
        };
        SwingUtilities.invokeLater(menuRunnable);
    }

    /**
     * Iterate through the tasks every second.
     * @return Run every 1000 ms (every second)
     */
    @Override
    public int onLoop() {
        for (final Node node : tasks) {
            node.execute();
        }
        return 1000;
    }
}
