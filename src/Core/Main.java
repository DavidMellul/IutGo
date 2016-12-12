package Core;


import Controller.Controller;
import Ui.Commons.SplashScreen;
import Online.FTPManager;
import Online.SQLManager;

public class Main {
	public static void main(String args[]) {
		Controller c = Controller.getInstance();
		c.start();
	}
}
