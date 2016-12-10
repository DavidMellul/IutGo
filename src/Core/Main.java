package Core;


import Controller.Controller;

public class Main {
	public static void main(String args[]) {
		Controller c = Controller.getInstance();
		c.start();
	}
}
