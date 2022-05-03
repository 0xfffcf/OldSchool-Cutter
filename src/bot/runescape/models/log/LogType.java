package bot.runescape.models.log;


/**
 * Contains all the specific type of Log possible.
 *
 * @author 0xfffcf
 * @version 1.0.0
 * @since 1.0.0
 */
public enum LogType {
    TREE("Logs"),
    OAK("Oak logs"),
    WILLOW("Willow logs"),
    YEW("Yew logs"),
    MAPLE("Maple logs");

    public final String name;

    /**
     * Set the name of to element to his given one.
     *
     * @param name The String name of the element.
     */
    LogType(String name) {
        this.name = name;
    }

    /**
     * @return Only the name of the Log.
     */
    @Override
    public String toString() {
        return this.name;
    }
}
