package bot.runescape.models.location.locationType;

import bot.runescape.models.location.Location;
import org.dreambot.api.methods.map.Area;


/**
 * Seers Village class.
 *
 * @author 0xfffcf
 * @version 1.0.0
 * @since 1.1.0
 */
public class SeersVillage extends Location {
    /**
     * Create Seers Village Location.
     */
    public SeersVillage() {
        super(
                "Seers Village",
                new Area(2721, 3486, 2727, 3483)
        );
    }
}
