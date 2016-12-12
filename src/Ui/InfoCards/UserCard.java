package Ui.InfoCards;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

import Member.Member;
import Ui.MemberProfile;
import Utils.Util;

public class UserCard extends Card {

	private static final long serialVersionUID = 3857208498235487680L;
	private MemberProfile m_profile;
	private JLabel m_lblMood;
	private JLabel m_lblNickname;
	private JLabel m_lblFormation;
	private JLabel m_lblAddress;

	public UserCard() {
		super();
		m_lblMood = new JLabel("");
		m_lblMood.setBounds(242, 35, 32, 32);
		add(m_lblMood);

		m_lblNickname = new JLabel("");
		m_lblNickname.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		m_lblNickname.setBounds(10, 94, 184, 14);
		add(m_lblNickname);

		m_lblAddress = new JLabel("Address");
		m_lblAddress.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		m_lblAddress.setBounds(10, 119, 190, 14);
		add(m_lblAddress);

		m_lblFormation = new JLabel("Formation");
		m_lblFormation.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		m_lblFormation.setBounds(10, 144, 184, 14);
		add(m_lblFormation);

		m_profile = new MemberProfile();
		m_profile.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		m_profile.setBounds(0, 0, 280, 83);
		m_profile.setVisible(true);
		// m_profile.updateProfile(m);

		this.add(m_profile);
		m_profile.setVisible(true);
		m_profile.repaint();
	}

	public void showMember(Member p_member, Point p_position) {
		setLocation(p_position);
		m_lblMood.setIcon(Util.retrieveMoodIcon(p_member.getMood()));
		m_lblNickname.setText(p_member.getNickname());
		m_lblAddress.setText(p_member.getAddress().toString());
		m_lblFormation.setText(p_member.getFormation().toString());
		m_profile.updateProfile(p_member);
		m_profile.repaint();
	}

}
