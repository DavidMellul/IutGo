package Ui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import Ui.SearchMenus.Menu;

public class Application extends JFrame {

	private static final long serialVersionUID = 773127820785648597L;

	private MapInterfaceTree m_mapViewer;
	private Menu m_menu;
	
	public Application() {
		super("Iut Go");
		initialize();
	}
	
	private void initialize(){
		setUndecorated(true);
		setSize(1000,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		setResizable(false);
		
		m_mapViewer = new MapInterfaceTree("Go");
		
		m_menu = new Menu();
		m_menu.setPreferredSize(new Dimension(195, 600));
		
		getContentPane().add(m_mapViewer, BorderLayout.CENTER);
		getContentPane().add(m_menu, BorderLayout.WEST);
		
		TitleBarForms titleBarForms = new TitleBarForms();
		getContentPane().add(titleBarForms, BorderLayout.NORTH);
	}
	
	public static void main(String[] args){
		new Application().setVisible(true);
	}
	
	public MapInterfaceTree getMapViewer(){
		return m_mapViewer;
	}
	
	public Menu getMenu(){
		return m_menu;
	}
}
