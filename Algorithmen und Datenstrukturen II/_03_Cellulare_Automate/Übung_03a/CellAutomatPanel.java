//Ueb 03a
package _03_Cellulare_Automate.Übung_03a;


import java.awt.Graphics;
import java.util.Random;
import java.awt.Color;
import javax.swing.JPanel;

public class CellAutomatPanel extends JPanel implements Runnable {

    private int speed = 2;
    private Random rand = new Random();

    int[][] matrix = new int[50][50];

    public CellAutomatPanel() {

	/**
	 * Bitte fügen Sie Ihren Code zum Starten des Automaten hier ein.
	 */
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {

				if(row == 0 || row == matrix.length - 1) {
					matrix[row][col] = 1;
				}
				else if(col == 0 || col == matrix[row].length - 1) {
					matrix[row][col] = 1;
				}
				else {
					matrix[row][col] = rand.nextInt(2);
				}
			}
		}
    }

	@Override
	public void run() {

	    int[][] matrix_tmp = new int[50][50];
	    for(int i = 0; i < matrix.length; i++) {
	    	for(int j = 0; j < matrix.length; j++) {
	    		matrix_tmp[i][j] = matrix[i][j];
	    	}
	    }

		for(int i = 0; i < 8; i++) {

	        try { Thread.sleep(2000);
	        } catch (InterruptedException e) { e.printStackTrace(); }

		/**
		 * Bitte fügen Sie Ihren Code zum Implementieren der Automatenregeln hier ein
		 */

	    	matrix = matrix_tmp;
	        repaint();
		}
	}

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        int ypos = 10;

        for(int a = 0; a < matrix.length; a++) {

            int xpos = 20;

            for(int b = 0; b < matrix[a].length; b++) {

            	if(matrix[a][b] == 0) {

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
