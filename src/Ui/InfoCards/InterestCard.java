package Ui.InfoCards;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import com.javaswingcomponents.rater.JSCRater;

import Controllers.Controller;
import Interests.InterestPoint;
import Member.Member;
import Utils.Util;
import javax.swing.border.MatteBorder;

public class InterestCard extends Card {

	private static final long serialVersionUID = -3407588193024804740L;
	private JSCRater rater;
	private JLabel lblDesc;
	private JLabel lblName;
	private JLabel lblPrice;
	private JList<Member> listMember;

	public InterestCard() {
		super();
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		m_btnMinus.setBounds(240, 0, 42, 24);
		getBtnMinus().setBounds(240, 0, 42, 24);
		setSize(280, 403);
		
		JLabel label = new JLabel("\uf05a");
		label.setBounds(11, 11, 99, 99);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("FontAwesome", Font.PLAIN, 99));
		
		lblName = new JLabel("UNDEFINED");
		lblName.setBounds(116, 30, 151, 49);
		lblName.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		add(getBtnMinus());
		add(m_btnMinus);
		setLayout(null);
		add(label);
		add(lblName);
		
		lblDesc = new JLabel("UNDEFINED");
		lblDesc.setBounds(11, 121, 256, 75);
		lblDesc.setFont(new Font("Tw Cen MT", Font.PLAIN, 13));
		lblDesc.setVerticalAlignment(SwingConstants.TOP);
		lblDesc.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblDesc);
		
		rater = new JSCRater();
		rater.setAnimated(false);
		rater.setEnabled(false);
		rater.setBounds(21, 207, 132, 25);
		add(rater);
		
		lblPrice = new JLabel("Price : 100\u20AC");
		lblPrice.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPrice.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setBounds(153, 207, 114, 25);
		add(lblPrice);
		
		listMember = new JList<Member>();
		listMember.setCellRenderer(new InterestCardListRenderer());
		listMember.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listMember.setSelectionBackground(new Color(255, 255, 255));
		listMember.setFixedCellWidth(1);
		listMember.setFixedCellHeight(1);
		listMember.setBounds(11, 248, 259, 144);
		add(listMember);
	}
	
	public void showInterestPoint(InterestPoint p_point, Point p_position){
		setLocation(p_position);
		((InterestCardListRenderer)listMember.getCellRenderer()).setSearchedPlace(p_point.getName());
		String rate = Integer.toString((int)p_point.getNoteMoyenne());
		rater.setRating(new BigDecimal(rate));
		lblName.setText(p_point.getName());
		lblDesc.setText(p_point.getDescription());
		float cout = p_point.getCoutNuitee();
		if(cout == 0){
			lblPrice.setText("Price : None");
		}else{
			lblPrice.setText("Price : " + Float.toString(p_point.getCoutNuitee()) + "€");
		}
		ArrayList<Member> list = Controller.getInstance().getCurrentMember().getAllRelations();
		ArrayList<Member> toKeep = new ArrayList<>();
		for(Member m: list){
			if(m.getInterestPoints().get(p_point.getName()) != null){
				toKeep.add(m);
			}
		}
		listMember.setListData(Util.memberListToArray(toKeep));
	}
}
