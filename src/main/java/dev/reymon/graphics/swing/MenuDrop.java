package dev.reymon.graphics.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;
import java.util.function.Supplier;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dev.reymon.localization.Translation;

@SuppressWarnings("serial")
public class MenuDrop extends JPanel {

	private final Button header = new Button();
	private final VBox content = new VBox(2);
	private final Supplier<String> title;
	private final Runnable refresh;
	private boolean expanded = false;

	public MenuDrop(Supplier<String> title, Supplier<List<? extends JComponent>> items) {
	
		this.title = title;
		
		setLayout(new BorderLayout());
		setOpaque(false);
		
		header.setHorizontalAlignment(SwingConstants.LEFT);
		header.putClientProperty("JButton.buttonType", "toolBarButton");
		header.setOnAction(() -> toggle());
		
		content.setBorder(BorderFactory.createEmptyBorder(2, 16, 2, 0));
		content.add(items);
		content.setVisible(false);
		
		add(header, BorderLayout.NORTH);
		add(content, BorderLayout.CENTER);
		
		refresh = this::updateHeader;
		refresh.run();
		Translation.addListener(refresh);
	}

	private void toggle() {
		expanded = !expanded;
		content.setVisible(expanded);
		updateHeader();
		revalidate();
		repaint();
	}

	private void updateHeader() {
		header.setText(title.get());
	}

	@Override
	public Dimension getMaximumSize() {
		return new Dimension(Integer.MAX_VALUE, getPreferredSize().height);
	}

}
