import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// Klasse in der das Spiel gesteuert wird

public class Game extends JFrame {

	private int frameSizeX = 1000;
	private int frameSizeY = 1000;

	private int frameLocationX;
	private int frameLocationY;

	private JPanel panel;

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

		Schachbrett brett = new Schachbrett();

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if(brett.Felder[i][j].figur != null) {
					panel.add(brett.Felder[i][j].figur);
					brett.Felder[i][j].figur.setBounds(100 + 100 * i, 100 + 100 * j, 100, 100);
				}
				panel.add(brett.Felder[i][j]);
				brett.Felder[i][j].setBounds(100 + 100 * i, 100 + 100 * j, 100, 100);
				System.out.println("test");
			}
		}
	}
}
