package de.fynn.modules.localisation.control;

import net.minestom.server.entity.Player;

import java.util.HashMap;
import java.util.Locale;

public class PlayerLocaleManager {

    private final static HashMap<Player, Locale> currentPlayerLocale = new HashMap<>();

    public static void addPlayer(Player player, Locale locale){
        currentPlayerLocale.put(player, locale);
    }

    public static void updatePlayerLocale(Player player, Locale locale){
        currentPlayerLocale.put(player, locale);
    }

    public static Locale getPlayerLocale(Player player){
        return currentPlayerLocale.get(player);
    }

}
