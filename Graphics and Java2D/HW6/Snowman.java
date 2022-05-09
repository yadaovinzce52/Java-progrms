package HW6;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Snowman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Snowman");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		SnowmanJPanel shapesJPanel = new SnowmanJPanel();
		frame.add(shapesJPanel);
		frame.setSize(600,400);
		frame.setVisible(true);
	}

}

class SnowmanJPanel extends JPanel{
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		// Draw head of snowman
		int height = getHeight(); 
		int diameter = (int)(height * 3/4 * 1/2 * 1/3);
		
		int x = getWidth()/2 - diameter/2;
		int y = diameter;
		
		Random rand = new Random();
		Color c = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
		g2d.setColor(c);
		g2d.drawOval(x, y, diameter, diameter);
		
		//Draw middle circle of snowman
		int diameter1 = (int)(height * 3/4 * 1/2 * 2/3);
		
		int x1 = getWidth()/2 - diameter1/2;
		int y1 = diameter1;
		
		Color c1 = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
		g2d.setColor(c1);
		g2d.drawOval(x1, y1, diameter1, diameter1);
		
		//Draw bottom circle of snowman
		int diameter2 = (int)((diameter + diameter1));
		
		int x2 = getWidth()/2 - diameter2/2;
		int y2 = getHeight();
		y2 = y2 * 1/2;
		
		Color c2 = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
		g2d.setColor(c2);
		g2d.drawOval(x2, y2, diameter2, diameter2);
		
		//sets the color of the eyes and arms
		g2d.setColor(Color.BLACK);
		
		//Draws the two eyes
		g2d.fillOval((int)(getWidth() * .5 * .97), (int)(getHeight() * .5 * .35), 6, 6);
		g2d.fillOval((int)(getWidth() * .5 * 1.03), (int)(getHeight() * .5 * .35), 6, 6);
		
		//Draws the two arms
		g2d.drawLine((int)(getWidth() * .5 * .93), (int)(getHeight() * .5 * .70), (int)(getWidth() * .5 * .70), (int)(getHeight() * .5 * .50));
		g2d.drawLine((int)(getWidth() * .5 * 1.07), (int)(getHeight() * .5 * .70), (int)(getWidth() * .5 * 1.30), (int)(getHeight() * .5 * .50));
	}
}