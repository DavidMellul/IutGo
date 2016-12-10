package Ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.SwingConstants;
import java.awt.Cursor;

public class TitleBarForms extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8792583867779037608L;
	JLabel labelCroix;
	JLabel labelMinus;
	JLabel logo;
	JLabel lblIutgo;
	JButton btnClose;
	JButton btnMinus;
	private JPanel closePanel;
	private JPanel minusPanel;
	private JPanel buttonPanel;
	private JPanel titlePanel;
	
	public TitleBarForms() {
		setPreferredSize(new Dimension(640, 40));
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setBounds(new Rectangle(0, 0, 640, 0));
		
		titlePanel = new JPanel();
		
		logo = new JLabel("\uF279 ");
		logo.setFont(new Font("FontAwesome", Font.PLAIN, 21));
		
		lblIutgo = new JLabel("IutGo");
		lblIutgo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		minusPanel = new JPanel();
		minusPanel.setPreferredSize(new Dimension(30, 30));
		buttonPanel.add(minusPanel);
		
		labelMinus = new JLabel("\uF068");
		labelMinus.setBackground(new Color(204, 255, 255));
		labelMinus.setToolTipText("Iconify");
		labelMinus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelMinus.setHorizontalAlignment(SwingConstants.CENTER);
		labelMinus.setHorizontalTextPosition(SwingConstants.CENTER);
		labelMinus.setFont(new Font("FontAwesome", Font.PLAIN, 22));
		
		
		btnMinus = new JButton();
		btnMinus.setBorder(null);
		btnMinus.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMinus.setContentAreaFilled(false);
		btnMinus.setOpaque(false);
		btnMinus.setFocusPainted(false);
		btnMinus.setBorderPainted(false);
		GroupLayout gl_minusPanel = new GroupLayout(minusPanel);
		gl_minusPanel.setHorizontalGroup(
			gl_minusPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(labelMinus, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
				.addComponent(btnMinus, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
		);
		gl_minusPanel.setVerticalGroup(
			gl_minusPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(labelMinus, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
				.addComponent(btnMinus, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
		);
		minusPanel.setLayout(gl_minusPanel);
		
		closePanel = new JPanel();
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
		btnClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
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
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(4)
					.addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
					.addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(4)
					.addComponent(titlePanel, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
					.addGap(4))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(4)
					.addComponent(buttonPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
						.addComponent(logo, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
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
