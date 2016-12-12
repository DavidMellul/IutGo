package Core;


import Controller.Controller;
import Online.FTPManager;
import Online.SQLManager;
import Ui.Commons.SplashScreen;

public class Main {
	public static void main(String args[]) {
		Controller c = Controller.getInstance();
		c.start();
	}
}
