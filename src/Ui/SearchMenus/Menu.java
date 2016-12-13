<<<<<<< HEAD
package Ui.SearchMenus;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;

import Ui.Commons.MemberProfile;

public class Menu extends JPanel {

	private static final long serialVersionUID = 4022492925108809830L;
	JPanel searchMenuViewport;
	JScrollPane searchMenu;
	RelationMenu relationMenu;
	InterestMenu interestMenu;
	CarpoolingMenu carpoolingMenu;
	FormationMenu formationMenu;
	private JSlider slider;
	
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
		
		Panel panel = new Panel();
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		slider = new JSlider();
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setMinimum(10);
		panel.add(slider);
		slider.setValue(1);
		slider.setMaximum(5000);
		
		Label label = new Label("1m");
		panel.add(label, BorderLayout.WEST);
		
		Label label_1 = new Label("5000m");
		panel.add(label_1, BorderLayout.EAST);
	}
	
	public RelationMenu getRelationMenu() { return this.relationMenu; }
	public InterestMenu getInterestMenu() { return this.interestMenu; }
	public CarpoolingMenu getCarpoolingMenu() { return this.carpoolingMenu; }
	public FormationMenu getFormationMenu() { return this.formationMenu; }
	public JSlider getRadiusSlider() { return this.slider; }
}
=======
package Ui.SearchMenus;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;

import Ui.Commons.MemberProfile;

public class Menu extends JPanel {

	private static final long serialVersionUID = 4022492925108809830L;
	JPanel searchMenuViewport;
	JScrollPane searchMenu;
	RelationMenu relationMenu;
	InterestMenu interestMenu;
	CarpoolingMenu carpoolingMenu;
	FormationMenu formationMenu;
	private JSlider slider;
	
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
		
		Panel panel = new Panel();
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		slider = new JSlider();
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setMinimum(10);
		panel.add(slider);
		slider.setValue(1);
		slider.setMaximum(5000);
		
		Label label = new Label("1m");
		panel.add(label, BorderLayout.WEST);
		
		Label label_1 = new Label("5000m");
		panel.add(label_1, BorderLayout.EAST);
		setBackground(Color.LIGHT_GRAY);
	}
	
	public RelationMenu getRelationMenu() { return this.relationMenu; }
	public InterestMenu getInterestMenu() { return this.interestMenu; }
	public FormationMenu getFormationMenu() { return this.formationMenu; }
	public JSlider getRadiusSlider() { return this.slider; }
}
>>>>>>> branch 'master' of https://github.com/DavidMellul/IutGo.git
