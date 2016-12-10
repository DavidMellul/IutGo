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
import javax.swing.ImageIcon;

public class AccountCreationForm extends JPanel{
	private static final long serialVersionUID = -7826705477790848021L;
	
	private JTextField fieldLogin;
	private JPasswordField fieldPass;
	private JPasswordField fieldConfirm;
	private JLabel lblNomDeCompte;
	private JLabel lblMotDePasse;
	
	private JButton btnCreation;
	private JLabel lblConfirmationDuMot;
	private JLabel lblNom;
	private JTextField fieldLastname;
	private JLabel lblPrenom;
	private JTextField fieldFirstname;
	private JLabel lblRegisterToIut;
	private JLabel lblArrowBack;
	private JLabel lblGoBack;
	
	private JButton btnGoBack;
	
	public AccountCreationForm() {
		setLayout(null);
		this.setBackground(new Color(240, 240, 240));
		this.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(0, 0, 0)));
		this.setBounds(0, 40, 640, 440);
		this.setLayout(null);
		
		btnGoBack = new JButton("");
		btnGoBack.setBorderPainted(false);
		btnGoBack.setContentAreaFilled(false);
		btnGoBack.setFocusPainted(false);
		btnGoBack.setOpaque(false);
		btnGoBack.setBounds(57, 11, 28, 32);
		btnGoBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(btnGoBack);
		
		JLabel lblConnexion = new JLabel("");
		lblConnexion.setIcon(new ImageIcon(AccountCreationForm.class.getResource("/Resources/registerSideBar.png")));
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
		lblMotDePasse.setBounds(180, 226, 62, 20);
		this.add(lblMotDePasse);
		
		fieldLogin = new JTextField();
		fieldLogin.setToolTipText("");
		fieldLogin.setBounds(252, 196, 223, 20);
		this.add(fieldLogin);
		fieldLogin.setColumns(10);
		
		fieldPass = new JPasswordField();
		fieldPass.setToolTipText("");
		fieldPass.setColumns(10);
		fieldPass.setBounds(252, 226, 222, 20);
		fieldPass.setEchoChar('*');
		this.add(fieldPass);
		
		btnCreation = new JButton("Create my account");
		btnCreation.setBackground(new Color(0, 0, 0));
		btnCreation.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		btnCreation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = fieldLogin.getText(); String pass = String.valueOf(fieldPass.getPassword()); String confirm = String.valueOf(fieldConfirm.getPassword());
				if(!login.isEmpty() && !pass.isEmpty() && confirm.equals(pass)) {
					Controller.getInstance().registerMember(login,pass,fieldLastname.getText(),fieldFirstname.getText());
					btnGoBack.doClick();
					fieldLogin.setText(""); fieldPass.setText(""); fieldConfirm.setText(""); fieldLastname.setText(""); fieldFirstname.setText("");
				}
				else {
					JOptionPane.showMessageDialog(AccountCreationForm.this, "Please fill in all the required informations.");
				}
			}
		});
		btnCreation.setBounds(252, 299, 223, 32);
		btnCreation.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.add(btnCreation);
		
		lblConfirmationDuMot = new JLabel("Repeat password");
		lblConfirmationDuMot.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblConfirmationDuMot.setBounds(137, 257, 105, 20);
		add(lblConfirmationDuMot);
		
		fieldConfirm = new JPasswordField();
		fieldConfirm.setToolTipText("");
		fieldConfirm.setColumns(10);
		fieldConfirm.setBounds(252, 257, 221, 20);
		fieldConfirm.setEchoChar('*');
		add(fieldConfirm);
		
		lblNom = new JLabel("Last name");
		lblNom.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblNom.setBounds(180, 163, 74, 20);
		add(lblNom);
		
		fieldLastname = new JTextField();
		fieldLastname.setToolTipText("");
		fieldLastname.setColumns(10);
		fieldLastname.setBounds(252, 164, 84, 20);
		add(fieldLastname);
		
		lblPrenom = new JLabel("First name");
		lblPrenom.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblPrenom.setBounds(346, 163, 62, 20);
		add(lblPrenom);
		
		fieldFirstname = new JTextField();
		fieldFirstname.setToolTipText("");
		fieldFirstname.setColumns(10);
		fieldFirstname.setBounds(414, 164, 61, 20);
		add(fieldFirstname);
		
		lblRegisterToIut = new JLabel("Register to Iut Go and join all your friends, we can build something together.");
		lblRegisterToIut.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblRegisterToIut.setBounds(132, 116, 461, 32);
		add(lblRegisterToIut);
		
		lblArrowBack = new JLabel("\uF190");
		lblArrowBack.setFont(new Font("FontAwesome", Font.PLAIN, 30));
		lblArrowBack.setBounds(57, 11, 28, 32);
		add(lblArrowBack);
		
		lblGoBack = new JLabel("Go back");
		lblGoBack.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblGoBack.setBounds(89, 20, 74, 14);
		add(lblGoBack);
	}
	
	public JButton getBtnGoBack() { return this.btnGoBack; }
}
