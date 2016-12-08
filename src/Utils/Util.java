package Utils;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Util {
	 public static List<String> getProhibitedWords(){
	        JSONParser parser = new JSONParser();
	        try {
	            Object obj = null;
	            try {
	                obj = parser.parse(new FileReader("../Resources/filter_word.json"));
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
	 
	 public static Icon darken(Icon ic) {
			float scales[] = {0.5f,0.5f,0.5f,1f};
			BufferedImage bi = new BufferedImage(ic.getIconWidth(), ic.getIconHeight(), BufferedImage.TYPE_4BYTE_ABGR);
			Graphics g = bi.createGraphics();
			ic.paintIcon(null, g, 0, 0);
			
			RescaleOp rsop = new RescaleOp(scales, new float[4], null);
			bi = rsop.filter(bi, null);
			ic = new ImageIcon(bi);
			return ic;
	 }
	 
	 public static Icon brighten(Icon ic) {
			float scales[] = {2f,2f,2f,1f};
			BufferedImage bi = new BufferedImage(ic.getIconWidth(), ic.getIconHeight(), BufferedImage.TYPE_4BYTE_ABGR);
			Graphics g = bi.createGraphics();
			ic.paintIcon(null, g, 0, 0);
			
			RescaleOp rsop = new RescaleOp(scales, new float[4], null);
			bi = rsop.filter(bi, null);
			ic = new ImageIcon(bi);
			return ic;
	}
}
