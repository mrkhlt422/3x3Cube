import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class CubeDrawer{
	
	private Cube cube;
	
	public CubeDrawer(Cube cube) {
		setCube(cube);
	}
	
	public void setCube(Cube cube) {
		this.cube = cube;
	}
	
	public Cube getCube() {
		return cube;
	}
	
	public void drawCube() {
		JFrame window = new JFrame();
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setBounds(0, 0, 600, 600);
		window.getContentPane().add(new Canvas(cube));
		window.setVisible(true);
	}
	
	private class Canvas extends JComponent{
		
		private Cube cube;
		
		private int lineLength = 150;
		private int xmid = 150;
		private int ystart = 200;
		private double radian = Math.PI / 6;
		
		private int xmid2 = 600 - xmid;
		private int ystart2 = 600 - ystart;
		
		private int xdiff = (int) (Math.cos(radian) * lineLength);
		private int ydiff = (int) (Math.sin(radian) * lineLength);
		
		public Canvas(Cube cube) {
			this.cube = cube;
		}
		
		public void paint(Graphics g) {
			drawBasicCube(g);
			drawColors(g);
		}
		
		private void drawBasicCube(Graphics g) {
			
			g.drawLine(xmid, ystart, xmid, ystart + lineLength);
			g.drawLine(xmid + xdiff, ystart - ydiff, xmid + xdiff, ystart + lineLength - ydiff);
			g.drawLine(xmid - xdiff, ystart - ydiff, xmid - xdiff, ystart + lineLength - ydiff);
			g.drawLine(xmid, ystart, xmid + xdiff, ystart - ydiff);
			g.drawLine(xmid, ystart, xmid - xdiff, ystart - ydiff);
			g.drawLine(xmid, ystart + lineLength, xmid + xdiff, ystart + lineLength - ydiff);
			g.drawLine(xmid, ystart + lineLength, xmid - xdiff, ystart + lineLength - ydiff);
			g.drawLine(xmid + xdiff, ystart - ydiff, xmid, ystart - 2*ydiff);
			g.drawLine(xmid - xdiff, ystart - ydiff, xmid, ystart - 2*ydiff);
			
			g.drawLine(xmid2, ystart2, xmid2, ystart2 + lineLength);
			g.drawLine(xmid2 + xdiff, ystart2 - ydiff, xmid2 + xdiff, ystart2 + lineLength - ydiff);
			g.drawLine(xmid2 - xdiff, ystart2 - ydiff, xmid2 - xdiff, ystart2 + lineLength - ydiff);
			g.drawLine(xmid2, ystart2, xmid2 + xdiff, ystart2 - ydiff);
			g.drawLine(xmid2, ystart2, xmid2 - xdiff, ystart2 - ydiff);
			g.drawLine(xmid2, ystart2 + lineLength, xmid2 + xdiff, ystart2 + lineLength - ydiff);
			g.drawLine(xmid2, ystart2 + lineLength, xmid2 - xdiff, ystart2 + lineLength - ydiff);
			g.drawLine(xmid2 + xdiff, ystart2 - ydiff, xmid2, ystart2 - 2*ydiff);
			g.drawLine(xmid2 - xdiff, ystart2 - ydiff, xmid2, ystart2 - 2*ydiff);
		}
		
		private void drawColors(Graphics g) {
			drawWhiteSide(g);
//			drawGreenSide(g);
//			drawOrangeSide(g);
//			drawBlueSide(g);
//			drawRedSide(g);
			drawYellowSide(g);
		}
		
		private void drawWhiteSide(Graphics g) {
			for(int i = 2; i >= 0; i--) {
				for(int j = 2; j >= 0; j--) {
					switch (cube.getFaces()[0][i][j]) {
						case 'w' :
							g.setColor(Color.WHITE);
							break;
						case 'g' :
							g.setColor(Color.GREEN);
							break;
						case 'o' :
							g.setColor(Color.ORANGE);
							break;
						case 'b' :
							g.setColor(Color.BLUE);
							break;
						case 'r' :
							g.setColor(Color.RED);
							break;
						case 'y' :
							g.setColor(Color.YELLOW);
							break;
					}
					int tempx = 0;
					int tempy = 0;
					switch (i+j) {
						case 0 :
							tempy = 4*ydiff/3;
							break;
						case 1 :
							tempy = ydiff;
							break;
						case 2 :
							tempy = 2*ydiff/3;
							break;
						case 3 :
							tempy = ydiff/3;
							break;
						case 4 :
							tempy = 0;
							break;
							
					}
					
					if(i == j) {
						tempx = 0;
					}
					else if(i - j == 1) {
						tempx = xdiff/3;
					}
					else if(i - j == -1) {
						tempx = -1*xdiff/3;
					}
					else if(i - j == 2) {
						tempx = 2*xdiff/3;
					}
					else if(i - j == -2) {
						tempx = -2*xdiff/3;
					}
					
					
					int[] xpoints = {xmid - tempx, xmid - tempx + xdiff/3, xmid - tempx, xmid - tempx - xdiff/3, xmid - tempx};
					int[] ypoints = {ystart - tempy, ystart - tempy - ydiff/3, ystart - tempy - (2*ydiff/3), ystart - tempy - ydiff/3, ystart - tempy};
					g.fillPolygon(xpoints, ypoints, 5);
				}
			}
		}
		
		private void drawYellowSide(Graphics g) {
			for(int i = 2; i >= 0; i--) {
				for(int j = 2; j >= 0; j--) {
					switch (cube.getFaces()[5][2-i][2-j]) {
						case 'w' :
							g.setColor(Color.WHITE);
							break;
						case 'g' :
							g.setColor(Color.GREEN);
							break;
						case 'o' :
							g.setColor(Color.ORANGE);
							break;
						case 'b' :
							g.setColor(Color.BLUE);
							break;
						case 'r' :
							g.setColor(Color.RED);
							break;
						case 'y' :
							g.setColor(Color.YELLOW);
							break;
					}
					int tempx = 0;
					int tempy = 0;
					switch (i+j) {
						case 0 :
							tempy = 4*ydiff/3;
							break;
						case 1 :
							tempy = ydiff;
							break;
						case 2 :
							tempy = 2*ydiff/3;
							break;
						case 3 :
							tempy = ydiff/3;
							break;
						case 4 :
							tempy = 0;
							break;
							
					}
					
					if(i == j) {
						tempx = 0;
					}
					else if(i - j == 1) {
						tempx = xdiff/3;
					}
					else if(i - j == -1) {
						tempx = -1*xdiff/3;
					}
					else if(i - j == 2) {
						tempx = 2*xdiff/3;
					}
					else if(i - j == -2) {
						tempx = -2*xdiff/3;
					}
					
					
					int[] xpoints = {xmid2 - tempx, xmid2 - tempx + xdiff/3, xmid2 - tempx, xmid2 - tempx - xdiff/3, xmid2 - tempx};
					int[] ypoints = {ystart2 - tempy, ystart2 - tempy - ydiff/3, ystart2 - tempy - (2*ydiff/3), ystart2 - tempy - ydiff/3, ystart2 - tempy};
					g.fillPolygon(xpoints, ypoints, 5);
				}
			}
		}
	}
}


