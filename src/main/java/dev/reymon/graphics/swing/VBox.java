package dev.reymon.graphics.swing;

import java.util.List;
import java.util.function.Supplier;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class VBox extends JPanel {

	private final int spacing;
	
	public VBox(int spacing) {
		
		this.spacing = spacing;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setOpaque(false);
		
	}
	
	public VBox add(Supplier<List<? extends JComponent>> children) {
		children.get().forEach(this::append);
		return this;
	}
	
	public VBox append(JComponent component) {
		if (getComponentCount() > 0) add(Box.createVerticalStrut(spacing));
		component.setAlignmentX(LEFT_ALIGNMENT);
		add(component);
		return this;
	}
	
}
