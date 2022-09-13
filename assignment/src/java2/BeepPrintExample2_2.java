package java2;

import java.awt.Toolkit;

public class BeepPrintExample2_2 {

	public static void main(String[] args) {

		Thread thread = new Thread(() -> {

			Toolkit toolkit = Toolkit.getDefaultToolkit();

			for (int i = 0; i < 5; i++) {
				toolkit.beep();
				try {
					Thread.sleep(500);
				} catch (Exception e) {
				}
			}

		});
		thread.start();

		for (int i = 0; i < 5; i++) {
			System.out.println("¶ò");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
		}
	}
}
