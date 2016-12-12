package Ui.InfoCards;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import Controllers.MapController;
import Member.Member;

public class InterestCardListRenderer implements ListCellRenderer<Member> {

	protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
	private ImageIcon friend = new ImageIcon(MapController.class.getResource("/Resources/icone_friend.png"));
	private ImageIcon family = new ImageIcon(MapController.class.getResource("/Resources/icone_family.png"));
	
	private String m_searchedPlace = "";
	
	@Override
	public Component getListCellRendererComponent(JList<? extends Member> list, Member value, int index,
			boolean isSelected, boolean cellHasFocus) {
		
		JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		renderer.setText(value.getFirstname() + " " + value.getLastname() + " visited this place the " + value.getInterestPoints().get(m_searchedPlace).toString());
		return renderer;

	}
	
	public String getSearchedPlace(){
		return m_searchedPlace;
	}
	
	public void setSearchedPlace(String value){
		m_searchedPlace = value;
	}

}
