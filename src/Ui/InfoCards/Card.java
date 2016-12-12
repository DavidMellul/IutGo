package Ui.InfoCards;

import javax.swing.JButton;
import javax.swing.JPanel;

public abstract class Card extends JPanel{
	protected JButton btnMinus;
	
	public JButton getBtnMinus() { return this.btnMinus; }
}
