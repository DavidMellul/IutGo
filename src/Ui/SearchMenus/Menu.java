package Ui.SearchMenus;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import Ui.MemberProfile;
import java.awt.FlowLayout;

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
		searchMenuViewport.setSize(new Dimension(220, 520));
		searchMenuViewport.setMinimumSize(new Dimension(220, 520));
		searchMenuViewport.setMaximumSize(new Dimension(220, 520));
		
		JScrollPane searchMenu = new JScrollPane(searchMenuViewport);
		
		RelationMenu relationMenu = new RelationMenu();
		BorderLayout borderLayout = (BorderLayout) relationMenu.getLayout();
		borderLayout.setVgap(10);
		borderLayout.setHgap(1);
		WrapLayout wl_searchMenuViewport = new WrapLayout();
		wl_searchMenuViewport.setAlignment(FlowLayout.LEFT);
		wl_searchMenuViewport.setVgap(0);
		wl_searchMenuViewport.setHgap(0);
		searchMenuViewport.setLayout(wl_searchMenuViewport);
		searchMenuViewport.add(relationMenu);
		
		RelationMenu relationMenu_1 = new RelationMenu();
		searchMenuViewport.add(relationMenu_1);
		
		searchMenu.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		searchMenu.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(searchMenu, BorderLayout.CENTER);
	}
}
