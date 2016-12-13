package Ui.SearchMenus;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class CarpoolingMenu extends AbstractMenu {

	private static final long serialVersionUID = -102475531927956419L;
	private JLabel m_lblMood;
	private JPanel m_moodPanel;
	private JCheckBox m_calmMood;
	private JCheckBox m_happyMood;
	private JCheckBox m_sadMood;
	private JCheckBox m_partyMood;
	private JPanel m_txtPanel;
	private JPanel m_startPanel;
	private JPanel m_destPanel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField mStart;
	private JTextField mDest;

	public CarpoolingMenu() {
		super("Search for carpooling", false);
	}

	@Override
	protected void initialize() {
		m_searchFilters.setLayout(new BorderLayout(0, 0));
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
		m_moodPanel.add(m_calmMood);

		m_happyMood = new JCheckBox("");
		m_happyMood.setSelectedIcon(new ImageIcon(RelationMenu.class.getResource("/Resources/_smiley_happy.png")));
		m_happyMood.setIcon(new ImageIcon(RelationMenu.class.getResource("/Resources/_smiley_happy_u.png")));
		m_happyMood.setHorizontalTextPosition(SwingConstants.CENTER);
		m_happyMood.setHorizontalAlignment(SwingConstants.CENTER);
		m_moodPanel.add(m_happyMood);

		m_sadMood = new JCheckBox("");
		m_sadMood.setSelectedIcon(new ImageIcon(RelationMenu.class.getResource("/Resources/_smiley_sad.png")));
		m_sadMood.setIcon(new ImageIcon(RelationMenu.class.getResource("/Resources/_smiley_sad_u.png")));
		m_sadMood.setHorizontalTextPosition(SwingConstants.CENTER);
		m_sadMood.setHorizontalAlignment(SwingConstants.CENTER);
		m_moodPanel.add(m_sadMood);

		m_partyMood = new JCheckBox("");
		m_partyMood.setSelectedIcon(new ImageIcon(RelationMenu.class.getResource("/Resources/_smiley_party.png")));
		m_partyMood.setIcon(new ImageIcon(RelationMenu.class.getResource("/Resources/_smiley_party_u.png")));
		m_partyMood.setHorizontalTextPosition(SwingConstants.CENTER);
		m_partyMood.setHorizontalAlignment(SwingConstants.CENTER);
		m_moodPanel.add(m_partyMood);

		m_txtPanel = new JPanel();
		m_searchFilters.add(m_txtPanel, BorderLayout.SOUTH);
		m_txtPanel.setLayout(new GridLayout(2, 1, 5, 10));

		m_startPanel = new JPanel();
		m_txtPanel.add(m_startPanel);
		GridBagLayout gbl_m_startPanel = new GridBagLayout();
		gbl_m_startPanel.columnWidths = new int[] { 60, 166, 0 };
		gbl_m_startPanel.rowHeights = new int[] { 20, 0 };
		gbl_m_startPanel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_m_startPanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		m_startPanel.setLayout(gbl_m_startPanel);

		lblNewLabel = new JLabel("Start : ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		m_startPanel.add(lblNewLabel, gbc_lblNewLabel);

		mStart = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		m_startPanel.add(mStart, gbc_textField);
		mStart.setColumns(10);

		m_destPanel = new JPanel();
		m_txtPanel.add(m_destPanel);
		GridBagLayout gbl_m_destPanel = new GridBagLayout();
		gbl_m_destPanel.columnWidths = new int[] { 60, 163, 0 };
		gbl_m_destPanel.rowHeights = new int[] { 20, 0 };
		gbl_m_destPanel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_m_destPanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		m_destPanel.setLayout(gbl_m_destPanel);

		lblNewLabel_1 = new JLabel("Finish : ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		m_destPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		mDest = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 0;
		m_destPanel.add(mDest, gbc_textField_1);
		mDest.setColumns(10);
	}

	public JCheckBox party() {
		return m_calmMood;
	}

	public JCheckBox getM_happyMood() {
		return m_happyMood;
	}
	
	public JCheckBox getM_calmMood() {
		return m_calmMood;
	}


	public JCheckBox getM_sadMood() {
		return m_sadMood;
	}

	public JCheckBox getM_partyMood() {
		return m_partyMood;
	}

	public JTextField getStart() {
		return mStart;
	}

	public JTextField getEnd() {
		return mDest;
	}

	
}
