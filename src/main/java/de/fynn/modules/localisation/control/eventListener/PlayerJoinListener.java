package de.fynn.modules.localisation.control.eventListener;

import de.fynn.modules.localisation.control.PlayerLocaleManager;
import net.minestom.server.event.player.PlayerLoginEvent;
import org.jetbrains.annotations.NotNull;

public class PlayerJoinListener {
    public static void onPlayerJoin(@NotNull PlayerLoginEvent loginEvent){
        PlayerLocaleManager.addPlayer(loginEvent.getPlayer(), loginEvent.getPlayer().getLocale());
    }
}
