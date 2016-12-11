package Ui.InfoCards;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

import Member.Member;
import Ui.MemberProfile;
import Utils.Util;
import javax.swing.JButton;
import java.awt.Cursor;

public class UserCard extends Card {
	
	private MemberProfile m_profile;
	private JButton btnMinus;
	JLabel lblMood;
	JLabel lblNickname;
	JLabel lblFormation;
	JLabel lblAddress;
	
	public UserCard(Member m) {
		setBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setLayout(null);
		setVisible(true);
				
		m_profile = new MemberProfile();
		m_profile.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		m_profile.setBounds(0, 0, 335, 83);
		m_profile.setVisible(true);
		m_profile.updateProfile(m);
		
		lblMood = new JLabel("");
		lblMood.setBounds(250, 94, 32, 32);
		lblMood.setIcon(Util.retrieveMoodIcon(m.getMood()));
		add(lblMood);
		
		btnMinus = new JButton("\uF068");
		btnMinus.setOpaque(false);
		btnMinus.setFocusPainted(false);
		btnMinus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMinus.setContentAreaFilled(false);
		btnMinus.setBorder(null);
		btnMinus.setBorderPainted(false);
		btnMinus.setBounds(293, 0, 42, 24);
		btnMinus.setFont(new Font("FontAwesome", Font.PLAIN, 12));
		btnMinus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent me) { btnMinus.setForeground(Color.GRAY); }
			@Override
			public void mouseExited(MouseEvent me) { btnMinus.setForeground(Color.BLACK); }
		});
		btnMinus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserCard.this.setVisible(false);
			}
		});
		
		add(btnMinus);
		
		this.add(m_profile);
		m_profile.setVisible(true); m_profile.repaint();
		
		lblNickname = new JLabel("");
		lblNickname.setText(m.getNickname());
		lblNickname.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblNickname.setBounds(10, 94, 184, 14);
		add(lblNickname);
		
		lblAddress = new JLabel("Address");
		lblAddress.setText(m.getAddress().toString());
		lblAddress.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblAddress.setBounds(10, 119, 190, 14);
		add(lblAddress);
		
		lblFormation = new JLabel("Formation");
		lblFormation.setText(m.getFormation().toString());
		lblFormation.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblFormation.setBounds(10, 144, 184, 14);
		add(lblFormation);
		
		repaint();
	}

}
