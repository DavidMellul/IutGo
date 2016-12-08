package Utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Util {
	 public static List<String> getProhibitedWords(){
	        JSONParser parser = new JSONParser();
	        try {
	            Object obj = null;
	            try {
	                obj = parser.parse(new FileReader("./src/Resources/filter_word.json"));
	            } catch (IOException e1) {
	                e1.printStackTrace();
	            } catch (ParseException e1) {
	                e1.printStackTrace();
	            }

	            JSONObject jsonObject = (JSONObject) obj;
	            @SuppressWarnings("unchecked")
				List<String> badWord = (List<String>) jsonObject.get("badword");
	            return badWord;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
}
