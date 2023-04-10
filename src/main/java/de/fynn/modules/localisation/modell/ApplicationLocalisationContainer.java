package de.fynn.modules.localisation.modell;

import java.util.HashMap;
import java.util.Locale;

public class ApplicationLocalisationContainer {

    private final Locale locale;
    private final HashMap<String,String> localizedContent = new HashMap<>();


    public ApplicationLocalisationContainer(Locale locale) {
        this.locale = locale;
    }
    public ApplicationLocalisationContainer(Locale locale, HashMap<String,String> localizedContent) {
        this.locale = locale;
        this.addContent(localizedContent);
    }

    public void addContent(HashMap<String,String> localizedContent){
        this.localizedContent.putAll(localizedContent);
    }

    public Locale getLocale() {
        return locale;
    }

    public String getLocalizedString(String identifier){
        return this.localizedContent.get(identifier);
    }

}
