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

public class AccountCreationForm extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7826705477790848021L;
	private JTextField fieldLogin;
	private JTextField fieldPass;
	private JLabel lblNomDeCompte;
	private JLabel lblMotDePasse;
	
	private JButton btnCreation;
	private JLabel lblConfirmationDuMot;
	private JTextField fieldConfirm;
	private JLabel lblNom;
	private JTextField fieldNom;
	private JLabel lblPrenom;
	private JTextField fieldPrenom;
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
		
		JLabel lblConnexion = new JLabel("<html>\r\n\tR<br />\r\n\tE<br />\r\n\tG<br />\r\n\tI<br />\r\n\tS<br />\r\n\tT<br />\r\n\tE<br />\r\n\tR<br />\r\n</html>");
		lblConnexion.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		lblConnexion.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 23));
		lblConnexion.setHorizontalAlignment(SwingConstants.CENTER);
		lblConnexion.setBounds(0, 0, 47, 440);
		add(lblConnexion);
		
		lblNomDeCompte = new JLabel("Nom de compte");
		lblNomDeCompte.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblNomDeCompte.setBounds(180, 195, 105, 20);
		this.add(lblNomDeCompte);
		
		lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblMotDePasse.setBounds(180, 226, 105, 20);
		this.add(lblMotDePasse);
		
		fieldLogin = new JTextField();
		fieldLogin.setToolTipText("");
		fieldLogin.setBounds(295, 196, 223, 20);
		this.add(fieldLogin);
		fieldLogin.setColumns(10);
		
		fieldPass = new JTextField();
		fieldPass.setToolTipText("");
		fieldPass.setColumns(10);
		fieldPass.setBounds(295, 227, 222, 20);
		this.add(fieldPass);
		
		btnCreation = new JButton("Cr\u00E9er mon compte");
		btnCreation.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		btnCreation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!fieldLogin.getText().isEmpty() && !fieldPass.getText().isEmpty() && fieldPass.getText().equals(fieldConfirm.getText()) &&!fieldNom.getText().isEmpty() && !fieldPrenom.getText().isEmpty()) {
					Controller.getInstance().registerMember(fieldLogin.getText(),fieldPass.getText(),fieldNom.getText(),fieldPrenom.getText());
					btnGoBack.doClick();
				}
				else {
					JOptionPane.showMessageDialog(AccountCreationForm.this, "Veuillez saisir correctement toutes les informations nécessaires.");
				}
			}
		});
		btnCreation.setBounds(182, 299, 336, 32);
		btnCreation.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.add(btnCreation);
		
		lblConfirmationDuMot = new JLabel("Confirmation");
		lblConfirmationDuMot.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblConfirmationDuMot.setBounds(178, 256, 154, 20);
		add(lblConfirmationDuMot);
		
		fieldConfirm = new JTextField();
		fieldConfirm.setToolTipText("");
		fieldConfirm.setColumns(10);
		fieldConfirm.setBounds(295, 257, 221, 20);
		add(fieldConfirm);
		
		lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblNom.setBounds(180, 163, 41, 20);
		add(lblNom);
		
		fieldNom = new JTextField();
		fieldNom.setToolTipText("");
		fieldNom.setColumns(10);
		fieldNom.setBounds(217, 164, 119, 20);
		add(fieldNom);
		
		lblPrenom = new JLabel("Pr\u00E9nom");
		lblPrenom.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblPrenom.setBounds(351, 163, 49, 20);
		add(lblPrenom);
		
		fieldPrenom = new JTextField();
		fieldPrenom.setToolTipText("");
		fieldPrenom.setColumns(10);
		fieldPrenom.setBounds(402, 164, 116, 20);
		add(fieldPrenom);
		
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
