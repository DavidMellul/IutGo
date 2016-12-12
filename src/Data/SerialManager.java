package Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Member.Member;
import Online.FTPManager;
import Utils.Util;

public class SerialManager {
	public  static void save (Object o, String fileName){
        ObjectOutputStream oos = null;
        try {
            final FileOutputStream fichier = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(fichier);
            oos.writeObject(o);
            oos.flush();
        } catch (final java.io.IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.flush();
                    oos.close();
                }
            } catch (final IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public  static Object retrieve (String fileName){
        ObjectInputStream ois = null;
        Object o = null;
        try {
            final FileInputStream fichier = new FileInputStream(fileName);
            ois = new ObjectInputStream(fichier);
            o = ois.readObject();
        } catch (final java.io.FileNotFoundException e) {
            e.printStackTrace();
        } catch (final java.io.IOException e) {
            e.printStackTrace();
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (final IOException ex) {
                ex.printStackTrace();

            }
        }
        return o;
    }
    public static ArrayList<Member> getAllMembers() {
    	FTPManager.retrieveAllMembers();
        File[] listOfFiles = new File(Util.getAndCreateAppdataPath()).listFiles();
        ArrayList<Member> list = new ArrayList<Member>();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile() && listOfFiles[i].getName().contains(".dat")) {
               list.add(new Member());
               list.set(list.size()-1, (Member) retrieve(listOfFiles[i].getPath()));
            }
        }
        return list;
    }
}
