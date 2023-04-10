package de.fynn.modules.localisation.control;

import de.fynn.localisation.modell.*;
import de.fynn.modules.localisation.modell.ApplicationLocalisationContainer;
import de.fynn.modules.localisation.modell.LocaleRegister;
import net.minestom.server.entity.Player;
import net.minestom.server.extensions.Extension;

import java.util.HashMap;
import java.util.Locale;

public class LocalisationManager {

    private final static LocalisationManager instance = new LocalisationManager();
    private final HashMap<Extension, LocaleRegister> clientApplicationLocaleRegisterHashMap = new HashMap<>();

    private LocalisationManager() {}

    protected static LocalisationManager registerApplication(Extension clientApplication){
        if (!instance.clientApplicationLocaleRegisterHashMap.containsKey(clientApplication))
            instance.clientApplicationLocaleRegisterHashMap.put(clientApplication, new LocaleRegister());
        return instance;
    }

    public boolean addLocalisation(Extension application, ApplicationLocalisationContainer localisationContainer){
        return this.clientApplicationLocaleRegisterHashMap.get(application).addLocale(localisationContainer);
    }

    public boolean removeLocalisation(Extension clientApplication, Locale locale){
        return this.clientApplicationLocaleRegisterHashMap.get(clientApplication).removeLocale(locale);
    }

    public String localize(Extension clientApplication, String stringIdentifier, Player player){
        return this.clientApplicationLocaleRegisterHashMap.get(clientApplication)
                .getApplicationLocalisationContainer(
                PlayerLocaleManager.getPlayerLocale(player)
                ).getLocalizedString(stringIdentifier);
    }

}
