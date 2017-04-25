package response;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ashershnov
 * Date: 6/28/16
 * Time: 6:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class JSONResponseHelper {
    private int size = 0;
    private JsonArray jsonElements;
    private JsonObject jsonObject;
    private JsonElement jsonElement;
    static Logger log = Logger.getLogger(JSONResponseHelper.class.getName());

    public void parseJSON(String json){
        JsonParser parser = new JsonParser();
        this.jsonElement = parser.parse(json);
        log.debug(jsonElement.getClass());
        if(jsonElement instanceof com.google.gson.JsonObject){
            this.size = ((JsonObject) jsonElement).size();
            this.jsonObject = jsonElement.getAsJsonObject();
        }else if(jsonElement instanceof com.google.gson.JsonArray) {
            JsonArray jsonArr = jsonElement.getAsJsonArray();
            this.jsonElements = jsonArr;
            this.size = jsonArr.size();
        }
    }

    public String getFirstElementValByName(String parentName, String elementName){
        String val = "";
        try{
            if(this.jsonElement instanceof com.google.gson.JsonArray) {
                for (JsonElement jsonElement : jsonElements) {
                    val = jsonElement.getAsJsonObject().get(parentName).getAsJsonObject().get(elementName).getAsString();
                    if(val.length() > 0) break;
                }
            }else if(this.jsonElement instanceof com.google.gson.JsonObject){
                log.debug(jsonElement.getClass());
                for(JsonElement jsonElement : jsonObject.get(parentName).getAsJsonArray()) {
                    val = jsonElement.getAsJsonObject().get(elementName).getAsString();
                    if(val.length() > 0) break;
                }
            }
        }catch(Exception e){
           e.printStackTrace();
        }
        log.debug(val);
        return val;
    }

    public String getFirstElementValByName(String name){
        String val = "";
        try {
            if(this.jsonElement instanceof com.google.gson.JsonArray) {
                for (JsonElement user : jsonElements) {
                    val = user.getAsJsonObject().get(name).getAsString();
                    if(val.length() > 0) break;
                }
            }else if(this.jsonElement instanceof com.google.gson.JsonObject){
                val = jsonObject.get(name).getAsString();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        log.debug(val);
        return val;
    }

    public List<String> getElementValAsArrayByName(String name){
        List resultArr = new ArrayList();
        try {
            for (JsonElement user : jsonElements) {
                resultArr.add(user.getAsJsonObject().get(name).getAsString());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        log.debug(resultArr);
     return  resultArr;
    }

    public int getCountOfResponseRows(){
        return this.size;
    }
}
