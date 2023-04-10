package de.fynn.modules.localisation;

import de.fynn.modules.localisation.control.eventListener.PlayerJoinListener;
import net.minestom.server.MinecraftServer;
import net.minestom.server.event.GlobalEventHandler;
import net.minestom.server.event.player.PlayerLoginEvent;
import net.minestom.server.extensions.Extension;

public class LocalisationModuleV2 extends Extension {

    @Override
    public void initialize() {
        registerListeners();
    }

    @Override
    public void terminate() {

    }

    private void registerListeners(){
        GlobalEventHandler globalEventHandler = MinecraftServer.getGlobalEventHandler();
        globalEventHandler.addListener(PlayerLoginEvent.class, event -> {
            PlayerJoinListener.onPlayerJoin(event);
        });
    }

}
