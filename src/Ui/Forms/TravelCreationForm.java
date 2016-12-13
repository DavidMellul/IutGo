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
import javax.swing.JSpinner;

public class TravelCreationForm extends JDialog {

	private JTextField m_txtStart;
	private JTextField m_txtEnd;

	private JButton m_btnAdd;
	private JButton m_btnMinus;
	private JTextField textField;
	private JTextField textField_1;
	private JSpinner spinner;

	public TravelCreationForm() {
		super();
		setUndecorated(true);
		initialize();
	}

	public void initialize() {
		setResizable(false);
		setSize(304, 195);
		setAlwaysOnTop(true);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\uf0ac");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("FontAwesome", Font.PLAIN, 35));
		lblNewLabel.setBounds(10, 11, 40, 40);
		getContentPane().add(lblNewLabel);

		JLabel lblCreateANew = new JLabel("Create a new Travel");
		lblCreateANew.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblCreateANew.setBounds(61, 11, 226, 40);
		getContentPane().add(lblCreateANew);

		m_btnAdd = new JButton("\uf067");
		m_btnAdd.setForeground(Color.BLACK);
		m_btnAdd.setBorderPainted(false);
		m_btnAdd.setFont(new Font("FontAwesome", Font.PLAIN, 20));
		m_btnAdd.setContentAreaFilled(false);
		m_btnAdd.setBorder(null);
		m_btnAdd.setBounds(235, 11, 30, 30);
		m_btnAdd.setToolTipText("Add this point of interest");
		m_btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		m_btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent me) {
				m_btnAdd.setForeground(Color.BLUE);
			}

			@Override
			public void mouseExited(MouseEvent me) {
				m_btnAdd.setForeground(Color.BLACK);
			}
		});

		getContentPane().add(m_btnAdd);

		m_btnMinus = new JButton("\uF068");
		m_btnMinus.setFont(new Font("FontAwesome", Font.PLAIN, 18));
		m_btnMinus.setContentAreaFilled(false);
		m_btnMinus.setOpaque(false);
		m_btnMinus.setForeground(Color.BLACK);
		m_btnMinus.setFocusPainted(false);
		m_btnMinus.setBorder(null);
		m_btnMinus.setBorderPainted(false);
		m_btnMinus.setBounds(264, 15, 30, 23);
		m_btnMinus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		m_btnMinus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent me) {
				m_btnMinus.setForeground(Color.BLUE);
			}

			@Override
			public void mouseExited(MouseEvent me) {
				m_btnMinus.setForeground(Color.BLACK);
			}
		});
		m_btnMinus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		getContentPane().add(m_btnMinus);

		JLabel lblStart = new JLabel("Start :");
		lblStart.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		lblStart.setBounds(10, 62, 91, 31);
		getContentPane().add(lblStart);

		JLabel lblEnd = new JLabel("End :");
		lblEnd.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		lblEnd.setBounds(10, 98, 91, 31);
		getContentPane().add(lblEnd);

		textField = new JTextField();
		textField.setBounds(82, 67, 212, 20);
		getContentPane().add(textField);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(82, 103, 212, 20);
		getContentPane().add(textField_1);

		JLabel lblSeats = new JLabel("Seats :");
		lblSeats.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		lblSeats.setBounds(10, 140, 91, 31);
		getContentPane().add(lblSeats);

		spinner = new JSpinner();
		spinner.setBounds(82, 145, 97, 20);
		getContentPane().add(spinner);
	}

	public JTextField getStart() {
		return m_txtStart;
	}

	public JTextField getEnd() {
		return m_txtEnd;
	}

	public JButton getBtnAdd() {
		return m_btnAdd;
	}

	public JButton getBtnMin() {
		return m_btnMinus;
	}
	
	public JSpinner getSeat(){
		return spinner;
	}

}
