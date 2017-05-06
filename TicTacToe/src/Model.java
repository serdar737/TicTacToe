
public class Model {
	private int [][] wert = new int [3][3];
	private int spieler;
	
	public Model() {
		zuruecksetzen();
	}
	



	private void zuruecksetzen() {
		spieler = 0;
		for (int i=0; i<3; i++)
			for (int j=0; j<3; j++)
				wert [i][j] = -1;		
	}




	public void setze(int i, int j) {
		spieler++;
		spieler%=2; // Spieler ist jetzt 0 oder 1
		wert[i][j] = spieler;		
	}


	public boolean beendet() {
		boolean ende = false;
		for (int i=0; i<3;i++) {
			if (wert [i][0] != -1) {
				if (wert [i][0] == wert[i][1] && wert[i][0] == wert[i][2])
					ende = true;
			}
			if (wert[0][i] != -1) {
				if (wert[0][i] == wert[1][i] && wert [0][i] == wert [2][i])
					ende = true;
			}
		}
		if (wert[1][1] != -1) {
			if (wert[0][0] == wert[1][1] && wert[1][1] == wert[2][2])
				ende = true;
			if (wert[2][0] == wert[1][1] && wert[1][1] == wert[0][2])
				ende = true;
		}
		return ende;
	}
	
	public int getWert(int n, int m) {
		return wert[n][m];
	}
	
	public int getSpieler() {
		return spieler;
	}

}
