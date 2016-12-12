package Core;


import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Controller.Controller;
import Utils.LockerMultipleInstances;

public class Main {
	public static void main(String args[]) {
		try {
			new LockerMultipleInstances();
			Controller c = Controller.getInstance();
			c.start();
		}catch(Exception e){ 
			JOptionPane.showMessageDialog(null, "An instance of this program is already running.","Iut Go - Error",JOptionPane.ERROR_MESSAGE,new ImageIcon(Main.class.getResource("/Resources/icone_iutgo_reduced.png")));
			System.exit(0);
		}
	}
}
