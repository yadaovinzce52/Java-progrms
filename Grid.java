package Minesweeper;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Grid extends JPanel{
	
	private final int images = 13;
	private final int cell_size = 15;
	
	private final int cover = 10;
	private final int marked = 10;
	private final int empty = 0;
	private final int mine = 9;
	private final int covered_mine = mine + cover;
	private final int marked_mine = cover + marked;
	
	private final int draw_mine = 9;
	private final int draw_cover = 10;
	private final int draw_mark = 11;
	private final int draw_wrong = 12;
	
	static int num_mines = 99;
	static int rows = 24;
	static int cols = 24;
	
	private final int width = cols * cell_size + 1;
	private final int height = rows * cell_size + 1;
	
	private int[] field;
	private boolean inGame;
	private int remaining_mines;
	private Image[] image;
	
	private int allCells;
	private final JLabel statusbar;
	
	public Grid(JLabel statusbar) {
		this.statusbar = statusbar;
		makeBoard();
	}
	
	public void makeBoard() {
		setPreferredSize(new Dimension(width, height));
		image = new Image[images];
		
		int i = 0;
		while(i < images) {
			var path = "src/pictures/" + i + ".png";
			image[i] = (new ImageIcon(path)).getImage();
			i++;
		}
		
		addMouseListener(new Mines());
		startGame();
	}
	
	private class Mines extends MouseAdapter{
		@Override
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			
			int cCol = x / cell_size;
			int cRow = y / cell_size;
			
			boolean doRepaint = false;
			
			if(!inGame){
				startGame();
				repaint();
			}
			
			if((x < cols * cell_size) && (y < rows * cell_size)) {
				if(e.getButton() == MouseEvent.BUTTON3) {
					if(field[(cRow * cols) + cCol] > mine) {
						doRepaint = true;
						if(field[(cRow * cols) + cCol] <= covered_mine){
							if(remaining_mines > 0) {
								field[(cRow * cols) + cCol] += marked;
								remaining_mines--;
								String string = Integer.toString(remaining_mines);
								statusbar.setText(string);
							}
							else {
								statusbar.setText("No marks left");
							}
						}
						else {
							field[(cRow * cols) + cCol] -= marked;
							remaining_mines++;
							String string = Integer.toString(remaining_mines);
							statusbar.setText(string);
						}
					}
				}
				else {
					if(field[(cRow * cols) + cCol] > covered_mine) {
						return;
					}
					
					if((field[(cRow * cols) + cCol] > mine) && (field[(cRow * cols) + cCol] < marked_mine)) {
						field[(cRow * cols) + cCol] -= cover;
						doRepaint = true;
						
						if(field[(cRow * cols) + cCol] == mine) {
							inGame = false;
						}
						
						if(field[(cRow * cols) + cCol] == empty) {
							find_empty_cells((cRow * cols) + cCol);
						}
					}
				}
				if(doRepaint) {
					repaint();
				}
			}
		}
	}
	
	
	private void find_empty_cells(int j) {
		int current = j % cols;
		int cell;
		
		if(current > 0) {
			cell = j - cols - 1;
			if(cell >= 0) {
				if(field[cell] > mine) {
					field[cell] -= cover;
					if(field[cell] == empty) {
						find_empty_cells(cell);
					}
				}
			}
			
			cell = j - 1;
			if(cell >= 0) {
				if(field[cell] > mine) {
					field[cell] -= cover;
					if(field[cell] == empty) {
						find_empty_cells(cell);
					}
				}
			}
			
			cell = j + cols - 1;
			if(cell < allCells) {
				if(field[cell] > mine) {
					field[cell] -= cover;
					if(field[cell] == empty) {
						find_empty_cells(cell);
					}
				}
			}
			
			cell = j - cols;
			if(cell >= 0) {
				if(field[cell] > mine) {
					field[cell] -= cover;
					if(field[cell] == empty) {
						find_empty_cells(cell);
					}
				}
			}
			
			cell = j + cols;
			if(cell < allCells) {
				if(field[cell] > mine) {
					field[cell] -= cover;
					if(field[cell] == empty) {
						find_empty_cells(cell);
					}
				}
			}
			
			if(current < (cols - 1)) {
				cell = j - cols + 1;
				if(cell >= 0) {
					if(field[cell] > mine) {
						field[cell] -= cover;
						if(field[cell] == empty) {
							find_empty_cells(cell);
						}
					}
				}
				
				cell = j + cols + 1;
				if(cell < allCells) {
					if(field[cell] > mine) {
						field[cell] -= cover;
						if(field[cell] == empty) {
							find_empty_cells(cell);
						}
					}
				}
				
				cell = j + 1;
				if(cell < allCells) {
					if(field[cell] > mine) {
						field[cell] -= cover;
						if(field[cell] == empty) {
							find_empty_cells(cell);
						}
					}
				}
			}
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		int uncover = 0;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++){
				int cell = field[(i * cols) + j];
				if(inGame && cell == mine) {
					inGame = false;
				}
				if(!inGame) {
					if(cell == covered_mine) {
						cell = draw_mine;
					}
					else if(cell == marked_mine) {
						cell = draw_mark;
					}
					else if(cell > covered_mine) {
						cell = draw_wrong;
					}
					else if(cell > mine) {
						cell = draw_cover;
					}
				}
				else {
					if(cell > covered_mine) {
						cell = draw_mark;
					}
					else if(cell > mine) {
						cell = draw_cover;
						uncover++;
					}
				}
				g.drawImage(image[cell], (j * cell_size), (i * cell_size), this);
			}
		}
		
		if(uncover == 0 && inGame) {
			inGame = false;
			statusbar.setText("You win :)");
		}
		else if(!inGame) {
			statusbar.setText("You lose :(");
		}
	}
	
	private void startGame() {

		int cell;
		
		var rand = new Random();
		inGame = true;
		remaining_mines = num_mines;
		
		allCells = rows * cols;
		field = new int[allCells];
		
		int i = 0;
		while(i < allCells) {
			field[i] = cover;
			i++;
		}
		
		statusbar.setText(Integer.toString(remaining_mines));
		
		int j = 0;
		while(j < num_mines) {
			int position = (int) (allCells * rand.nextDouble());
			
			if((position < allCells) && (field[position] != covered_mine)){
				int current = position % cols;
				field[position] = covered_mine;
				j++;
				
				if(current > 0) {
					cell = position - 1 - cols;
					if(cell >= 0) {
						if(field[cell] != covered_mine) {
							field[cell] += 1;
						}
					}
					cell = position - 1;
					if(cell >= 0) {
						if(field[cell] != covered_mine) {
							field[cell] += 1;
						}
					}
					cell = position + cols - 1;
					if(cell < allCells) {
						if(field[cell] != covered_mine) {
							field[cell] += 1;
						}
					}
				}
				
				cell = position - cols;
				if(cell >= 0) {
					if(field[cell] != covered_mine) {
						field[cell] += 1;
					}
				}
				
				cell = position + cols;
				if(cell < allCells) {
					if(field[cell] != covered_mine) {
						field[cell] += 1;
					}
				}
				
				if(current < (cols - 1)) {
					cell = position - cols + 1;
					if(cell >= 0) {
						if(field[cell] != covered_mine) {
							field[cell] += 1;
						}
					}
					cell = position + cols + 1;
					if(cell < allCells) {
						if(field[cell] != covered_mine) {
							field[cell] += 1;
						}
					}
					cell = position + 1;
					if(cell < allCells) {
						if(field[cell] != covered_mine) {
							field[cell] += 1;
						}
					}
				}
			}
		}
	}
}
