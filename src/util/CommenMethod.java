package util;

import java.awt.Component;

import javax.swing.JFrame;

public class CommenMethod {
	public static int FRAME_LOCATION_X = 600;
	public static int FRAME_LOCATION_Y = 400;
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
