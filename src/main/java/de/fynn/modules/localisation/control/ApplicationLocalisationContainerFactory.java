package de.fynn.modules.localisation.control;

import de.fynn.modules.localisation.modell.ApplicationLocalisationContainer;
import de.fynn.modules.localisation.modell.exception.FileFormatNotSupportedException;
import de.fynn.modules.localisation.modell.exception.FileTypeNotSupportedException;
import de.fynn.modules.localisation.modell.exception.UnfinishedFactoryException;
import net.minestom.server.MinecraftServer;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;

public class ApplicationLocalisationContainerFactory {

    private ApplicationLocalisationContainer localisationContainer;

    private ApplicationLocalisationContainerFactory() {
    }

    public static ApplicationLocalisationContainerFactory getFactory() {
        return new ApplicationLocalisationContainerFactory();
    }

    public ApplicationLocalisationContainerFactory newContainer(Locale locale) {
        localisationContainer = new ApplicationLocalisationContainer(locale);
        return this;
    }

    public ApplicationLocalisationContainerFactory loadContentFromJSONFile(File file) throws FileFormatNotSupportedException, FileTypeNotSupportedException, IOException {
        return this.insertContent(JSONFileHelper.loadFile(file));
    }

    public ApplicationLocalisationContainerFactory insertContent(HashMap<String, String> localizedContent) {
        localisationContainer.addContent(localizedContent);
        return this;
    }

    public ApplicationLocalisationContainer build() {
        if (localisationContainer == null)
            try {
                throw new UnfinishedFactoryException();
            } catch (UnfinishedFactoryException e) {
                MinecraftServer.LOGGER.error(e.getMessage());
            }
        return localisationContainer;
    }

}
