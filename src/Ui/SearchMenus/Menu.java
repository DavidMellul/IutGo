package Ui.SearchMenus;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import Ui.MemberProfile;

public class Menu extends JPanel {

	private static final long serialVersionUID = 4022492925108809830L;
	
	public Menu() {
		super();
		initialize();
	}
	
	private void initialize(){
		setLayout(new BorderLayout(0, 0));
		
		MemberProfile memberProfile = new MemberProfile();
		add(memberProfile, BorderLayout.NORTH);
		
		JPanel searchMenuViewport = new JPanel();
		
		JScrollPane searchMenu = new JScrollPane(searchMenuViewport);
		searchMenuViewport.setLayout(new GridLayout(4, 1, 0, 0));
		
		RelationMenu relationMenu = new RelationMenu();
		searchMenuViewport.add(relationMenu);
		
		searchMenu.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		searchMenu.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(searchMenu, BorderLayout.CENTER);
	}
}
