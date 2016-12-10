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
				firePropertyChange("toto", false, false);
			}
		});
		headerPanel.add(interestCheckbox);
		
		searchFilters = new JPanel();
		add(searchFilters, BorderLayout.CENTER);
		searchFilters.setLayout(new GridLayout(3, 1, 0, 0));
	}

}
=======
package Ui.SearchMenus;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.javaswingcomponents.rater.JSCRater;

public class InterestMenu extends AbstractMenu {

	private static final long serialVersionUID = -102475531927956419L;
	private JTextField textField;


	public InterestMenu() {
		super("Search interest points", true);
		m_searchFilters.setLayout(new GridLayout(4, 2, 5, 5));
		
		JLabel lblName = new JLabel("Name");
		m_searchFilters.add(lblName);
		lblName.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		
		textField = new JTextField();
		m_searchFilters.add(textField);
		textField.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField.setColumns(10);
		
		JLabel lblNote = new JLabel("Note");
		m_searchFilters.add(lblNote);
		lblNote.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNote.setHorizontalAlignment(SwingConstants.LEFT);
		
		JSCRater rater = new JSCRater();
		m_searchFilters.add(rater);
		rater.setShapePadding(1);
		
		JLabel lblMinimumPrice = new JLabel("Minimum Price");
		m_searchFilters.add(lblMinimumPrice);
		lblMinimumPrice.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblMinimumPrice.setHorizontalAlignment(SwingConstants.LEFT);
		
		JSpinner spinner = new JSpinner();
		m_searchFilters.add(spinner);
		spinner.setFont(new Font("Dialog", Font.PLAIN, 12));
		
		JLabel lblMaximumPrice = new JLabel("Maximum Price");
		m_searchFilters.add(lblMaximumPrice);
		lblMaximumPrice.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblMaximumPrice.setHorizontalAlignment(SwingConstants.LEFT);
		
		JSpinner spinner_1 = new JSpinner();
		m_searchFilters.add(spinner_1);
		spinner_1.setFont(new Font("Dialog", Font.PLAIN, 12));
	}

	@Override
	protected void initialize() {
		
	}
}

