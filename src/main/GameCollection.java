package main;

import java.awt.BorderLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameCollection extends JFrame {

	public GameCollection() {
		setSize(800, 600);
		setTitle("Jhordeym Game Collection - Checkers Game");
		getContentPane().add(new GamePanel(), BorderLayout.NORTH);
		getContentPane().add(new CheckersGame(), BorderLayout.CENTER);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		//setResizable(false);
	}
}
