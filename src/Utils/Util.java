package Utils;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Member.Member;

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
	 
	 public static Icon applyFilter(Icon ic, float r, float g, float b) {
			float scales[] = {r,g,b,1f};
			BufferedImage bi = new BufferedImage(ic.getIconWidth(), ic.getIconHeight(), BufferedImage.TYPE_4BYTE_ABGR);
			Graphics gr = bi.createGraphics();
			ic.paintIcon(null, gr, 0, 0);
			
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
	 
	 public static Mood decodeMood(String s) {
		 switch(s.toUpperCase()) {
		 	case "HAPPY":
		 		return Mood.HAPPY;
		 	case "SAD":
		 		return Mood.SAD;
		 	case "PARTY":
		 		return Mood.PARTY;
		 	case "CALM":
		 		return Mood.CALM;
		 	default: break;
		 }
		 return Mood.NO_SPECIAL_MOOD;
	 }
	 
	 public static Icon retrieveMoodIcon(Mood m) {
		 ImageIcon iconToReturn = null;
		 switch(m) {
		 	case HAPPY: iconToReturn = new ImageIcon(Util.class.getResource("/Resources/_smiley_happy.png")); break;
		 	case CALM:	iconToReturn = new ImageIcon(Util.class.getResource("/Resources/_smiley_calm.png"));  break;
		 	case SAD:   iconToReturn = new ImageIcon(Util.class.getResource("/Resources/_smiley_sad.png"));	  break;
		 	case PARTY: iconToReturn = new ImageIcon(Util.class.getResource("/Resources/_smiley_party.png")); break;
		 	case NO_SPECIAL_MOOD: iconToReturn = new ImageIcon(Util.class.getResource("/Resources/_smiley_indifferent.png")); break;
		 	default: break;
		 }
		 return iconToReturn;
	 }
	 
	 public static String getAndCreateAppdataPath() {
		 String appdataPath = getPlatformDependantAppdata()+File.separator+"IutGo";
		 File tryer = new File(appdataPath);
		 if(tryer.exists() == false || tryer.isDirectory() == false)
			 tryer.mkdirs();
		 return appdataPath;
	 }
	 
	 public static String getPlatformDependantAppdata()
	 {
	     String OS = System.getProperty("os.name").toUpperCase();
	     if (OS.contains("WIN"))
	         return System.getenv("APPDATA");
	     else if (OS.contains("MAC"))
	         return System.getProperty("user.home") + "/Library/Application "
	                 + "Support";
	     else if (OS.contains("NUX"))
	         return System.getProperty("user.home");
	     return System.getProperty("user.dir");
	 }
	 
	 public static Member[] memberListToArray(ArrayList<Member> list) {
		 Member[] array = new Member[list.size()];
		 list.toArray(array);
		 return array;
	 }
	 
	 public static void showBrutalErrorAndQuit(String msg) {
		 JOptionPane.showMessageDialog(null, "<html><font color=red>"+msg+"</font></html>", "Iut Go - Error", JOptionPane.ERROR_MESSAGE, null);
	 }
}
