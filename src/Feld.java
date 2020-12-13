import java.awt.Color;

import javax.swing.JLabel;

// Ein Objekt dieser Klasse repr‰sentiert ein Feld auf einem Schachbrett

public class Feld extends Bild {

	private static final long serialVersionUID = -319736981836351920L;

	public Feld(boolean white) {
		super("weiﬂes_Feld");

		if (!white) {
			this.changeSauce("schwarzes_Feld");
		}

	}

}
