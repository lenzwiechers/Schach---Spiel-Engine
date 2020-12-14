import javax.swing.JLabel;

public class Schachbrett {

	private static final long serialVersionUID = 1848795434219269637L;

	Feld[][] Felder = new Feld[8][8];
	
	

	public Schachbrett() {

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1)) {
					Felder[i][j] = new Feld(true);
				} else {
					Felder[i][j] = new Feld(false);
				}
				if(j == 6) {
					Felder[i][j].figur = new Figur("weißer_Bauer");
				}
			}
		}
	}
}