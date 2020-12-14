import java.awt.Color;

import javax.swing.JLabel;

// Ein Objekt dieser Klasse repräsentiert ein Feld auf einem Schachbrett

public class Feld extends Bild {

	private static final long serialVersionUID = -319736981836351920L;
	
	Figur figur;

	public Feld(boolean white) {
		super("weißes_Feld");

		if (!white) {
			this.changeSauce("schwarzes_Feld");
		}

	}

}
