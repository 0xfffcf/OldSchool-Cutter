package bot.runescape.helpers;

import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.methods.interactive.NPCs;
import org.dreambot.api.wrappers.interactive.NPC;

import static org.dreambot.api.methods.MethodProvider.sleepUntil;

/**
 * Helper for the method that interact with the bank.
 *
 * @author 0xfffcf
 * @version 1.0.0
 * @since 1.0.0
 */
public class BankHelper {
    /**
     * Get the closest banker from the player.
     *
     * @return True if the conditions are respected, else false.
     */
    public static boolean isBankUsable() {
        NPC banker = NPCs.closest(npc -> npc != null && npc.hasAction("Bank"));
        return Bank.isOpen() || banker != null
                && banker.interact("Bank")
                && sleepUntil(Bank::isOpen, 9000);
    }
}