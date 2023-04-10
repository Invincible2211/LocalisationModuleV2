package de.fynn.modules.localisation.control;

import de.fynn.modules.localisation.modell.ApplicationLocalisationContainer;
import net.minestom.server.entity.Player;
import net.minestom.server.extensions.Extension;

import java.util.Locale;

public class LocalisationAPI {

    private LocalisationManager localisationManager;
    private final Extension clientApplication;

    public LocalisationAPI(Extension clientApplication) {
        this.clientApplication = clientApplication;
        localisationManager = LocalisationManager.registerApplication(clientApplication);
    }

    public boolean addLocalisation(ApplicationLocalisationContainer localisationContainer){
        return localisationManager.addLocalisation(clientApplication, localisationContainer);
    }

    public boolean removeLocalisation(Locale locale){
        return localisationManager.removeLocalisation(clientApplication, locale);
    }

    public String localize(String stringIdentifier, Player player){
        return localisationManager.localize(clientApplication, stringIdentifier, player);
    }

}
