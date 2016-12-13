package Ui.EditMenus;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import Controllers.Controller;
import Ui.Commons.LogBar;
import Utils.Util;

public class FriendAdditionForm extends JPanel {
	
	private static final long serialVersionUID = 5307060975053879750L;
	private JTextField fieldMember;
	private JComboBox<String> comboBox;
	private JLabel lblMember;
	private JButton btnConfirm;
	private JButton btnReduce;

	public FriendAdditionForm() {
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setLayout(null);
		
		lblMember = new JLabel("Member");
		lblMember.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblMember.setBounds(23, 27, 46, 14);
		add(lblMember);
		
		fieldMember = new JTextField();
		fieldMember.setText("Firstname Lastname");
		fieldMember.setBounds(79, 25, 117, 20);
		fieldMember.setColumns(10);
		fieldMember.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if(fieldMember.getText().isEmpty())
					fieldMember.setText("Firstname Lastname");
			}
			@Override
			public void focusGained(FocusEvent e) {
				if(fieldMember.getText().equals("Firstname Lastname"))
					fieldMember.setText("");
			}
		});
		add(fieldMember);
		
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"friends", "family"}));
		comboBox.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		comboBox.setBounds(206, 25, 64, 20);
		add(comboBox);
		
		btnConfirm = new JButton("\uF05D");
		btnConfirm.setToolTipText("Confirm");
		btnConfirm.setForeground(new Color(50, 205, 50));
		btnConfirm.setBorder(null);
		btnConfirm.setBorderPainted(false);
		btnConfirm.setContentAreaFilled(false);
		btnConfirm.setFocusPainted(false);
		btnConfirm.setOpaque(false);
		btnConfirm.setFont(new Font("FontAwesome", Font.PLAIN, 24));
		btnConfirm.setBounds(270, 23, 33, 23);
		btnConfirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(fieldMember.getText().contains(" ")) {
					String fName = fieldMember.getText().substring(0,fieldMember.getText().indexOf(' '));
					String lName = fieldMember.getText().substring(fieldMember.getText().indexOf(' ')+1);
					String kind = (String)comboBox.getSelectedItem();
					if(fName.isEmpty() == false & lName.isEmpty() == false) {
						if(Controller.getInstance().canAddRelation(fName, lName, kind) == true) {
							LogBar.getInstance().showPositiveFeedback(fName+" "+lName+" has been added to your relations. :)");
							btnReduce.doClick();
							fieldMember.setText("");
						}
						else
							JOptionPane.showMessageDialog(null, "The requested member doesn't exist, please check what you typed in.");
					}
				}
				else
					JOptionPane.showMessageDialog(null, "Please fill in the field by respecting the format expected.");
			}
		});
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent me) { btnConfirm.setForeground(Color.BLUE); }
			@Override
			public void mouseExited(MouseEvent me) { btnConfirm.setForeground(Color.GREEN); }
		});
		add(btnConfirm);
		
		btnReduce = new JButton("\uF068");
		btnReduce.setBorder(null);
		btnReduce.setBorderPainted(false);
		btnReduce.setContentAreaFilled(false);
		btnReduce.setFocusPainted(false);
		btnReduce.setOpaque(false);
		btnReduce.setFont(new Font("FontAwesome", btnReduce.getFont().getStyle(), 14));
		btnReduce.setBounds(308, 0, 33, 23);
		btnReduce.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReduce.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent me) { btnReduce.setForeground(Color.BLUE);}
			@Override
			public void mouseExited(MouseEvent me) { btnReduce.setForeground(Color.BLACK); }
		});
		add(btnReduce);

	}
	
	public JButton getBtnReduce() { return this.btnReduce; }
}
