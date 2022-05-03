package bot.runescape.bot;

import com.sun.istack.internal.NotNull;
import org.dreambot.api.Client;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.skills.Skills;
import org.dreambot.api.methods.tabs.Tab;
import org.dreambot.api.methods.tabs.Tabs;
import org.dreambot.api.methods.walking.impl.Walking;
import org.dreambot.api.methods.world.Worlds;
import org.dreambot.api.methods.worldhopper.WorldHopper;
import org.dreambot.api.wrappers.interactive.Player;

import static org.dreambot.api.methods.MethodProvider.sleepUntil;

/**
 * Bot contains the methods that all the type of bot can have. <br/>
 * Bot is a singleton. Only one instance of bot be created.
 *
 * @author 0xfffcf
 * @version 1.1.0
 * @since 1.0.0
 */
public class Bot {
    private static Bot botInstance = null;
    private final Player localPlayer;

    /**
     * Bot constructor takes a local player.
     *
     * @param localPlayer The player that the bot is running on.
     */
    public Bot(Player localPlayer) {
        this.localPlayer = localPlayer;
    }

    /**
     * Create or return an instance of Bot.
     *
     * @param localPlayer The player that the bot is running on.
     * @return An instance of bot. If it is null, it will return a new instance, else the old one.
     */
    public static Bot getBot(Player localPlayer) {
        if (botInstance == null) {
            botInstance = new Bot(localPlayer);
        }
        return botInstance;
    }

    /* Class Function */

    /**
     * Make the local player walks to a certain area. <br/>
     * It will interact if the player is not moving or the distance of the player and the flag is less than 7. <br/>
     * Else, if the conditions aren't true after 5000 ms. It will interact again.
     *
     * @param area The area you want the local player to go.
     */
    public void walkTo(@NotNull Area area) {
        if (Walking.walk(area.getRandomTile())) {
            sleepUntil(() -> {
                boolean isDistanceLessThan7 = localPlayer.distance(Client.getDestination()) < 7;
                boolean isPlayerNotMoving = !localPlayer.isMoving();

                return isDistanceLessThan7 || isPlayerNotMoving;
            }, 5000);
        }
    }

    /**
     * Hop World.
     * Verify if the player is member or not.
     * Filter which world is right for the player.
     */
    public void hopWorld() {
        if (Client.isMembers()) {
            WorldHopper.hopWorld(Worlds.getRandomWorld(
                    worldObject -> !worldObject.isPVP() && worldObject.isMembers() &&worldObject.getMinimumLevel() <= Skills.getTotalLevel()
            ));
        } else {
            WorldHopper.hopWorld(Worlds.getRandomWorld(
                    worldObject -> {
                        boolean isPvp = worldObject.isPVP();
                        boolean isF2P = worldObject.isF2P();
                        boolean isLevelUnder = worldObject.getMinimumLevel() <= Skills.getTotalLevel();

                        return !isPvp && isF2P && isLevelUnder;
                    }
            ));
        }
        if (!Tabs.isOpen(Tab.INVENTORY)) {
            sleepUntil(() -> Tabs.open(Tab.INVENTORY), Calculations.random(40000, 45000));
        }
    }
}