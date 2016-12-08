package Ui.SearchMenus;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class InterestMenu extends JPanel {

	private static final long serialVersionUID = -102475531927956419L;
	private JPanel searchFilters;

	/**
	 * Create the panel.
	 */
	public InterestMenu() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel headerPanel = new JPanel();
		add(headerPanel, BorderLayout.NORTH);
		headerPanel.setLayout(new BorderLayout(0, 0));
		
		JCheckBox interestCheckbox = new JCheckBox("Search for interestPoints");
		interestCheckbox.setAlignmentX(Component.CENTER_ALIGNMENT);
		interestCheckbox.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		interestCheckbox.setHorizontalAlignment(SwingConstants.LEFT);
		interestCheckbox.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				if(interestCheckbox.isSelected()){
					searchFilters.setVisible(true);
				}else{
					searchFilters.setVisible(false);
				}
				repaint();
				doLayout();
			}
		});
		headerPanel.add(interestCheckbox);
		
		searchFilters = new JPanel();
		add(searchFilters, BorderLayout.CENTER);
		searchFilters.setLayout(new GridLayout(3, 1, 0, 0));
	}

}
