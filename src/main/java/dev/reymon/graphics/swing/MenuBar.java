package dev.reymon.graphics.swing;

import java.util.List;
import java.util.function.Supplier;

import javax.swing.JComponent;
import javax.swing.JMenuBar;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {

	public MenuBar() {

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
