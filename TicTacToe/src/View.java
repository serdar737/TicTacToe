import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View extends JFrame {
	private JButton[][] button = new JButton[3][3];
	
	private JTextField status;
	private GamePanel panel;
	
	public View() {
		super("TicTacToe");
		fensterGenerieren();
	}

	private void fensterGenerieren() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 600);
		setLayout(new BorderLayout());
		status = new JTextField("Spieler 1");
		add(status, BorderLayout.NORTH);
		panel = new GamePanel();
		add(panel, BorderLayout.CENTER);
		setVisible(true);
	}
	
	public void erstelleListener(ActionListener al) {
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				this.button[i][j].setActionCommand(""+i+j);
				this.button[i][j].addActionListener(al);
			}
		}
	}


	public void setSpieler(int spieler) {
		spieler++; // dann gibt es Spieler 1 und 2
		status.setText("Spieler " + spieler);	
	}

	public void setButton(int i, int j, int k) {
		if (k == 0)
			button[i][j].setText("X");
		if (k == 1)
			button[i][j].setText("O");	
	}

	public void setGewonnen(int spieler) {
		spieler += 2;
		if (spieler == 3)
			spieler = 1;
		status.setText("Gewonnen: " + spieler);	
	}
	
	class GamePanel extends JPanel {
		public GamePanel() {
			setLayout(new GridLayout(3,3));
			for (int i=0; i<3; i++) {
				for (int j=0; j<3; j++) {
					button[i][j] = new JButton();
					add(button[i][j]);
				}
			}
		}
	}

}
