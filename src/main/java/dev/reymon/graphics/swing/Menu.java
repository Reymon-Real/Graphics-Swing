package dev.reymon.graphics.swing;

import java.util.List;
import java.util.function.Supplier;

import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JMenu;

import dev.reymon.localization.Translation;

@SuppressWarnings("serial")
public class Menu extends JMenu {

	private final Runnable refresh;
	
	public Menu() {
		refresh = null;
	}

	public Menu(String s) {
		super(s);
		refresh = null;
	}

	public Menu(Action a) {
		super(a);
		refresh = null;
	}

	public Menu(String s, boolean b) {
		super(s, b);
		refresh = null;
	}
	
	public Menu(Supplier<String> text) {
        refresh = () -> this.setText(text.get());
        
        refresh.run(); // Initial text
        
        Translation.addListener(refresh); // Automatic update
    }
	
	public void add(List<JComponent> list) {
		
		for (JComponent component : list)
			this.add(component);
		
	}
	
	public void add(Supplier<List<JComponent>> list) {
		
		for (JComponent component : list.get())
			this.add(component);
		
	}

}
