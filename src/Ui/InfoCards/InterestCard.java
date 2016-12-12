package Ui.InfoCards;

import java.awt.Font;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Interests.InterestPoint;

public class InterestCard extends Card {

	private static final long serialVersionUID = -3407588193024804740L;

	public InterestCard() {
		super();
		m_btnMinus.setBounds(240, 0, 42, 24);
		getBtnMinus().setBounds(240, 0, 42, 24);
		setSize(280, 320);
		
		JLabel label = new JLabel("\uf05a");
		label.setBounds(11, 11, 99, 99);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("FontAwesome", Font.PLAIN, 99));
		
		JLabel lblUndefined = new JLabel("UNDEFINED");
		lblUndefined.setBounds(116, 30, 151, 49);
		lblUndefined.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		add(getBtnMinus());
		add(m_btnMinus);
		setLayout(null);
		add(label);
		add(lblUndefined);
		
		JLabel lblUndefenied = new JLabel("UNDEFENIED");
		lblUndefenied.setBounds(11, 121, 256, 75);
		lblUndefenied.setFont(new Font("Tw Cen MT", Font.PLAIN, 13));
		lblUndefenied.setVerticalAlignment(SwingConstants.TOP);
		lblUndefenied.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblUndefenied);
	}
	
	public void showInterestPoint( InterestPoint p_point, Point p_position){
		setLocation(p_position);
	}
}
