package test;

import java.awt.Rectangle;

public class Test {
	public static void main(String[] args) {
		Rectangle t =  new Rectangle(100, 100, 250, 80);
		Rectangle r =  new Rectangle(120, 200, 250, 150);
		
		Rectangle o = t.intersection(r);
		
		System.out.printf("x=%d y=%d w=%d h=%d\n", o.x, o.y, o.width, o.height);
	}
}
