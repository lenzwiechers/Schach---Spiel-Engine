import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

// Main- GUI des Projekts - dient dem Auswählen eines Spielmodus

public class GUI extends JFrame {

	private static final long serialVersionUID = 6411499808530678723L;

	private int frameSizeX = 300;
	private int frameSizeY = 200;

	private int frameLocationX;
	private int frameLocationY;

	private JPanel panel;

	private JButton button;

	private JComboBox<?> SpielAuswahl;

	private String[] SpielModi; // String - Array der auszuwählenden Spielmodi

	private String SpielModus; // Der letztendlich ausgewählte Spielmouds

	public boolean rdy; // wird benutzt um festzustellen, ob eine Spielmodus Auswahl erfolgt hat

	public GUI() { // Konstruktor der Klasse

		super();
		// Einstellen des Frame bezüglich Größe und Position
		this.setSize(frameSizeX, frameSizeY);
		this.setLocation(frameLocationX, frameLocationY);

		// Icon des Frames wird als Springer festgelegt
		ImageIcon img = new ImageIcon("assets/Springer.png");
		this.setIconImage(img.getImage());

		this.setVisible(true);
		this.setTitle("Schach 2000"); // Der Titel des Frame wird auf "Schach 2000" gesetzt
		this.setResizable(false); // Man kann die Größe des Frame nicht verändern
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Wenn der Frame geschlossen wird, wird auch das Programm
																// beendet

		panel = new JPanel(); // Panel auf dem visuellen Elemente angezeigt werden

		// Der Inhalt des Panels wird auf dem Frame angezeigt:
		this.setContentPane(panel);
		this.getContentPane().setLayout(null);

		panel.setBackground(Color.BLACK);

		button = new JButton("Launch");
		panel.add(button);
		button.setFont(new Font("Consolas", Font.PLAIN, 14));
		button.setBounds(50, 50, 200, 30);
		button.setBorderPainted(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					button_ActionPerformed(evt);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		SpielModi = new String[] { "Lokales Match", "Online Match", "Match vs. Engine", "Match im Netz" };

		SpielAuswahl = new JComboBox<Object>(SpielModi);
		SpielAuswahl.setSelectedItem("Lokales Match");
		panel.add(SpielAuswahl);
		SpielAuswahl.setBounds(50, 10, 200, 30);
		SpielAuswahl.setFont(new Font("Consolas", Font.PLAIN, 14));
		// SpielAuswahl.setAlignmentX(Label.CENTER);
		((JLabel) SpielAuswahl.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

	}

	// Was passieren soll, wenn der Button gedrückt wird
	public void button_ActionPerformed(ActionEvent evt) {
		SpielModus = String.valueOf(SpielAuswahl.getSelectedItem());
		System.out.println(SpielModus);
		rdy = true;
		this.dispose();
	}
	
	public String getSpielModus() {
		return SpielModus;
	}

}
