package bot.runescape.models.location.locationType;

import bot.runescape.models.location.Location;
import org.dreambot.api.methods.map.Area;

/**
 * Grand Exchange class.
 *
 * @author 0xfffcf
 * @version 1.0.0
 * @since 1.1.0
 */
public class GrandExchange extends Location {
    /**
     * Create the Grand Exchange Location.
     *
     * @see Location
     */
    public GrandExchange() {
        super(
                "Grand Exchange",
                new Area(3148, 3473, 3181, 3506, 0)
        );
    }
}
