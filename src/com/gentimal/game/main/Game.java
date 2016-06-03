package com.gentimal.game.main;

import javax.swing.JFrame;

public class Game extends JFrame {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("StartUp - preAlpha");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setContentPane(new Panel());
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}