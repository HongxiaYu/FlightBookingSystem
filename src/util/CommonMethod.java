package util;

import java.awt.Component;

import javax.swing.JFrame;

public class CommonMethod {
	public static JFrame getJFrame(Component c) {
		while (!(c instanceof JFrame)) {
			c = c.getParent();
			if (c instanceof JFrame) {
				return (JFrame) c;
			}
		}
		return null;
	}
}
