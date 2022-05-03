package bot.runescape.node;

import org.dreambot.api.script.AbstractScript;

/**
 * Node is an Abstract class it has a construct and execute method.
 *
 * @author 0xfffcf
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class Node {
    protected AbstractScript abstractScript;

    /**
     * Create a new Node.
     * @param abstractScript The script that needs to run.
     */
    public Node(AbstractScript abstractScript) {
        this.abstractScript = abstractScript;
    }

    /**
     * Execute the code that need to run.
     */
    public abstract void execute();

    public abstract void openMenu();
}
