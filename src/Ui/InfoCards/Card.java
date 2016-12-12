package Ui.InfoCards;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

public abstract class Card extends JPanel {

	private static final long serialVersionUID = 7778807415199295432L;
	protected JButton m_btnMinus;

	public Card() {
		setBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setSize(280, 195);
		setLayout(null);

		m_btnMinus = new JButton("\uF068");
		m_btnMinus.setOpaque(false);
		m_btnMinus.setFocusPainted(false);
		m_btnMinus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		m_btnMinus.setContentAreaFilled(false);
		m_btnMinus.setBorder(null);
		m_btnMinus.setBorderPainted(false);
		m_btnMinus.setBounds(240, 0, 42, 24);
		m_btnMinus.setFont(new Font("FontAwesome", Font.PLAIN, 12));
		m_btnMinus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent me) {
				m_btnMinus.setForeground(Color.GRAY);
			}

			@Override
			public void mouseExited(MouseEvent me) {
				m_btnMinus.setForeground(Color.BLACK);
			}
		});

		add(m_btnMinus);
	}

	public JButton getBtnMinus() {
		return this.m_btnMinus;
	}
}
