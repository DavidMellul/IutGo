package Ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import Controller.Controller;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class LoginForm extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1424984070958388055L;
	private JLabel lblIutGo;
	private JLabel lblDescription;
	
	private JTextField fieldLogin;
	private JPasswordField fieldPass;
	
	private JLabel lblNomDeCompte;
	private JLabel lblMotDePasse;
	
	JButton btnConnexion;
	JButton btnMotDePasse;
	
	public LoginForm() {
		setLayout(null);
		this.setBackground(new Color(240, 240, 240));
		this.setBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(0, 0, 0)));
		this.setBounds(0, 40, 640, 440);
		this.setLayout(null);
		
		JLabel lblConnexion = new JLabel("<html>\r\n\tC<br />\r\n\tO<br />\r\n\tN<br />\r\n\tN<br />\r\n\tE<br />\r\n\tC<br />\r\n\tT<br />\r\n</html>");
		lblConnexion.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		lblConnexion.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 23));
		lblConnexion.setHorizontalAlignment(SwingConstants.CENTER);
		lblConnexion.setBounds(0, 0, 47, 440);
		add(lblConnexion);
		
		lblNomDeCompte = new JLabel("Login");
		lblNomDeCompte.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblNomDeCompte.setBounds(180, 195, 105, 20);
		this.add(lblNomDeCompte);
		
		lblMotDePasse = new JLabel("Password");
		lblMotDePasse.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblMotDePasse.setBounds(180, 226, 105, 20);
		this.add(lblMotDePasse);
		
		fieldLogin = new JTextField();
		fieldLogin.setToolTipText("");
		fieldLogin.setBounds(295, 196, 157, 20);
		this.add(fieldLogin);
		fieldLogin.setColumns(10);
		
		fieldPass = new JPasswordField();
		fieldPass.setToolTipText("");
		fieldPass.setColumns(10);
		fieldPass.setBounds(295, 227, 157, 20);
		fieldPass.setEchoChar('*');
		this.add(fieldPass);
		
		btnConnexion = new JButton("Connection");
		btnConnexion.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = fieldLogin.getText(); String pass = String.valueOf(fieldPass.getPassword());
				if(!login.isEmpty() && !pass.isEmpty()) {			
					if(Controller.getInstance().canLogMember(login,pass))
						JOptionPane.showMessageDialog(LoginForm.this, "Bienvenue dans votre espace.");	
					else
						JOptionPane.showMessageDialog(LoginForm.this, "Incorrect login or password.");			
				}
				else 
					JOptionPane.showMessageDialog(LoginForm.this, "Incorrect login or password.");
		}});
		btnConnexion.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnConnexion.setBounds(180, 257, 272, 32);
		this.add(btnConnexion);
		
		btnMotDePasse = new JButton("Forgotten password ?");
		btnMotDePasse.setFocusPainted(false);
		btnMotDePasse.setBorder(null);
		btnMotDePasse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fullInput = JOptionPane.showInputDialog(LoginForm.this, "Please type your firstname and lastname separated by a blank.");
				
				if(fullInput.isEmpty() == false) {
					String firstName = fullInput.substring(0,fullInput.indexOf(' '));
					String lastName = fullInput.substring(fullInput.indexOf(' ')+1,fullInput.length());

					String passgivenBack = Controller.getInstance().giveBackPassword(firstName, lastName);
					if(passgivenBack.isEmpty())
						JOptionPane.showMessageDialog(LoginForm.this, "Those informations do not correspond to any account.");
					else
						JOptionPane.showMessageDialog(LoginForm.this, "<html>Password : <strong>"+passgivenBack+"</strong></html>");
				}
			}
		});
		btnMotDePasse.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnMotDePasse.setDefaultCapable(false);
		btnMotDePasse.setContentAreaFilled(false);
		btnMotDePasse.setBorderPainted(false);
		btnMotDePasse.setBounds(150, 299, 171, 23);
		this.add(btnMotDePasse);
		
		lblIutGo = new JLabel("Iut Go");
		lblIutGo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 28));
		lblIutGo.setBounds(180, 107, 105, 32);
		this.add(lblIutGo);
		
		lblDescription = new JLabel("Social network based on a geolocated and interconnected world.");
		lblDescription.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblDescription.setBounds(180, 140, 381, 32);
		this.add(lblDescription);
	}
}
