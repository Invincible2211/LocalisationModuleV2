package de.fynn.modules.localisation.modell;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class LocaleRegister {

    private final HashMap<Locale, ApplicationLocalisationContainer> localisations = new HashMap<>();

    public boolean addLocale(ApplicationLocalisationContainer applicationLocalisationContainer){
        if (localisations.containsKey(applicationLocalisationContainer.getLocale())){
            return false;
        }
        localisations.put(applicationLocalisationContainer.getLocale(), applicationLocalisationContainer);
        return true;
    }

    public boolean removeLocale(Locale locale){
        if (localisations.containsKey(locale))
            return false;
        localisations.remove(locale);
        return true;
    }

    public ApplicationLocalisationContainer getApplicationLocalisationContainer(Locale locale){
        return localisations.get(locale);
    }

    public List<Locale> getSupportedLocales(){
        return localisations.keySet().stream().toList();
    }

}
