import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class Controller {
	private View view;
	
	public Controller() {
		this.view = new View();
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    view.setVisible(true);
	}
	
}
