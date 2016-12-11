package Ui;


import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.UIManager;

import Ui.EditMenus.AccountEditionForm;

@SuppressWarnings("serial")
public class Form extends JFrame {

	private TitleBarForms titleBar;
	private LoginForm panelLogin;
	private AccountCreationForm panelCreation;
	private static Point coords;
	private JButton btnCrerUnCompte;
	
	public Form() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640,480);
		setLocationRelativeTo(null);
		setUndecorated(true);
		getContentPane().setLayout(null);
		getRootPane().registerKeyboardAction(e -> {
            Form.this.dispose();
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
		
		titleBar = new TitleBarForms();
		titleBar.setBounds(0, 0, 640, 40);
		titleBar.addMouseListener(new MouseAdapter() {
			@Override
            public void mousePressed(MouseEvent e) {
                coords = e.getPoint();
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                coords = null;  	
            }
		});
		titleBar.addMouseMotionListener(new MouseAdapter() {
			@Override
            public void mouseDragged(MouseEvent e) {
                Point p = e.getLocationOnScreen();
                Form.this.setLocation((int)(p.getX()-coords.getX()),(int)(p.getY()-coords.getY()));
            }
		});
		titleBar.getBtnClose().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Form.this.dispose();
			}
		});
		titleBar.getBtnMinus().addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				Form.this.setState(ICONIFIED);
			}
		});		
		getContentPane().add(titleBar);
		
		panelLogin = new LoginForm();
		getContentPane().add(panelLogin);
		
		panelCreation = new AccountCreationForm();
		panelCreation.getBtnGoBack().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Timer(0,new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panelLogin.setLocation(panelLogin.getX()+1, panelLogin.getY());
						panelCreation.setLocation(panelLogin.getX()+panelLogin.getWidth(), panelLogin.getY());
						if(panelLogin.getX() == 0)
							((Timer)e.getSource()).stop();
					}
				}).start();
			}
		});
		panelCreation.setLocation(panelCreation.getWidth(), panelCreation.getY());
		getContentPane().add(panelCreation);
		
		
		btnCrerUnCompte = new JButton("Create an account");
		btnCrerUnCompte.setFocusPainted(false);
		btnCrerUnCompte.setBorder(null);
		btnCrerUnCompte.setBounds(340, 298, 135, 23);
		panelLogin.add(btnCrerUnCompte);
		btnCrerUnCompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Timer(0, new ActionListener() {		
					public void actionPerformed(ActionEvent e) {
						panelLogin.setLocation(panelLogin.getX() - 1,panelLogin.getY());
						panelCreation.setLocation(panelLogin.getX()+panelLogin.getWidth(), panelLogin.getY());
						if(panelLogin.getX()+panelLogin.getWidth() == 0) 
							((Timer) e.getSource()).stop();
					}
				}).start();
			}
		});
		btnCrerUnCompte.setContentAreaFilled(false);
		btnCrerUnCompte.setBorderPainted(false);
		btnCrerUnCompte.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
}
