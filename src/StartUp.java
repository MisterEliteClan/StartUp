import javax.swing.*;

public class StartUp extends JFrame implements commons {

	public StartUp() {
        add(new board());
        setTitle("StartUp");
        setDefaultCloseOperation(EXIT_ON_CLOSE);    
        setSize(BOARD_WIDTH,BOARD_HEIGHT);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(true);
    }
	
	public static void main(String[] args) {
		new StartUp();
	}

}
