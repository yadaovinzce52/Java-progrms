package HW6;

import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Triangles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Triangles");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		TrianglesJPanel shapesJPanel = new TrianglesJPanel();
		frame.add(shapesJPanel);
		frame.setSize(600, 600);
		frame.setVisible(true);
	}

}

class TrianglesJPanel extends JPanel{
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		Random rand = new Random();
		int[] x = new int[3];
		int[] y = new int[3]; 
		
		int width = getWidth();
		int height = getHeight();
		for(int i = 0; i < 3; i++) {
			x[i] = rand.nextInt(width);
			y[i] = rand.nextInt(height);
		}
		
		GeneralPath triangle = new GeneralPath();
		triangle.moveTo(x[0], y[0]);
		triangle.lineTo(x[1], y[1]);
		triangle.lineTo(x[2], y[2]);
		triangle.closePath();
		
		Color c = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
		g2d.setColor(c);
		g2d.fill(triangle);
		
		for(int i = 0; i < 3; i++) {
			x[i] = rand.nextInt(width);
			y[i] = rand.nextInt(height);
		}
		
		GeneralPath triangle1 = new GeneralPath();
		triangle1.moveTo(x[0], y[0]);
		triangle1.lineTo(x[1], y[1]);
		triangle1.lineTo(x[2], y[2]);
		triangle1.closePath();
		
		Color c1 = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
		g2d.setColor(c1);
		g2d.fill(triangle1);
		
		for(int i = 0; i < 3; i++) {
			x[i] = rand.nextInt(width);
			y[i] = rand.nextInt(height);
		}
		
		GeneralPath triangle2 = new GeneralPath();
		triangle2.moveTo(x[0], y[0]);
		triangle2.lineTo(x[1], y[1]);
		triangle2.lineTo(x[2], y[2]);
		triangle2.closePath();
		
		Color c2 = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
		g2d.setColor(c2);
		g2d.fill(triangle2);
		
		for(int i = 0; i < 3; i++) {
			x[i] = rand.nextInt(width);
			y[i] = rand.nextInt(height);
		}
		
		GeneralPath triangle3 = new GeneralPath();
		triangle3.moveTo(x[0], y[0]);
		triangle3.lineTo(x[1], y[1]);
		triangle3.lineTo(x[2], y[2]);
		triangle3.closePath();
		
		Color c3 = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
		g2d.setColor(c3);
		g2d.fill(triangle3);
		
		for(int i = 0; i < 3; i++) {
			x[i] = rand.nextInt(width);
			y[i] = rand.nextInt(height);
		}
		
		GeneralPath triangle4 = new GeneralPath();
		triangle4.moveTo(x[0], y[0]);
		triangle4.lineTo(x[1], y[1]);
		triangle4.lineTo(x[2], y[2]);
		triangle4.closePath();
		
		Color c4 = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
		g2d.setColor(c4);
		g2d.fill(triangle4);
	}
}