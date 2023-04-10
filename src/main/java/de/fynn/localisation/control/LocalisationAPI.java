package de.fynn.localisation.api;

import de.fynn.localisation.control.LocalisationManager;
import de.fynn.localisation.modell.ApplicationLocalisationContainer;
import de.fynn.localisation.modell.ClientApplication;

public class LocalisationAPI {

    private static LocalisationManager localisationManager;
    private final ClientApplication clientApplication;

    public LocalisationAPI(ClientApplication clientApplication) {
        this.clientApplication = clientApplication;
    }

    public boolean addLocalisation(ApplicationLocalisationContainer localisationContainer){
        return localisationManager.addLocalisation(clientApplication, localisationContainer);
    }

    public boolean removeLocalisation(String locale){
        return localisationManager.removeLocalisation(clientApplication, locale);
    }

    public String localize(String stringIdentifier){
        return localisationManager.localize(clientApplication, stringIdentifier);
    }

    public static String localize(ClientApplication clientApplication, String stringIdentifier){
        return localisationManager.localize(clientApplication, stringIdentifier);
    }

    public ClientApplication getClientApplication() {
        return clientApplication;
    }

    public static void setLocalisationManager(LocalisationManager localisationManager) {
        LocalisationAPI.localisationManager = localisationManager;
    }

}
