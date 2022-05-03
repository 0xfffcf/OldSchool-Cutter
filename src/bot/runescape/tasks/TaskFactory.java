package bot.runescape.tasks;

import bot.runescape.Main;
import bot.runescape.node.Node;
import bot.runescape.tasks.walker.client.Walker;
import bot.runescape.tasks.woodCutting.client.WoodCutting;


/**
 * TaskFactory class.
 *
 * @author 0xfffcf
 * @version 1.1.0
 * @since 1.1.0
 */
public class TaskFactory {
    /**
     * Factory for the type of task selected in the Main Menu.
     *
     * @see bot.runescape.menu.Menu
     * @param taskString The task that we got from the menu.
     * @return A task object that correspond to the string.
     */
    public static Node getTask(String taskString, Main main) {
        Node task = null;

        switch (taskString) {
            case "Walker":
                task = Walker.getWalker(main);
                break;
            case "Wood Cutting":
                task = WoodCutting.getWoodCutting(main);
                break;
        }
        return task;
    }
}
