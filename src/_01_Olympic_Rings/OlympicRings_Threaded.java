package _01_Olympic_Rings;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One robot should draw one ring simultaneously with the other 4 robots.
	public static void main(String[] args) {
		Robot b = new Robot(100, 300);
		b.setPenColor(0, 0, 255);
		Robot y = new Robot(300, 300);
		y.setPenColor(255, 255, 0);
		Robot bl = new Robot(500, 300);
		bl.setPenColor(0, 0, 0);
		Robot g = new Robot(700, 300);
		g.setPenColor(0, 255, 0);
		Robot r = new Robot(900, 300);
		r.setPenColor(255, 0, 0);
		
		Thread r1 = new Thread(()->sync(b));
		Thread r2 = new Thread(()->sync(y));
		Thread r3 = new Thread(()->sync(bl));
		Thread r4 = new Thread(()->sync(g));
		Thread r5 = new Thread(()->sync(r));
		
		r1.start();
		r2.start();
		r3.start();
		r4.start();
		r5.start();
		
	}
	
	public static void sync(Robot ro) {
		ro.hide();
		ro.setPenWidth(10);
		ro.penDown();
		
		int size = 30;
		int quality = 10;
		
		for (int i = 0; i < 360/quality; i++) {
			ro.move(size);
			ro.turn(quality);
		}
	}
}

