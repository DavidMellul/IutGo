package Ui.EditMenus;

import javax.swing.JPanel;

import Ui.MemberProfile;

public class AccountEditionForm extends JPanel {

	private MemberProfile m_memberProfile;
	
	public AccountEditionForm() {
		setLayout(null);
		
		this.m_memberProfile = new MemberProfile();
		m_memberProfile.setBounds(0, 0, 450, 81);
		add(this.m_memberProfile);
	}

}
