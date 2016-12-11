package Ui.SearchMenus;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class FormationMenu extends AbstractMenu {
	
	private static final long serialVersionUID = 6299597706697062032L;
	private JTextField m_name;
	private JLabel m_lblName;

	public FormationMenu() {
		super("Search for formation", true);
	}

	@Override
	protected void initialize() {
		m_searchFilters.setLayout(new GridLayout(1, 2, 10, 10));
		
		m_lblName = new JLabel("Name");
		m_searchFilters.add(m_lblName);
		
		m_name = new JTextField();
		m_name.setColumns(10);
		m_searchFilters.add(m_name);
	}

}
