package Ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

public class TitleBarForms extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8792583867779037608L;
	JLabel labelCroix;
	JLabel labelMinus;
	JLabel logo;
	JLabel lblIutgo;
	JButton btnClose;
	JButton btnMinus;
	
	public TitleBarForms() {
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setBounds(new Rectangle(0, 0, 640, 0));
		setLayout(null);
		
		labelCroix = new JLabel("\uF00D");
		labelCroix.setFont(new Font("FontAwesome", Font.BOLD, 24));
		labelCroix.setBounds(609, 10, 20, 20);
		add(labelCroix);
		
		labelMinus = new JLabel("\uF068");
		labelMinus.setFont(new Font("FontAwesome", Font.PLAIN, 22));
		labelMinus.setBounds(586, 16, 20, 14);
		add(labelMinus);
		
		logo = new JLabel("\uF279 ");
		logo.setFont(new Font("FontAwesome", Font.PLAIN, 21));
		logo.setBounds(11, 10, 26, 23);
		add(logo);
		
		lblIutgo = new JLabel("IutGo");
		lblIutgo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		lblIutgo.setBounds(40, 8, 158, 26);
		add(lblIutgo);
		
		btnClose = new JButton();
		btnClose.setContentAreaFilled(false);
		btnClose.setOpaque(false);
		btnClose.setFocusPainted(false);
		btnClose.setBorderPainted(false);
		btnClose.setBounds(609, 10, 20, 20);
		add(btnClose);
		
		
		btnMinus = new JButton();
		btnMinus.setContentAreaFilled(false);
		btnMinus.setOpaque(false);
		btnMinus.setFocusPainted(false);
		btnMinus.setBorderPainted(false);
		btnMinus.setBounds(586, 16, 20, 14);
		add(btnMinus);
	}
	
	public JButton getBtnClose() {
		return this.btnClose;
	}
	
	public JButton getBtnMinus() {
		return this.btnMinus;
	}
}
