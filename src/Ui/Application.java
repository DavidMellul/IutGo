package Ui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;

import Controller.Controller;
import Ui.EditMenus.AccountEditionForm;
import Ui.SearchMenus.Menu;
import Utils.Coordinate;
import Utils.Util;
import fr.unice.iut.info.methodo.maps.MapMarkerDot;
import fr.unice.iut.info.methodo.maps.interfaces.ICoordinate;
import fr.unice.iut.info.methodo.maps.interfaces.MapMarker;


public class Application extends JFrame {

	private static final long serialVersionUID = 773127820785648597L;

	private MapInterfaceTree m_mapViewer;
	private Menu m_menu;
	private AccountEditionForm m_editionPanel;
	
	JLabel lblFocusOnMember;
	private JButton btnFocusCurrentLocation;
	
	private JLabel lblEditAccount;
	private JButton btnEditAccount;
	private JLabel lblAddFriend;
	private JButton btnAddFriend;
	
	public Application() {
		super("Iut Go");
		initialize();
	}
	
	private void initialize(){
		setSize(1000,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		setResizable(false);
		
		
		m_menu = new Menu();
		m_menu.setPreferredSize(new Dimension(195, 600));
		m_menu.setBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		TitleBarForms titleBarForms = new TitleBarForms();
		getContentPane().add(titleBarForms, BorderLayout.NORTH);
				
		m_mapViewer = new MapInterfaceTree("Go");
		
		getContentPane().add(m_menu, BorderLayout.WEST);
		getContentPane().add(m_mapViewer, BorderLayout.CENTER);
		
		btnFocusCurrentLocation = new JButton("");
		btnFocusCurrentLocation.setToolTipText("Display current location");
		btnFocusCurrentLocation.setOpaque(false);
		btnFocusCurrentLocation.setFocusPainted(false);
		btnFocusCurrentLocation.setContentAreaFilled(false);
		btnFocusCurrentLocation.setBorder(null);
		btnFocusCurrentLocation.setBounds(10, 526, 32, 32);
		btnFocusCurrentLocation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! CE CODE EST A METTRE DANS LE MAP CONTROLLER !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				// Pas fait car je ne sais pas si tu aurais accepté que je transforme ton mapController en pattern singleton.
				Coordinate currLocation = Controller.getInstance().getCurrentMember().getLastPosition().getCoordinate();
				MapMarker markerCurrLocation = new MapMarkerDot(Color.BLUE, currLocation.getLat(), currLocation.getLon());
				m_mapViewer.getViewer().addMapMarker(markerCurrLocation);
				m_mapViewer.getViewer().setDisplayPosition((ICoordinate) currLocation, 19);
			}
		});
		btnFocusCurrentLocation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent mv) { lblFocusOnMember.setIcon(Util.darken(lblFocusOnMember.getIcon())); }
			@Override
			public void mouseExited(MouseEvent mv) { lblFocusOnMember.setIcon(Util.brighten(lblFocusOnMember.getIcon())); }
		});
		
		btnEditAccount = new JButton("");
		btnEditAccount.setContentAreaFilled(false);
		btnEditAccount.setOpaque(false);
		btnEditAccount.setBorder(null);
		btnEditAccount.setBorderPainted(false);
		btnEditAccount.setFocusPainted(false);
		btnEditAccount.setBounds(741, 11, 32, 32);
		btnEditAccount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblEditAccount.setVisible(false); btnEditAccount.setVisible(false);
				new Timer(1, new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent e) {
						m_editionPanel.setLocation(m_editionPanel.getX()-1, m_editionPanel.getY());
						if(m_editionPanel.getX() < getWidth()-650) ((Timer) e.getSource()).stop();
					}
				}).start();
			}
		});
		btnEditAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent mv) { lblEditAccount.setIcon(Util.darken(lblEditAccount.getIcon())); }
			@Override
			public void mouseExited(MouseEvent mv) { lblEditAccount.setIcon(Util.brighten(lblEditAccount.getIcon())); }
		});
		
		btnAddFriend = new JButton("");
		btnAddFriend.setOpaque(false);
		btnAddFriend.setFocusPainted(false);
		btnAddFriend.setContentAreaFilled(false);
		btnAddFriend.setBorder(null);
		btnAddFriend.setBorderPainted(false);
		btnAddFriend.setBounds(741, 52, 32, 32);
		btnAddFriend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Ici interface d'ajout d'amis, très simple avec input et sélecteur de relation à 3 niveaux, ballec des cousins et tout le bordel, on va dire amis/famille	
			}
		});
		btnAddFriend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent me) { lblAddFriend.setIcon(Util.darken(lblAddFriend.getIcon())); }
			@Override
			public void mouseExited(MouseEvent me) { lblAddFriend.setIcon(Util.brighten(lblAddFriend.getIcon())); }	
		});
		
		m_mapViewer.getViewer().add(btnAddFriend);
		
		m_mapViewer.getViewer().add(btnEditAccount);
		m_mapViewer.getViewer().add(btnFocusCurrentLocation);
		
		lblFocusOnMember = new JLabel("");
		lblFocusOnMember.setIcon(new ImageIcon(Application.class.getResource("/Resources/icone_currLocation.png")));
		lblFocusOnMember.setFont(new Font("FontAwesome", Font.PLAIN, 19));
		lblFocusOnMember.setBounds(10, 526, 32, 34);
		m_mapViewer.getViewer().add(lblFocusOnMember);
		
		lblEditAccount = new JLabel("");
		lblEditAccount.setIcon(new ImageIcon(Application.class.getResource("/Resources/icone_editAccount.png")));
		lblEditAccount.setBounds(741, 11, 32, 32);
		m_mapViewer.getViewer().add(lblEditAccount);
		
		m_editionPanel = new AccountEditionForm();
		m_editionPanel.setLocation(m_mapViewer.getX()+this.getWidth(), m_mapViewer.getY());
		m_editionPanel.setSize(445,200);
		m_editionPanel.getBtnQuit().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Timer(1, new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent e) {
						m_editionPanel.setLocation(m_editionPanel.getX()+1, m_editionPanel.getY());
						if(m_editionPanel.getX() > getWidth()) {
							lblEditAccount.setVisible(true); btnEditAccount.setVisible(true);
							((Timer) e.getSource()).stop();
						}
					}
				}).start();	
			}
		});
		m_mapViewer.getViewer().add(m_editionPanel);
		
		lblAddFriend = new JLabel("");
		lblAddFriend.setIcon(new ImageIcon(Application.class.getResource("/Resources/icone_addFriend.png")));
		lblAddFriend.setBounds(741, 52, 32, 32);
		m_mapViewer.getViewer().add(lblAddFriend);
	}
	
	public Menu getMenu(){
		return m_menu;
	}
}
