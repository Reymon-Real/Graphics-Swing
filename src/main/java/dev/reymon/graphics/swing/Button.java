package dev.reymon.graphics.swing;

import java.util.function.Supplier;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

import dev.reymon.localization.Translation;

@SuppressWarnings("serial")
public class Button extends JButton {

	private final Runnable refresh;
	
	public Button() {
		refresh = null;
	}

	public Button(Icon icon) {
		super(icon);
		refresh = null;
	}

	public Button(String text) {
		super(text);
		refresh = null;
	}

	public Button(Action a) {
		super(a);
		refresh = null;
	}

	public Button(String text, Icon icon) {
		super(text, icon);
		refresh = null;
	}
	
	public Button(Supplier<String> text) {
        refresh = () -> this.setText(text.get());
        
        refresh.run(); // Initial text
        
        Translation.addListener(refresh); // Automatic update
    }

	public void setOnAction(Runnable runnable) {
		this.addActionListener(_ -> runnable.run());
	}
	
}
