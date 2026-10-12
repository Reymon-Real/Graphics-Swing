package dev.reymon.localization;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLaf;

public class Translation {

	private static final String defaultTranslation = "translates/language";
	private static ResourceBundle bundle = ResourceBundle.getBundle(defaultTranslation, Locale.getDefault());
	private static final List<WeakReference<Runnable>> listeners = new ArrayList<>();

	public static void setLocale(Locale locale) {
		Locale.setDefault(locale);
		
		FlatDarkLaf.setup();
		FlatLaf.updateUI();
		
		bundle = ResourceBundle.getBundle(defaultTranslation, locale);
	
		listeners.removeIf(ref -> ref.get() == null);
		listeners.forEach(ref -> {
			Runnable r = ref.get();
			if (r != null) r.run();
		});
		
	}

	public static String tr(String key) {
		return bundle.getString(key);
	}
	
	public static void addListener(Runnable r) {
		listeners.add(new WeakReference<>(r));
	}

}
