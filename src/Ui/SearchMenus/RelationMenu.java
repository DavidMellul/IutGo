package Ui.SearchMenus;


import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Controllers.MapController;
import Utils.Mood;
import Utils.Util;

public class RelationMenu extends AbstractMenu implements ActionListener {

	private static final long serialVersionUID = -2909777947917236544L;
	private JComboBox<String> m_comboBox;
	private JPanel m_moodPanel;
	private JCheckBox m_calmMood;
	private JCheckBox m_happyMood;
	private JCheckBox m_sadMood;
	private JCheckBox m_partyMood;
	private JLabel m_lblMood;
	
	private Mood m_selectedMood;

	public RelationMenu() {
		super("Search for relations", false);
	}

	@Override
	protected void initialize() {
		m_comboBox = new JComboBox<String>();
		m_comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"friends", "family"}));
		m_searchFilters.add(m_comboBox, BorderLayout.SOUTH);
		
		m_lblMood = new JLabel("Mood");
		m_lblMood.setFont(new Font("Tahoma", Font.PLAIN, 15));
		m_lblMood.setHorizontalTextPosition(SwingConstants.CENTER);
		m_lblMood.setHorizontalAlignment(SwingConstants.CENTER);
		m_searchFilters.add(m_lblMood, BorderLayout.NORTH);
		
		m_moodPanel = new JPanel();
		m_searchFilters.add(m_moodPanel, BorderLayout.CENTER);
		m_moodPanel.setLayout(new GridLayout(1, 4, 10, 10));
		
		m_calmMood = new JCheckBox("");
		m_calmMood.setSelectedIcon(new ImageIcon(RelationMenu.class.getResource("/Resources/_smiley_calm.png")));
		m_calmMood.setIcon(new ImageIcon(RelationMenu.class.getResource("/Resources/_smiley_calm_u.png")));
		m_calmMood.setHorizontalTextPosition(SwingConstants.CENTER);
		m_calmMood.setHorizontalAlignment(SwingConstants.CENTER);
		m_calmMood.addActionListener(this);
		m_calmMood.setToolTipText("Calm");
		m_moodPanel.add(m_calmMood);
		
		m_happyMood = new JCheckBox("");
		m_happyMood.setSelectedIcon(new ImageIcon(RelationMenu.class.getResource("/Resources/_smiley_happy.png")));
		m_happyMood.setIcon(new ImageIcon(RelationMenu.class.getResource("/Resources/_smiley_happy_u.png")));
		m_happyMood.setHorizontalTextPosition(SwingConstants.CENTER);
		m_happyMood.setHorizontalAlignment(SwingConstants.CENTER);
		m_happyMood.setToolTipText("Happy");
		m_happyMood.addActionListener(this);

		m_moodPanel.add(m_happyMood);
		
		m_sadMood = new JCheckBox("");
		m_sadMood.setSelectedIcon(new ImageIcon(RelationMenu.class.getResource("/Resources/_smiley_sad.png")));
		m_sadMood.setIcon(new ImageIcon(RelationMenu.class.getResource("/Resources/_smiley_sad_u.png")));
		m_sadMood.setHorizontalTextPosition(SwingConstants.CENTER);
		m_sadMood.setHorizontalAlignment(SwingConstants.CENTER);
		m_sadMood.setToolTipText("Sad");
		m_sadMood.addActionListener(this);

		m_moodPanel.add(m_sadMood);
		
		m_partyMood = new JCheckBox("");
		m_partyMood.setSelectedIcon(new ImageIcon(RelationMenu.class.getResource("/Resources/_smiley_party.png")));
		m_partyMood.setIcon(new ImageIcon(RelationMenu.class.getResource("/Resources/_smiley_party_u.png")));
		m_partyMood.setHorizontalTextPosition(SwingConstants.CENTER);
		m_partyMood.setHorizontalAlignment(SwingConstants.CENTER);
		m_partyMood.addActionListener(this);
		m_partyMood.setToolTipText("Party");
		m_moodPanel.add(m_partyMood);
	}
	
	public JComboBox<String> getComboBox() { return this.m_comboBox; }
	public Mood getCurrentSelectedMood() { return this.m_selectedMood; }

	@Override
	public void actionPerformed(ActionEvent e) {
		JCheckBox chck = (JCheckBox)e.getSource();
		m_selectedMood = Util.decodeMood(chck.getToolTipText());
		MapController.getInstance().showRelationMembersByBood((String) m_comboBox.getSelectedItem(), m_selectedMood, chck.isSelected());
	}

}
