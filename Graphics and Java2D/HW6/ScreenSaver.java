package HW6;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ScreenSaver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("ScreenSaver");
		
		ScreenSaverJPanel shapesJPanel = new ScreenSaverJPanel();
		frame.add(shapesJPanel);
		frame.setSize(800,600);
		frame.setVisible(true);
	}

}

class ScreenSaverJPanel extends JPanel implements ActionListener{
	protected Timer timer;
	
	public ScreenSaverJPanel() {
		timer = new Timer(1000, this);
		timer.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		Random rand = new Random();
		
		
		int width = getWidth();
		int height = getHeight();
		for(int i = 0; i < 30; i++) {
			g2d.setStroke(new BasicStroke(rand.nextInt(11) + 1));
			Color c = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
			g2d.setColor(c);
			int x = rand.nextInt(width - 1);
			int y = rand.nextInt(height - 1);
			int w = rand.nextInt(width - x) + 1;
			int h = rand.nextInt(height - y) + 1;
			g2d.drawOval(x, y, w, h);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}
}
