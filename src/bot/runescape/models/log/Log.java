package bot.runescape.models.log;

/**
 * Log comes from Tree.
 * They are many kind of logs.
 *
 * @author 0xfffcf
 * @version 1.0.0
 * @since 1.0.0
 */
public class Log {
    private boolean areLogDrop = false;
    private LogType logType;

    /**
     * Create a new Log.
     *
     * @param logType A type of log.
     */
    public Log(LogType logType) {
        this.logType = logType;
    }

    /**
     * @return If the log are going to be dropped or be banked.
     */
    public boolean getAreLogDrop() {
        return this.areLogDrop;
    }

    /**
     * @return The type of the Log.
     */
    public LogType getLogType() {
        return logType;
    }

    /**
     * Modify the value of areLogDrop.
     *
     * @see bot.runescape.tasks.woodCutting.gui.WoodCuttingMenu
     * @param areLogDrop The result that comes from WoodCuttingGui.
     *                   Can be Yes or No.
     */
    public void setAreLogDrop(String areLogDrop) {
        if (areLogDrop.equals("Yes")) {
            this.areLogDrop = true;
        }
    }

    /**
     * Modify the value of logType.
     *
     * @param logType Needs to be a type of LogType.
     */
    public void setLogType(LogType logType) {
        this.logType = logType;
    }
}
