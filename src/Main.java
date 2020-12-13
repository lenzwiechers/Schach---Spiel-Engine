// Main - Klasse - wird ausgeführt zum Starten

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		GUI Gui = new GUI();

		while (!Gui.rdy) {
			delay(100);
		}

		Game game = new Game(Gui.getSpielModus());
	}

	private static void delay(int zeit) {

		try {
			Thread.sleep(zeit);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
