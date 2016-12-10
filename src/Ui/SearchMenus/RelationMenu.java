package Ui.SearchMenus;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RelationMenu extends JPanel {

	private static final long serialVersionUID = -5164242424023505183L;
	private JPanel searchFilters;
	private JComboBox<String> comboBox;
	private JPanel moodPanel;
	private JCheckBox calmMood;
	private JCheckBox happyMood;
	private JCheckBox sadMood;
	private JCheckBox partyMood;
	private JLabel lblMood;

	/**
	 * Create the panel.
	 */
	public RelationMenu() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel headerPanel = new JPanel();
		add(headerPanel, BorderLayout.NORTH);
		headerPanel.setLayout(new BorderLayout(0, 0));
		
		JCheckBox relationCheckbox = new JCheckBox("Search for relations");
		relationCheckbox.setSelectedIcon(new ImageIcon(RelationMenu.class.getResource("/Resources/_checkbox_ticked.png")));
		relationCheckbox.setIcon(new ImageIcon(RelationMenu.class.getResource("/Resources/_checkbox_untick.png")));
		relationCheckbox.setAlignmentX(Component.CENTER_ALIGNMENT);
		relationCheckbox.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		relationCheckbox.setHorizontalAlignment(SwingConstants.LEFT);
		relationCheckbox.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				if(relationCheckbox.isSelected()){
					searchFilters.setVisible(true);
				}else{
					searchFilters.setVisible(false);
				}
				repaint();
				doLayout();
				firePropertyChange("toto", false, false);
			}
		});
		headerPanel.add(relationCheckbox);
		
		searchFilters = new JPanel();
		add(searchFilters, BorderLayout.CENTER);
		searchFilters.setLayout(new BorderLayout(0, 0));
		
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Amis", "Parent", "Frères"}));
		searchFilters.add(comboBox, BorderLayout.SOUTH);
		
		lblMood = new JLabel("Mood");
		lblMood.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMood.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMood.setHorizontalAlignment(SwingConstants.CENTER);
		searchFilters.add(lblMood, BorderLayout.NORTH);
		
		moodPanel = new JPanel();
		searchFilters.add(moodPanel, BorderLayout.CENTER);
		moodPanel.setLayout(new GridLayout(1, 4, 10, 10));
		
		calmMood = new JCheckBox("");
		calmMood.setSelectedIcon(new ImageIcon(RelationMenu.class.getResource("/Resources/_smiley_calm.png")));
		calmMood.setIcon(new ImageIcon(RelationMenu.class.getResource("/Resources/_smiley_calm_u.png")));
		calmMood.setHorizontalTextPosition(SwingConstants.CENTER);
		calmMood.setHorizontalAlignment(SwingConstants.CENTER);
		moodPanel.add(calmMood);
		
		happyMood = new JCheckBox("");
		happyMood.setSelectedIcon(new ImageIcon(RelationMenu.class.getResource("/Resources/_smiley_happy.png")));
		happyMood.setIcon(new ImageIcon(RelationMenu.class.getResource("/Resources/_smiley_happy_u.png")));
		happyMood.setHorizontalTextPosition(SwingConstants.CENTER);
		happyMood.setHorizontalAlignment(SwingConstants.CENTER);
		moodPanel.add(happyMood);
		
		sadMood = new JCheckBox("");
		sadMood.setSelectedIcon(new ImageIcon(RelationMenu.class.getResource("/Resources/_smiley_sad.png")));
		sadMood.setIcon(new ImageIcon(RelationMenu.class.getResource("/Resources/_smiley_sad_u.png")));
		sadMood.setHorizontalTextPosition(SwingConstants.CENTER);
		sadMood.setHorizontalAlignment(SwingConstants.CENTER);
		moodPanel.add(sadMood);
		
		partyMood = new JCheckBox("");
		partyMood.setSelectedIcon(new ImageIcon(RelationMenu.class.getResource("/Resources/_smiley_party.png")));
		partyMood.setIcon(new ImageIcon(RelationMenu.class.getResource("/Resources/_smiley_party_u.png")));
		partyMood.setHorizontalTextPosition(SwingConstants.CENTER);
		partyMood.setHorizontalAlignment(SwingConstants.CENTER);
		moodPanel.add(partyMood);

	}

}
