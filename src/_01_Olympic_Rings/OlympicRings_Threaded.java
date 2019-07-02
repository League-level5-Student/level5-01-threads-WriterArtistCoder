package _01_Olympic_Rings;

import java.awt.Color;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One robot should draw one ring simultaneously with the other 4 robots.
	public static void main(String[] args) {
		
		int startX = 100;
		int startY = 300;
		int spacingX = 250;
		int spacingY = 100;
		Robot r1 = new Robot(startX, startY); // Blue
		r1.setPenColor(Color.BLUE);
		
		Robot r2 = new Robot(startX+(spacingX*1), startY+spacingY); // Yellow
		r2.setPenColor(Color.YELLOW);
		
		Robot r3 = new Robot(startX+(spacingX*2), startY); // Black
		r3.setPenColor(Color.BLACK);
		
		Robot r4 = new Robot(startX+(spacingX*3), startY+spacingY); // Green
		r4.setPenColor(Color.GREEN);
		
		Robot r5 = new Robot(startX+(spacingX*4), startY); // Red
		r5.setPenColor(Color.RED);
		
		Thread t1 = new Thread(()->sync(r1));
		Thread t2 = new Thread(()->sync(r2));
		Thread t3 = new Thread(()->sync(r3));
		Thread t4 = new Thread(()->sync(r4));
		Thread t5 = new Thread(()->sync(r5));
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
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

