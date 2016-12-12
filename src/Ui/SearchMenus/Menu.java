package Ui.SearchMenus;


import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;

import Ui.MemberProfile;

public class Menu extends JPanel {

	private static final long serialVersionUID = 4022492925108809830L;
	JPanel searchMenuViewport;
	JScrollPane searchMenu;
	RelationMenu relationMenu;
	InterestMenu interestMenu;
	CarpoolingMenu carpoolingMenu;
	FormationMenu formationMenu;
	
	public Menu() {
		super();
		setBorder(null);
		initialize();
	}
	
	private void initialize(){
		setLayout(new BorderLayout(0, 0));
		
		MemberProfile memberProfile = new MemberProfile();
		add(memberProfile, BorderLayout.NORTH);
		
		searchMenuViewport = new JPanel();
		searchMenuViewport.setBorder(null);
		searchMenuViewport.setSize(new Dimension(195, 520));
		searchMenuViewport.setMinimumSize(new Dimension(195, 520));
		searchMenuViewport.setMaximumSize(new Dimension(195, 520));
		
		searchMenu = new JScrollPane(searchMenuViewport);
		searchMenu.setViewportBorder(null);
		SpringLayout sl_searchMenuViewport = new SpringLayout();
		searchMenuViewport.setLayout(sl_searchMenuViewport);
		
		relationMenu = new RelationMenu();
		sl_searchMenuViewport.putConstraint(SpringLayout.NORTH, relationMenu, 0, SpringLayout.NORTH, searchMenuViewport);
		sl_searchMenuViewport.putConstraint(SpringLayout.WEST, relationMenu, 0, SpringLayout.WEST, searchMenuViewport);
		sl_searchMenuViewport.putConstraint(SpringLayout.EAST, relationMenu, 0, SpringLayout.EAST, searchMenuViewport);
		searchMenuViewport.add(relationMenu);
		
		interestMenu = new InterestMenu();
		sl_searchMenuViewport.putConstraint(SpringLayout.NORTH, interestMenu, 6, SpringLayout.SOUTH, relationMenu);
		sl_searchMenuViewport.putConstraint(SpringLayout.WEST, interestMenu, 0, SpringLayout.WEST, searchMenuViewport);
		sl_searchMenuViewport.putConstraint(SpringLayout.EAST, interestMenu, 0, SpringLayout.EAST, relationMenu);
		searchMenuViewport.add(interestMenu);
		
		carpoolingMenu = new CarpoolingMenu();
		sl_searchMenuViewport.putConstraint(SpringLayout.NORTH, carpoolingMenu, 6, SpringLayout.SOUTH, interestMenu);
		sl_searchMenuViewport.putConstraint(SpringLayout.WEST, carpoolingMenu, 0, SpringLayout.WEST, searchMenuViewport);
		sl_searchMenuViewport.putConstraint(SpringLayout.EAST, carpoolingMenu, 0, SpringLayout.EAST, relationMenu);
		searchMenuViewport.add(carpoolingMenu);
		
		formationMenu = new FormationMenu();
		sl_searchMenuViewport.putConstraint(SpringLayout.NORTH, formationMenu, 6, SpringLayout.SOUTH, carpoolingMenu);
		sl_searchMenuViewport.putConstraint(SpringLayout.WEST, formationMenu, 0, SpringLayout.WEST, relationMenu);
		sl_searchMenuViewport.putConstraint(SpringLayout.EAST, formationMenu, 0, SpringLayout.EAST, relationMenu);
		searchMenuViewport.add(formationMenu);
		
		
		searchMenu.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		searchMenu.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(searchMenu, BorderLayout.CENTER);
	}
	
	public RelationMenu getRelationMenu() { return this.relationMenu; }
	public InterestMenu getInterestMenu() { return this.interestMenu; }
}
