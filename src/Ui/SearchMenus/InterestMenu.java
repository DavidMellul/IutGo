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

	/**
	 * Create the panel.
	 */
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
