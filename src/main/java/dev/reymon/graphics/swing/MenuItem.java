package dev.reymon.graphics.swing;

import java.util.function.Supplier;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JMenuItem;

import dev.reymon.localization.Translation;

@SuppressWarnings("serial")
public class MenuItem extends JMenuItem {
	
	private final Runnable refresh;

	public MenuItem() {
		refresh = null;
	}

	public MenuItem(Icon icon) {
		super(icon);
		refresh = null;
	}

	public MenuItem(String text) {
		super(text);
		refresh = null;
	}

	public MenuItem(Action a) {
		super(a);
		refresh = null;
	}

	public MenuItem(String text, Icon icon) {
		super(text, icon);
		refresh = null;
	}

	public MenuItem(String text, int mnemonic) {
		super(text, mnemonic);
		refresh = null;
	}
	
	public MenuItem(Supplier<String> text) {
        refresh = () -> this.setText(text.get());
        
        refresh.run(); // Initial text
        
        Translation.addListener(refresh); // Automatic update
    }
	
	public void setOnAction(Runnable action) {
		this.addActionListener(_ -> action.run());
	}

}
