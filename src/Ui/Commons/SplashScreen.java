package Ui.Commons;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class SplashScreen extends JFrame {
	
	// ------------------------------------------------------------- SINGLETON -------------------------------------------
	private static SplashScreen m_instance = new SplashScreen();
	
	private JPanel panelPrincipal;
	private JLabel lblSplashScreen;
	private JLabel lblPercentage;
	private JProgressBar progressBar;
	
	private SplashScreen() { super(); initializeComponents(); }
	
	public static SplashScreen getInstance() { return m_instance; }

	// ------------------------------------------------------------- PITI LABEL ------------------------------------------
	
	private void initializeComponents() {
		setSize(640,480);
		setTitle("Iut Go");
		setIconImage(Toolkit.getDefaultToolkit().getImage(SplashScreen.class.getResource("/Resources/icone_iutgo_reduced.png")));
		setResizable(false);
		setUndecorated(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 0, 640, 480);
		getContentPane().add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.setBackground(new Color(21,164,224));
		progressBar.setBorder(null);
		progressBar.setForeground(Color.WHITE);
		progressBar.setBounds(121, 306, 429, 14);
		panelPrincipal.add(progressBar);
		
		lblPercentage = new JLabel("0%");
		lblPercentage.setBounds(310,326,85,50);
		lblPercentage.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblPercentage.setForeground(Color.WHITE);
		panelPrincipal.add(lblPercentage);
		
		lblSplashScreen = new JLabel("");
		lblSplashScreen.setIcon(new ImageIcon(SplashScreen.class.getResource("/Resources/splashscreen_iutgo.png")));
		lblSplashScreen.setBounds(0, 0, 640, 480);
		panelPrincipal.add(lblSplashScreen);
	}
	
	public void displayPercentage(Double percent) { lblPercentage.setText(percent.intValue()+"%"); progressBar.setValue(percent.intValue());}
}
