package dev.reymon.graphics.swing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.LayoutManager;
import java.util.function.Supplier;

import javax.swing.JComponent;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BorderPane extends JPanel {

	public BorderPane() {
		super(new BorderLayout());
	}

	public BorderPane(LayoutManager layout) {
		super(layout);
	}

	public BorderPane(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	public BorderPane(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

	// ##############################
	// ### Methods for set region ###
	// ##############################

	private void setRegion(JComponent component, String region) {
		BorderLayout layout = (BorderLayout) getLayout();
		Component previous = layout.getLayoutComponent(region);

		if (previous != null)
			remove(previous);

		if (component != null)
			add(component, region);

		revalidate();
		repaint();
	}

	public void addTop(JComponent component) {
		this.setRegion(component, BorderLayout.NORTH);
	}

	public void addLeft(JComponent component) {
		this.setRegion(component, BorderLayout.WEST);
	}

	public void addCenter(JComponent component) {
		this.setRegion(component, BorderLayout.CENTER);
	}

	public void addRight(JComponent component) {
		this.setRegion(component, BorderLayout.EAST);
	}

	public void addBottom(JComponent component) {
		this.setRegion(component, BorderLayout.SOUTH);
	}
	
	public void addTop(Supplier<JComponent> component) {
		this.setRegion(component.get(), BorderLayout.NORTH);
	}

	public void addLeft(Supplier<JComponent> component) {
		this.setRegion(component.get(), BorderLayout.WEST);
	}

	public void addCenter(Supplier<JComponent> component) {
		this.setRegion(component.get(), BorderLayout.CENTER);
	}

	public void addRight(Supplier<JComponent> component) {
		this.setRegion(component.get(), BorderLayout.EAST);
	}

	public void addBottom(Supplier<JComponent> component) {
		this.setRegion(component.get(), BorderLayout.SOUTH);
	}

}
