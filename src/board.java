import java.awt.*;
import javax.swing.*;

public class board extends JPanel implements commons{
	
	private Dimension d;
	
	int test = 0;
	double interpolation = 0;

	public board(){
		d = new Dimension(BOARD_WIDTH, BOARD_HEIGHT);
		setBackground(Color.black);
		
		run();
	}
	
	public void run() {
	    double next_game_tick = System.currentTimeMillis();
	    int loops;

	    while (true) {
	        loops = 0;
	        while (System.currentTimeMillis() > next_game_tick
	                && loops < MAX_FRAMESKIP) {

	            update_game();

	            next_game_tick += SKIP_TICKS;
	            loops++;
	        }

	        interpolation = (System.currentTimeMillis() + SKIP_TICKS - next_game_tick
	                / (double) SKIP_TICKS);
	        display_game(interpolation);
	    }
	}
	
	
	
	public void display_game(double i) {
		test++;
		if (test >= 60) test = 0;
	}
	
	public void update_game() {
		repaint();
	}
	
	public void paint(Graphics g){
		super.paint(g);
		
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, test, test);
	}
}
