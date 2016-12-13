package Ui.Forms;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class TitleBarForms extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8792583867779037608L;
	JLabel labelCroix;
	JLabel logo;
	JLabel lblIutgo;
	JButton btnClose;
	JButton btnMinus;
	private JPanel closePanel;
	private JPanel minusPanel;
	private JPanel buttonPanel;
	private JPanel titlePanel;
	
	public TitleBarForms() {
		setBackground(Color.LIGHT_GRAY);
		setPreferredSize(new Dimension(640, 40));
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setBounds(new Rectangle(0, 0, 640, 0));
		
		titlePanel = new JPanel();
		titlePanel.setBackground(Color.LIGHT_GRAY);
		
		logo = new JLabel("");
		logo.setIcon(new ImageIcon(TitleBarForms.class.getResource("/Resources/icone_iutgo_reduced.png")));
		logo.setFont(new Font("FontAwesome", Font.PLAIN, 21));
		
		lblIutgo = new JLabel("IutGo");
		lblIutgo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		
		buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.LIGHT_GRAY);
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		minusPanel = new JPanel();
		minusPanel.setBackground(Color.LIGHT_GRAY);
		minusPanel.setPreferredSize(new Dimension(30, 30));
		buttonPanel.add(minusPanel);
		
		
		btnMinus = new JButton();
		btnMinus.setBackground(Color.LIGHT_GRAY);
		btnMinus.setToolTipText("Iconify");
		btnMinus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMinus.setFont(new Font("FontAwesome", Font.PLAIN, 18));
		btnMinus.setText("\uF068");
		btnMinus.setBorder(null);
		btnMinus.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMinus.setContentAreaFilled(false);
		btnMinus.setOpaque(false);
		btnMinus.setFocusPainted(false);
		btnMinus.setBorderPainted(false);
		btnMinus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent me) { btnMinus.setForeground(Color.BLUE); }
			@Override
			public void mouseExited(MouseEvent me) { btnMinus.setForeground(Color.BLACK); }
		});
		GroupLayout gl_minusPanel = new GroupLayout(minusPanel);
		gl_minusPanel.setHorizontalGroup(
			gl_minusPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(btnMinus, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
		);
		gl_minusPanel.setVerticalGroup(
			gl_minusPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(btnMinus, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
		);
		minusPanel.setLayout(gl_minusPanel);
		
		closePanel = new JPanel();
		closePanel.setBackground(Color.LIGHT_GRAY);
		closePanel.setPreferredSize(new Dimension(30, 30));
		buttonPanel.add(closePanel);
		
		labelCroix = new JLabel("\uF00D");
		labelCroix.setHorizontalTextPosition(SwingConstants.CENTER);
		labelCroix.setHorizontalAlignment(SwingConstants.CENTER);
		labelCroix.setFont(new Font("FontAwesome", Font.BOLD, 24));
		
		
		btnClose = new JButton();
		btnClose.setBorder(null);
		btnClose.setBackground(new Color(204, 255, 255));
		btnClose.setToolTipText("Quit");
		btnClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClose.setHorizontalTextPosition(SwingConstants.CENTER);
		btnClose.setContentAreaFilled(false);
		btnClose.setOpaque(false);
		btnClose.setFocusPainted(false);
		btnClose.setBorderPainted(false);

		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent me) { labelCroix.setForeground(Color.BLUE); }
			@Override
			public void mouseExited(MouseEvent me) { labelCroix.setForeground(Color.BLACK); }
		});
		
		GroupLayout gl_closePanel = new GroupLayout(closePanel);
		gl_closePanel.setHorizontalGroup(
			gl_closePanel.createParallelGroup(Alignment.LEADING)
				.addComponent(btnClose, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
				.addComponent(labelCroix, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
		);
		gl_closePanel.setVerticalGroup(
			gl_closePanel.createParallelGroup(Alignment.LEADING)
				.addComponent(btnClose, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
				.addComponent(labelCroix, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
		);
		closePanel.setLayout(gl_closePanel);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(4)
					.addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
					.addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(4)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(titlePanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
						.addComponent(buttonPanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(4))
		);
		GroupLayout gl_titlePanel = new GroupLayout(titlePanel);
		gl_titlePanel.setHorizontalGroup(
			gl_titlePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_titlePanel.createSequentialGroup()
					.addGap(4)
					.addComponent(logo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblIutgo, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
					.addGap(1))
		);
		gl_titlePanel.setVerticalGroup(
			gl_titlePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_titlePanel.createSequentialGroup()
					.addGap(2)
					.addGroup(gl_titlePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIutgo, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(logo)))
		);
		titlePanel.setLayout(gl_titlePanel);
		setLayout(groupLayout);
	}
	
	public JButton getBtnClose() {
		return this.btnClose;
	}
	
	public JButton getBtnMinus() {
		return this.btnMinus;
	}
}
