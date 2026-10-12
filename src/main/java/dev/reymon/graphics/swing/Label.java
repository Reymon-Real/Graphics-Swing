package dev.reymon.graphics.swing;

import javax.swing.Icon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Label extends JLabel {

	public Label() {
		// TODO Auto-generated constructor stub
	}

	public Label(String text) {
		super(text);
	}

	public Label(Icon image) {
		super(image);
	}

	public Label(String text, int horizontalAlignment) {
		super(text, horizontalAlignment);
	}

	public Label(Icon image, int horizontalAlignment) {
		super(image, horizontalAlignment);
	}

	public Label(String text, Icon icon, int horizontalAlignment) {
		super(text, icon, horizontalAlignment);
	}

}
