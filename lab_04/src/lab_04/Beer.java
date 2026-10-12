package lab_04;

import java.io.Serializable;

public class Beer implements Serializable {
	private String name;
	private String style;
	private double strength;
	public Beer(String n, String sty, double strgth) {
		name = n;
		style = sty;
		strength = strgth;
	}
	public String getName() {
		return name;
	}
	public String getStyle() {
		return style;
	}
	public double getStrength() {
		return strength;
	}
	public String toString() {
		return "Name: " + name + ", Style: " + style + ", Strength: " + strength;
	}
}