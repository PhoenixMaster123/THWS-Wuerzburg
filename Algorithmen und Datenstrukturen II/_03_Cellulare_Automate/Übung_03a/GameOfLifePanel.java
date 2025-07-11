package _03_Cellulare_Automate.Übung_03a;

import java.awt.Graphics;
import java.util.Random;
import java.awt.Color;
import javax.swing.JPanel;

public class GameOfLifePanel extends JPanel implements Runnable {

	private Random rand = new Random();
	private int[][] matrix = new int[50][50];  // Main matrix
	private int[][] matrix_tmp = new int[50][50];  // Temporary matrix to store the next state

	public GameOfLifePanel() {
		// Initialize the matrix with random 0s and 1s (dead and alive cells)
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				matrix[row][col] = rand.nextInt(2);  // 0 = dead, 1 = alive
			}
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(250); // Delay between generations
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			applyRules();  // Update the matrix for the next generation
			repaint();     // Redraw the grid with the updated state
		}
	}

	private void applyRules() {
		// Loop through every cell and apply the Game of Life rules
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				int liveNeighbors = countLiveNeighbors(row, col);

				// Apply the rules of Conway's Game of Life
				if (matrix[row][col] == 1) {
					// A live cell dies if it has fewer than 2 or more than 3 live neighbors
					matrix_tmp[row][col] = (liveNeighbors == 2 || liveNeighbors == 3) ? 1 : 0;
				} else {
					// A dead cell becomes alive if it has exactly 3 live neighbors
					matrix_tmp[row][col] = (liveNeighbors == 3) ? 1 : 0;
				}
			}
		}

		// Copy the updated state from matrix_tmp back to matrix
		for (int i = 0; i < matrix.length; i++) {
			System.arraycopy(matrix_tmp[i], 0, matrix[i], 0, matrix[i].length);
		}
	}

	private int countLiveNeighbors(int row, int col) {
		int count = 0;
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				// Skip the current cell itself
				if (i == 0 && j == 0) continue;

				int newRow = row + i;
				int newCol = col + j;

				// Check if the neighboring cell is within bounds and alive
				if (isInBounds(newRow, newCol) && matrix[newRow][newCol] == 1) {
					count++;
				}
			}
		}
		return count;
	}

	private boolean isInBounds(int row, int col) {
		return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		int ypos = 10;

		for (int a = 0; a < matrix.length; a++) {
			int xpos = 20;

			for (int b = 0; b < matrix[a].length; b++) {
				if (matrix[a][b] == 0) {
					g.setColor(Color.gray);
					g.drawRect(xpos, ypos, 10, 10);
				} else {
					g.setColor(Color.black);
					g.fillRect(xpos, ypos, 10, 10);
				}
				xpos += 10;
			}
			ypos += 10;
		}
	}
}
