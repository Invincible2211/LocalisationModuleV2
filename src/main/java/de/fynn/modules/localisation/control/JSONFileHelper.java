package de.fynn.modules.localisation.control;

import de.fynn.modules.localisation.modell.exception.FileFormatNotSupportedException;
import de.fynn.modules.localisation.modell.exception.FileTypeNotSupportedException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class JSONFileHelper {

    protected static HashMap<String,String> loadFile(File jsonFile) throws FileFormatNotSupportedException, FileTypeNotSupportedException, IOException {
        if (!jsonFile.getName().endsWith("json")){
            throw new FileTypeNotSupportedException();
        }
        JSONParser jsonParser = new JSONParser();
        try {
            JSONArray jsonArray = (JSONArray) jsonParser.parse(new BufferedReader(new FileReader(jsonFile)));
            HashMap<String,String> localizedContent = new HashMap<>();
            for (Object object:
                 jsonArray) {
                JSONObject value = (JSONObject) object;
                String stringIdentifier = (String) value.keySet().toArray()[0];
                localizedContent.put(stringIdentifier, (String) value.get(stringIdentifier));
            }
            return localizedContent;
        } catch (ParseException e) {
            throw new FileFormatNotSupportedException();
        }
    }

}
