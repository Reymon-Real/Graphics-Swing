package dev.reymon.graphics.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatDarkLaf;

@SuppressWarnings("serial")
public abstract class Application extends JFrame {
	
	private int width  = getScreenWidth();
	private int height = getScreenHeight();
	private Dimension dimension = getScreenSize();

	//####################
	//### Constructors ###
	//####################
	
	public Application() throws HeadlessException {
		this.setResizable(true);
	}

	public Application(GraphicsConfiguration gc) {
		super(gc);
		this.setResizable(true);
	}

	public Application(String title) throws HeadlessException {
		super(title);
		this.setResizable(true);
	}

	public Application(String title, GraphicsConfiguration gc) {
		super(title, gc);
		this.setResizable(true);
	}
	
	//#####################
	//### Scene Methods ###
	//#####################
	
	public void setScene(BorderPane panel) {
		this.add(panel, BorderLayout.CENTER);
	}
	
	//##########################
	//### Methods for screen ###
	//##########################
	
	public void setScreenSize(Dimension dimension) {
		this.dimension = dimension;
	}
	
	public void setScreenSize(int width, int height) {
		this.dimension.width = width;
		this.dimension.height = height;
	}
	
	public Dimension getScreenSize() {
		dimension = Toolkit.getDefaultToolkit().getScreenSize();
		return dimension;
	}
	
	public void setScreenWidth(int width) {
		this.width = width;
	}
	
	public int getScreenWidth() {
		this.width = Toolkit.getDefaultToolkit().getScreenSize().width;
		return this.width;
	}
	
	public void setScreenHeight(int height) {
		this.height = height;
	}
	
	public int getScreenHeight() {
		this.height = Toolkit.getDefaultToolkit().getScreenSize().height;
		return this.height;
	}
	
	public void setSize() {
		this.setSize(
				getScreenWidth() / 2,
				getScreenHeight() / 2
			);
	}
	
	//##################################
	//### Methods for execution time ###
	//##################################
	
	public void init() {
	}

	public abstract void start(Application app);

	public void stop() {
	}

	public static void launch() {
		Class<?> caller = StackWalker.getInstance(
				StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass();
				launch(caller.asSubclass(Application.class)
			);
	}

	public static void launch(Class<? extends Application> appClass) {
		
		UIManager.put("Button.arc", 12);
		UIManager.put("Component.arc", 12);
		UIManager.put("TextComponent.arc", 12);
		
		UIManager.put("ScrollBar.thumbArc", 999);
		UIManager.put("ScrollBar.thumbInsets", new Insets(2, 2, 2, 2));
		
		UIManager.put("Component.focusColor", new Color(0x2563EB));
		UIManager.put("Button.default.background", new Color(0x2563EB));
		
		UIManager.put("defaultFont", new Font("Inter", Font.PLAIN, 14));
		FlatDarkLaf.setup();
		
		SwingUtilities.invokeLater(() -> {
			try {

				var constructor = appClass.getDeclaredConstructor();
				constructor.setAccessible(true);
				Application app = constructor.newInstance();

				app.init();

				app.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
				app.addWindowListener(new WindowAdapter() {

					@Override
					public void windowClosing(WindowEvent e) {
						app.stop();
						app.dispose();
					}

				});
				
				app.start(app);
				app.setLocationRelativeTo(null);
				app.setVisible(true);
				
			} catch (ReflectiveOperationException e) {
				throw new RuntimeException("No se pudo instanciar " + appClass.getName(), e);
			}
		});

	}

}
