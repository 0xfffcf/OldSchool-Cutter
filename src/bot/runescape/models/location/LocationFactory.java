package bot.runescape.models.location;

import bot.runescape.models.location.locationType.GrandExchange;
import bot.runescape.models.location.locationType.SeersVillage;

public class LocationFactory {
    /**
     * Factory for the type of location selected in the Walker Menu.
     *
     * @see bot.runescape.tasks.walker.gui.WalkerMenu
     * @param locationString The location that we got from the menu.
     * @return A Location object that correspond to the string.
     */
    public static Location getLocation(String locationString) {
        Location location = null;

        switch (locationString) {
            case "Grand Exchange":
                location = new GrandExchange();
                break;
            case "Seers Village":
                location = new SeersVillage();
                break;
        }
        return location;
    }
}
