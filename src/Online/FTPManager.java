package Online;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.ArrayList;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import Data.SerialManager;
import Member.Member;
import Utils.Util;

public class FTPManager {
	private static String server = "ftp.dmware.fr";
	private static int port = 21;
	private static String user = "IutGo@dmware.fr";
	private static String pass = "dagovide2306";
	
	private static FTPClient client;
	
	public static void initConnection() {
		client = new FTPClient();
		try {
			client.connect(server,port);
			client.login(user, pass);
			client.enterLocalPassiveMode();
	        client.setFileType(FTP.BINARY_FILE_TYPE);
	        client.setFileTransferMode(FTP.BINARY_FILE_TYPE);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void retrieveMember(int id) {
		String localFilePath = Util.getAndCreateAppdataPath()+File.separator+id+".dat";
		String remoteFilePath = "/members/"+id+".dat";
		try {
			OutputStream output;
            output = new FileOutputStream(localFilePath);
            client.retrieveFile(remoteFilePath,output);
            output.flush();
            output.close();
        } catch (IOException e) {
        	try {
				Files.delete(new File(localFilePath).toPath());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
            e.printStackTrace();
        }
		
	}
	
	public static void uploadMember(Member m) {
		String localFilePath = Util.getAndCreateAppdataPath()+File.separator+m.getId()+".dat";
		String remoteFilePath = "/members/"+m.getId()+".dat";
		
		try {
			FileInputStream fis = new FileInputStream(localFilePath);
	        client.storeFile(remoteFilePath, fis);
	        fis.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void retrieveAllMembers() {
		FTPFile listOfFile[];
		
		try {
			listOfFile = client.listFiles("/members/");
			if(listOfFile != null)
				for( FTPFile f : listOfFile) {
					if(!f.isDirectory() && f.getName().contains(".dat")) {
						retrieveMember(Character.getNumericValue(f.getName().charAt(0)));
					}
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void uploadAllMembers(ArrayList<Member> list) {
		for(Member m : list)
			uploadMember(m);
	}
}
