package dev.reymon.graphics.swing;

import java.awt.event.WindowEvent;

public class Platform {
	
	public static void exit(Application app) {
		app.dispatchEvent(new WindowEvent(app, WindowEvent.WINDOW_CLOSING));
	}
	
}
