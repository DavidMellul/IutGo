package Ui.Forms;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InterestForm extends JDialog {

	private static final long serialVersionUID = -8596487088214068325L;

	private JTextField m_txtName;
	private JTextField m_txtDesc;

	private JButton m_btnAddPI;
	private JButton m_btnMinus;

	public InterestForm() {
		super();
		setUndecorated(true);
		initialize();
	}

	public void initialize() {
		setResizable(false);
		setSize(450, 195);
		setAlwaysOnTop(true);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\uf05a");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("FontAwesome", Font.PLAIN, 35));
		lblNewLabel.setBounds(10, 11, 40, 40);
		getContentPane().add(lblNewLabel);

		JLabel lblCreateANew = new JLabel("Create a new Point of Interest");
		lblCreateANew.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblCreateANew.setBounds(61, 11, 226, 40);
		getContentPane().add(lblCreateANew);

		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		lblName.setBounds(10, 74, 91, 31);
		getContentPane().add(lblName);

		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		lblDescription.setBounds(10, 116, 91, 31);
		getContentPane().add(lblDescription);

		m_txtName = new JTextField();
		m_txtName.setBounds(111, 79, 323, 20);
		getContentPane().add(m_txtName);

		m_txtDesc = new JTextField();
		m_txtDesc.setColumns(10);
		m_txtDesc.setBounds(111, 121, 323, 20);
		getContentPane().add(m_txtDesc);

		m_btnAddPI = new JButton("\uf067");
		m_btnAddPI.setForeground(Color.BLACK);
		m_btnAddPI.setBorderPainted(false);
		m_btnAddPI.setFont(new Font("FontAwesome", Font.PLAIN, 20));
		m_btnAddPI.setContentAreaFilled(false);
		m_btnAddPI.setBorder(null);
		m_btnAddPI.setBounds(375, 11, 30, 30);
		m_btnAddPI.setToolTipText("Add this point of interest");
		m_btnAddPI.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		m_btnAddPI.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent me) { m_btnAddPI.setForeground(Color.BLUE); }
			@Override
			public void mouseExited(MouseEvent me) { m_btnAddPI.setForeground(Color.BLACK); }
		});

		getContentPane().add(m_btnAddPI);
		
		m_btnMinus = new JButton("\uF068");
		m_btnMinus.setFont(new Font("FontAwesome", Font.PLAIN, 18));
		m_btnMinus.setContentAreaFilled(false);
		m_btnMinus.setOpaque(false);
		m_btnMinus.setForeground(Color.BLACK);
		m_btnMinus.setFocusPainted(false);
		m_btnMinus.setBorder(null);
		m_btnMinus.setBorderPainted(false);
		m_btnMinus.setBounds(404, 15, 30, 23);
		m_btnMinus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		m_btnMinus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent me) { m_btnMinus.setForeground(Color.BLUE); }
			@Override
			public void mouseExited(MouseEvent me) { m_btnMinus.setForeground(Color.BLACK); }
		});
		m_btnMinus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		getContentPane().add(m_btnMinus);
	}
	
	public JButton getAddBtn(){
		return m_btnAddPI;
	}
	
	public JButton getMinBtn(){
		return m_btnMinus;
	}
	
	public JTextField getTxtName(){
		return m_txtName;
	}
	

	public JTextField getTxtDesc(){
		return m_txtDesc;
	}
}
