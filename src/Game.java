import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// Klasse in der das Spiel gesteuert wird

public class Game extends JFrame {

	private int frameSizeX = 816;
	private int frameSizeY = 839;

	private int frameLocationX = 400;
	private int frameLocationY = 100;

	private JPanel panel;

	private int numberOfSelected; // Variable die die Anzahl an ausgewählten Feldern speichert. Sollte immer 0
									// oder 1 sein.

	private Schachbrett brett;
	
	Point p;

	public Game(String SpielModus) {

		super();

		// Einstellen des Frame bezüglich Größe und Position
		this.setSize(frameSizeX, frameSizeY);
		this.setLocation(frameLocationX, frameLocationY);

		// Icon des Frames wird als Springer festgelegt
		ImageIcon img = new ImageIcon("assets/Springer.png");
		this.setIconImage(img.getImage());

		this.setVisible(true);
		this.setTitle("Schach 2000 - " + SpielModus); // Der Titel des Frame wird auf "Schach 2000" gesetzt
		this.setResizable(false); // Man kann die Größe des Frame nicht verändern
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Wenn der Frame geschlossen wird, wird auch das Programm
																// beendet

		panel = new JPanel(); // Panel auf dem visuellen Elemente angezeigt werden

		// Der Inhalt des Panels wird auf dem Frame angezeigt:
		this.setContentPane(panel);
		this.getContentPane().setLayout(null);

		panel.setBackground(Color.RED);

		brett = new Schachbrett();

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (brett.Felder[i][j].figur != null) {
					panel.add(brett.Felder[i][j].figur);

					brett.Felder[i][j].figur.setBounds(100 * i, 100 * j, 100, 100);
				}
				brett.Felder[i][j].reihe = j;
				brett.Felder[i][j].spalte = i;
				panel.add(brett.Felder[i][j]);
				brett.Felder[i][j].setBounds(100 * i, 100 * j, 100, 100);
				brett.Felder[i][j].addMouseListener(brett.Felder[i][j]);

			}
		}
		// System.out.println(brett.Felder[5][3].spalte);
		
		

		while (true) {
			getNumberOfSelected();
			if(numberOfSelected > 1) {
				p = MouseInfo.getPointerInfo().getLocation();
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						if(brett.Felder[i][j].selected) {
							if(i != (int) (Math.floor((p.x - this.getX())))/100 || j != (int) (Math.floor((p.y - this.getY())))/100) {
								brett.Felder[i][j].demarkieren();
							}
						}
						
					}
				}
			}
			// delay(10);
		}

	}

	private static void delay(int zeit) {

		try {
			Thread.sleep(zeit);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void getNumberOfSelected() { // Methode, die numberOfSelected aktualisiert
		numberOfSelected = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (brett.Felder[i][j].selected) {
					numberOfSelected++;
				}
			}
		}
	}
}
