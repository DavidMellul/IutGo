<<<<<<< HEAD
package Ui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import Ui.SearchMenus.Menu;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Application extends JFrame {

	private static final long serialVersionUID = 773127820785648597L;

	private MapInterfaceTree m_mapViewer;
	public Application() {
		super("Iut Go");
		
		initialize();
	}
	
	private void initialize(){
		setUndecorated(true);
		setSize(1000,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		setDefaultLookAndFeelDecorated(true);
		setResizable(false);
		
		m_mapViewer = new MapInterfaceTree("Go");
		
		Menu menu = new Menu();
		Dimension menuDimensions = new Dimension(195, 600);
		menu.setPreferredSize(menuDimensions);
		
		getContentPane().add(m_mapViewer, BorderLayout.CENTER);
		getContentPane().add(menu, BorderLayout.WEST);
		
		TitleBarForms titleBarForms = new TitleBarForms();
		getContentPane().add(titleBarForms, BorderLayout.NORTH);
		
	}
	
	public static void main(String[] args){
		new Application().setVisible(true);
	}
}
=======
package Ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Menu;

import javax.swing.JFrame;

public class Application extends JFrame {

	private static final long serialVersionUID = 773127820785648597L;

	private MapInterfaceTree m_mapViewer;
	public Application() {
		super("Iut Go");
		
		initialize();
	}
	
	private void initialize(){
		setSize(1000,600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		setDefaultLookAndFeelDecorated(true);
		setResizable(false);
		
		m_mapViewer = new MapInterfaceTree("Go");
		
		Menu menu = new Menu();
		Dimension menuDimensions = new Dimension(220, 600);
	//	menu.setPreferredSize(menuDimensions);
		
		getContentPane().add(m_mapViewer, BorderLayout.CENTER);
	//	getContentPane().add(menu, BorderLayout.WEST);
	}
	
	public static void main(String[] args){
		new Application().setVisible(true);
	}
}
>>>>>>> branch 'master' of https://github.com/DavidMellul/IutGo.git
