package main;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	GamePanel() {
		setLayout(new GridLayout(1, 3));
		
		Comps.STARTBUTTON.addActionListener(this::start);
		add(Comps.P1LABEL);
		add(Comps.STARTBUTTON);
		add(Comps.P2LABEL);
	}
	
	private void start(ActionEvent e) {
		Comps.game.start();
		Comps.STARTBUTTON.setEnabled(false);		
	}
}
