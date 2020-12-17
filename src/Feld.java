import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

// Ein Objekt dieser Klasse repr‰sentiert ein Feld auf einem Schachbrett

public class Feld extends Bild implements MouseListener {

	private static final long serialVersionUID = -319736981836351920L;

	Figur figur;

	public int reihe;
	public int spalte;
	
	public long timeOfSelection;
	
	public boolean selected;

	public Feld(boolean white) {
		super("weiﬂes_Feld");

		if (!white) {
			this.changeSauce("schwarzes_Feld");
		}
		
		timeOfSelection = System.currentTimeMillis();

	}

	public void mouseClicked(MouseEvent arg0) {
	}

	public void mouseEntered(MouseEvent arg0) {

	}

	public void mouseExited(MouseEvent arg0) {

	}

	public void mousePressed(MouseEvent arg0) {
		if (this.figur != null && !selected) {
			markieren("hellblaues_Feld");
		} else if(this.figur != null && selected) {
			demarkieren();
		}
	}

	public void mouseReleased(MouseEvent arg0) {

	}

	public void markieren(String dateiname) {
		this.changeSauce(dateiname);
		selected = true;
	}

	public void demarkieren() {
		if ((spalte % 2 == 0 && reihe % 2 == 0) || (spalte % 2 == 1 && reihe % 2 == 1)) {
			this.changeSauce("weiﬂes_Feld");
		} else {
			this.changeSauce("schwarzes_Feld");
		}
		selected = false;
	}

}
