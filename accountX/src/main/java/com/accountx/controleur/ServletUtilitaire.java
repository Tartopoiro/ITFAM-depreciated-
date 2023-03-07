package com.accountx.controleur;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

public class ServletUtilitaire {




// ------------------------------ AUTOCOMPLETE / JSON ----------------------------------------------------------------
    //Prend une liste d'objet dont les attributs sont concatener pour en faire la source de la fonction autocomplete JQuery
    public static JSONArray listToAutoComplete (List<?> list) throws JSONException, IllegalAccessException {
        String[] array = new String[list.size()];


        for (int i =0; i<list.size(); i++) {
            Object object = list.get(i);
            String ligne ="";
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields){
                field.setAccessible(true);
                String attribut ="";
                if (field.get(object) != null) {
                    attribut = field.get(object).toString();
                    ligne = ligne + attribut + " ";
                }
            }
            array[i]=ligne;
        }

        JSONArray jsonArray = new JSONArray(array);
        return jsonArray;
    }

    //Check si une String est composant d'un JSONArray
    public static boolean stringInJSONArray(String searchString, JSONArray jsonArray) throws JSONException {
        for (int i = 0; i < jsonArray.length(); i++) {
            if (jsonArray.getString(i).equals(searchString)) {
                return true;
            }
        }
        return false;
    }
}
