package dev.reymon.graphics.swing;

import java.awt.GridBagLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GridPane extends JPanel {

	public GridPane() {
		super(new GridBagLayout());
	}

	public GridPane(LayoutManager layout) {
		super(layout);
	}

	public GridPane(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	public GridPane(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

}
