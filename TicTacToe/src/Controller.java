import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
	private View view;
	private Model model;
	
	public Controller() {
		this.model = new Model();
		this.view = new View();
		this.view.erstelleListener(new MeinListener());
	}
	
	class MeinListener implements ActionListener {
		public MeinListener() {
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// Index ausVire holen
			String dummy = e.getActionCommand();
			int n = Integer.parseInt(dummy.substring(0,1));
			int m = Integer.parseInt(dummy.substring(dummy.length()-1));
			// an Model übergeben
			model.setze(n,m);
			// von Model holen
			int spieler = model.getSpieler();
			// View aktualisieren
			view.setSpieler(spieler);
			// Spiel anzeigen
			int temp;
			for (int i=0;i<3;i++) {
				for (int j=0; j<3; j++) {
					temp = model.getWert(i,j);
					if (temp >=0)
						view.setButton(i,j,temp);
				}
			}
			// geht weiter?
			if (model.beendet())
				view.setGewonnen(spieler);
		}
	}


}
