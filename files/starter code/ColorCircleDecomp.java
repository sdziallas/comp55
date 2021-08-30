import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import acm.graphics.*;
import acm.program.*;

public class ColorCircleDecomp extends GraphicsProgram implements ActionListener {
	public static final int PROGRAM_WIDTH = 800;
	public static final int PROGRAM_HEIGHT = 600;
	public static final int BALL_SIZE = 50;
	public static final int DELAY_MS = 25;
	
	//TODO create a private GOval here
	
	public void run() {
		//TODO add your ball here
		Timer t = new Timer(DELAY_MS, this);
		t.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
	}

	public void init() {
		setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
	}
	
	public static void main(String[] args) {
		new ColorCircleDecomp().start();
	}
	
}
