package Ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

//Il s'agira d'une barre avec une seule ligne d'information qui indique briévement la dernière opération effectuée. Ça a vocation à donner un feedBack à l'utilisateur.
public class LogBar extends JPanel {
	
	private static final long serialVersionUID = 3763564131554857958L;

	private static LogBar instance = new LogBar();
	
	private JLabel lblInfo;
	
	public static LogBar getInstance() { return instance; }
	private LogBar() {
		setBackground(new Color(255, 255, 255));
		setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));
		lblInfo = new JLabel("Here you can see the latest operation you've done.");
		lblInfo.setBackground(new Color(255, 255, 255));
		lblInfo.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		add(lblInfo);
	}
	
	public void showPositiveFeedback(String msg) {
		String toShow = "<html><font color=green>"+msg+"</font></html>";
		lblInfo.setText(toShow);
	}
	
	public void showCommonFeedBack(String msg) {
		String toShow = "<html><font color=black>"+msg+"</font></html>";
		lblInfo.setText(toShow);
	}

}
