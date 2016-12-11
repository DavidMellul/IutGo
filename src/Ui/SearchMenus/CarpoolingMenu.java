package Ui.SearchMenus;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class CarpoolingMenu extends AbstractMenu {

	private static final long serialVersionUID = -102475531927956419L;
	private JTextField m_start;
	private JTextField m_finish;
	private JLabel m_lblFinish;
	private JLabel m_lblStart;

	public CarpoolingMenu() {
		super("Search for carpooling", false);
	}

	@Override
	protected void initialize() {
		m_searchFilters.setLayout(new GridLayout(2, 2, 10, 10));
		
		m_lblStart = new JLabel("Start");
		m_searchFilters.add(m_lblStart);
		
		m_start = new JTextField();
		m_searchFilters.add(m_start);
		m_start.setColumns(10);
		
		m_lblFinish = new JLabel("Finish");
		m_searchFilters.add(m_lblFinish);
		
		m_finish = new JTextField();
		m_searchFilters.add(m_finish);
		m_finish.setColumns(10);
	}

}
