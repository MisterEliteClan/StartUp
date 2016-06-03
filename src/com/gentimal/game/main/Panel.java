package com.gentimal.game.main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import com.gentimal.game.gamestate.GameStateManager;

public class Panel extends JPanel implements Runnable, KeyListener{
		
	//	Panel
	public static final int WIDTH = 320;
    public static final int HEIGHT = 240;
    public static final int SCALE = 2;
    
    //	Loop
    private Thread thread;
    private boolean running = false;
    private int FPS = 60;
    private long targetTime = 1000 / FPS;
    
    //	Drawing
    private Graphics2D g;
    private BufferedImage image;
    
    //	GameStateManager
    private GameStateManager gsm;

	public Panel() {
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setFocusable(true);
		requestFocus();
	}
	
	public void addNotify() {
		super.addNotify();
		if(thread == null) {
			running = true;
			addKeyListener(this);
			thread = new Thread(this);
			thread.start();
		}
	}
	
	public void init(){
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		
		gsm = new GameStateManager();
	}
	
	public void update(){
		gsm.update();
	}
	
	public void draw(){
		g.clearRect(0, 0, WIDTH, HEIGHT);
		
		gsm.draw(g);
	}
	
	public void drawToScreen(){
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
		g2.dispose();
	}
	
	public void run() {
				
		init();
		
	    long start;
	    long elapsed;
	    long wait;
	     
	    while(running) {
	    	start = System.nanoTime();
	    	 
	    	update();
	    	draw();
	    	drawToScreen();
	    	 
	    	elapsed = System.nanoTime() - start;
	    	wait = targetTime = elapsed / 1000000;
	    	 
	    	if(wait < 0)wait = 5;
	    	try {
	    		Thread.sleep(wait);
	    	} catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    }
	}
	
	public void keyPressed(KeyEvent k) {
		gsm.keyPressed(k.getKeyCode());
	}
	
	public void keyReleased(KeyEvent k) {
		gsm.keyReleased(k.getKeyCode());
	}

	public void keyTyped(KeyEvent k) {
		
	}
}