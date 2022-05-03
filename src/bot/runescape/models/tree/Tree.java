package bot.runescape.models.tree;

import bot.runescape.models.log.LogType;
import org.dreambot.api.methods.map.Area;

/**
 * Create a new Tree which has different attribute.
 *
 * @author 0xfffcf
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class Tree {
    private TreeType name;
    private Area treeArea;
    private Area bankArea;
    private LogType log;

    /**
     * Create a new Tree.
     *
     * @param name The name of the tree.
     * @param treeArea The area of the tree.
     * @param bankArea The bank area of the tree.
     * @param log The log that it will drop.
     */
    public Tree(TreeType name, Area treeArea, Area bankArea, LogType log) {
        this.name = name;
        this.treeArea = treeArea;
        this.bankArea = bankArea;
        this.log = log;
    }

    /**
     * @return The name of that tree.
     */
    public TreeType getName() {
        return name;
    }

    /**
     * @return The area of that tree.
     */
    public Area getTreeArea() {
        return treeArea;
    }

    /**
     * @return The bank area of that tree.
     */
    public Area getBankArea() {
        return bankArea;
    }

    /**
     * @return The type of logs it drops.
     */
    public LogType getLog() {
        return log;
    }

    /**
     * Set the name of the Tree.
     *
     * @param name The name of that tree.
     */
    public void setName(TreeType name) {
        this.name = name;
    }

    /**
     * Set the tree area of that tree.
     *
     * @param treeArea The area of that tree.
     */
    public void setTreeArea(Area treeArea) {
        this.treeArea = treeArea;
    }

    /**
     * Set the bank area of that tree.
     *
     * @param bankArea The bank area of that tree.
     */
    public void setBankArea(Area bankArea) {
        this.bankArea = bankArea;
    }

    /**
     * Set the type of logs that it drops.
     *
     * @param log The type of logs that it drops.
     */
    public void setLog(LogType log) {
        this.log = log;
    }

    /**
     * @return All the information about that tree.
     */
    public String toString() {
        return this.name + " " + this.treeArea + " " + this.bankArea + " " + this.log;
    }
}