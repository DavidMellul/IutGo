package Ui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;

import Controllers.Controller;
import Controllers.MapController;
import Ui.EditMenus.AccountEditionForm;
import Ui.EditMenus.FriendAdditionForm;
import Ui.SearchMenus.Menu;
import Utils.Util;


public class Application extends JFrame {

	private static final long serialVersionUID = 773127820785648597L;

	private MapInterfaceTree m_mapViewer;
	private Menu m_menu;
	private AccountEditionForm m_editionPanel;
	private FriendAdditionForm m_additionPanel;
	
	private JLabel lblFocusOnMember;
	private JButton btnFocusCurrentLocation;
	
	private JLabel lblEditAccount;
	private JButton btnEditAccount;
	private JLabel lblAddFriend;
	private JButton btnAddFriend;
	
	private Point coords;
	
	private LogBar feedBar;
	private JLabel lblUnzoom;
	private JButton btnUnzoom;
	private JLabel lblHome;
	private JButton btnHome;
	
	public Application() {
		super("Iut Go");
		initialize();
	}
	
	private void initialize(){
		setSize(1000,675);
		setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Application.class.getResource("/Resources/icone_iutgo.png")));
		getContentPane().setLayout(new BorderLayout());
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		setResizable(false);
		
		m_menu = new Menu();
		m_menu.setPreferredSize(new Dimension(190, 600));
		m_menu.setBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(0, 0, 0)));
		m_menu.getRelationMenu().getCheckbox().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean visible = ((JCheckBox)e.getSource()).isSelected();
				MapController.getInstance().showRelationMembers((String)m_menu.getRelationMenu().getComboBox().getSelectedItem(), visible);
			}
		});
		m_menu.getInterestMenu().getCheckbox().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean visible = ((JCheckBox)e.getSource()).isSelected();
				float p_radius = ((float)m_menu.getRadiusSlider().getValue())/1000f;
				String nameFilter = m_menu.getInterestMenu().getNameFilter().getText();
				float note = Float.parseFloat(m_menu.getInterestMenu().getRater().getRating().toString());
				MapController.getInstance().showPointOfInterest(p_radius, nameFilter, note, visible);
			}
		});
		
		TitleBarForms titleBarForms = new TitleBarForms();
		titleBarForms.addMouseListener(new MouseAdapter() {
			@Override
            public void mousePressed(MouseEvent e) {
                coords = e.getPoint();
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                coords = null;  	
            }
		});
		titleBarForms.addMouseMotionListener(new MouseAdapter() {
			@Override
            public void mouseDragged(MouseEvent e) {
                Point p = e.getLocationOnScreen();
                Application.this.setLocation((int)(p.getX()-coords.getX()),(int)(p.getY()-coords.getY()));
            }
		});
		titleBarForms.getBtnClose().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnHome.doClick();
			}
		});
		titleBarForms.getBtnMinus().addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				Application.this.setState(ICONIFIED);
			}
		});	
		
		getRootPane().registerKeyboardAction(e -> {
            btnHome.doClick();
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
		
		getContentPane().add(titleBarForms, BorderLayout.NORTH);
				
		m_mapViewer = new MapInterfaceTree("Go");
		m_mapViewer.getViewer().setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(0, 0, 0)));
		
		getContentPane().add(m_menu, BorderLayout.WEST);
		getContentPane().add(m_mapViewer, BorderLayout.CENTER);
		
		btnFocusCurrentLocation = new JButton("");
		btnFocusCurrentLocation.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFocusCurrentLocation.setToolTipText("Display current location");
		btnFocusCurrentLocation.setOpaque(false);
		btnFocusCurrentLocation.setFocusPainted(false);
		btnFocusCurrentLocation.setContentAreaFilled(false);
		btnFocusCurrentLocation.setBorder(null);
		btnFocusCurrentLocation.setBounds(10, 565, 32, 34);
		btnFocusCurrentLocation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MapController.getInstance().showAndFitOnCurrentPosition();
			}
		});
		btnFocusCurrentLocation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent mv) { lblFocusOnMember.setIcon(Util.darken(lblFocusOnMember.getIcon())); }
			@Override
			public void mouseExited(MouseEvent mv) { lblFocusOnMember.setIcon(Util.brighten(lblFocusOnMember.getIcon())); }
		});
		
		btnEditAccount = new JButton("");
		btnEditAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditAccount.setToolTipText("Edit account");
		btnEditAccount.setContentAreaFilled(false);
		btnEditAccount.setOpaque(false);
		btnEditAccount.setBorder(null);
		btnEditAccount.setBorderPainted(false);
		btnEditAccount.setFocusPainted(false);
		btnEditAccount.setBounds(763, 9, 32, 32);
		btnEditAccount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblEditAccount.setVisible(false); btnEditAccount.setVisible(false);
				new Timer(0, new ActionListener() {					
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
		btnAddFriend.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAddFriend.setToolTipText("Add relation");
		btnAddFriend.setOpaque(false);
		btnAddFriend.setFocusPainted(false);
		btnAddFriend.setContentAreaFilled(false);
		btnAddFriend.setBorder(null);
		btnAddFriend.setBorderPainted(false);
		btnAddFriend.setBounds(763, 52, 32, 32);
		btnAddFriend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnAddFriend.setVisible(false);
				lblAddFriend.setVisible(false);
				new Timer(5,new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						m_additionPanel.setLocation(m_additionPanel.getX(), m_additionPanel.getY()+1);
						if(m_additionPanel.getY() > 15) ((Timer)e.getSource()).stop();
					}
				}).start();
			}
		});
		btnAddFriend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent me) { lblAddFriend.setIcon(Util.darken(lblAddFriend.getIcon())); }
			@Override
			public void mouseExited(MouseEvent me) { lblAddFriend.setIcon(Util.brighten(lblAddFriend.getIcon())); }	
		});
		
		btnUnzoom = new JButton("");
		btnUnzoom.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUnzoom.setToolTipText("Unzoom");
		btnUnzoom.setBorderPainted(false);
		btnUnzoom.setBorder(null);
		btnUnzoom.setContentAreaFilled(false);
		btnUnzoom.setFocusPainted(false);
		btnUnzoom.setBounds(763, 565, 32, 32);
		btnUnzoom.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LogBar.getInstance().showCommonFeedBack("You've juste unzoomed the map.");
				m_mapViewer.getViewer().setZoom(2);
			}
		});
		btnUnzoom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent me) { lblUnzoom.setIcon(Util.darken(lblUnzoom.getIcon())); }
			@Override
			public void mouseExited(MouseEvent me) { lblUnzoom.setIcon(Util.brighten(lblUnzoom.getIcon())); }
		});
		
		btnHome = new JButton("");
		btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHome.setToolTipText("Disconnect");
		btnHome.setFocusPainted(false);
		btnHome.setContentAreaFilled(false);
		btnHome.setBorder(null);
		btnHome.setBorderPainted(false);
		btnHome.setBounds(52, 565, 32, 32);
		btnHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Controller.getInstance().disconnectUser();
			}
		});
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent me) { lblHome.setIcon(Util.darken(lblHome.getIcon())); }
			@Override
			public void mouseExited(MouseEvent me) { lblHome.setIcon(Util.brighten(lblHome.getIcon())); }
		});
		m_mapViewer.getViewer().add(btnHome);
		m_mapViewer.getViewer().add(btnUnzoom);
		
		m_mapViewer.getViewer().add(btnAddFriend);
		
		m_mapViewer.getViewer().add(btnEditAccount);
		m_mapViewer.getViewer().add(btnFocusCurrentLocation);
		
		lblFocusOnMember = new JLabel("");
		lblFocusOnMember.setIcon(new ImageIcon(Application.class.getResource("/Resources/icone_currLocation.png")));
		lblFocusOnMember.setFont(new Font("FontAwesome", Font.PLAIN, 19));
		lblFocusOnMember.setBounds(10, 565, 32, 34);
		m_mapViewer.getViewer().add(lblFocusOnMember);
		
		lblEditAccount = new JLabel("");
		lblEditAccount.setIcon(new ImageIcon(Application.class.getResource("/Resources/icone_editAccount.png")));
		lblEditAccount.setBounds(763, 9, 32, 32);
		m_mapViewer.getViewer().add(lblEditAccount);
		
		m_editionPanel = new AccountEditionForm();
		m_editionPanel.setLocation(m_mapViewer.getX()+this.getWidth(), m_mapViewer.getY());
		m_editionPanel.setSize(445,200);
		m_editionPanel.getBtnQuit().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Timer(0, new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent e) {
						m_editionPanel.setLocation(m_editionPanel.getX()+1, m_editionPanel.getY());
						if(m_editionPanel.getX() > getWidth()) {
							lblEditAccount.setVisible(true); btnEditAccount.setVisible(true); lblEditAccount.setVisible(true);
							((Timer) e.getSource()).stop();
						}
					}
				}).start();	
			}
		});
		m_mapViewer.getViewer().add(m_editionPanel);
		
		lblAddFriend = new JLabel("");
		lblAddFriend.setIcon(new ImageIcon(Application.class.getResource("/Resources/icone_addFriend.png")));
		lblAddFriend.setBounds(763, 52, 32, 32);
		m_mapViewer.getViewer().add(lblAddFriend);
		
		m_additionPanel = new FriendAdditionForm();
		m_additionPanel.setBounds(m_mapViewer.getX()+this.getWidth()/5, -80, 340, 65);
		m_additionPanel.getBtnReduce().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Timer(2,new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						m_additionPanel.setLocation(m_additionPanel.getX(), m_additionPanel.getY() -1);
						if(m_additionPanel.getY() == -80) { ((Timer)e.getSource()).stop(); btnAddFriend.setVisible(true); lblAddFriend.setVisible(true);}
					}
				}).start();
			}
		});
		m_mapViewer.getViewer().add(m_additionPanel);
		
		feedBar = LogBar.getInstance();
		feedBar.setBounds(0,610,350,25);
		m_mapViewer.getViewer().add(feedBar);
		
		lblUnzoom = new JLabel("");
		lblUnzoom.setIcon(new ImageIcon(Application.class.getResource("/Resources/icone_maxUnzoom.png")));
		lblUnzoom.setBounds(763, 565, 32, 32);
		m_mapViewer.getViewer().add(lblUnzoom);
		
		lblHome = new JLabel("");
		lblHome.setIcon(new ImageIcon(Application.class.getResource("/Resources/icone_disconnect.png")));
		lblHome.setBounds(52, 565, 32, 32);
		m_mapViewer.getViewer().add(lblHome);
	}
	
	public Menu getMenu(){
		return m_menu;
	}
}
