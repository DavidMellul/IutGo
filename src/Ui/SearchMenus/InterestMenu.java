package Ui.SearchMenus;


import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.javaswingcomponents.rater.JSCRater;

public class InterestMenu extends AbstractMenu {

	private static final long serialVersionUID = -102475531927956419L;
	private JTextField name;
	private JLabel lblName;
	private JSCRater rater;


	public InterestMenu() {
		super("Search for interest points", false);
	}

	@Override
	protected void initialize() {
		m_searchFilters.setLayout(new GridLayout(2, 2, 5, 5));
		
		lblName = new JLabel("Name");
		m_searchFilters.add(lblName);
		lblName.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		
		name = new JTextField();
		m_searchFilters.add(name);
		name.setFont(new Font("Dialog", Font.PLAIN, 12));
		name.setColumns(10);
		
		JLabel lblNote = new JLabel("Note");
		m_searchFilters.add(lblNote);
		lblNote.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNote.setHorizontalAlignment(SwingConstants.LEFT);
		
		rater = new JSCRater();
		m_searchFilters.add(rater);
		rater.setShapePadding(1);
	}

	public JTextField getNameFilter() {
		return name;
	}

	public JSCRater getRater() {
		return rater;
	}
	
}

