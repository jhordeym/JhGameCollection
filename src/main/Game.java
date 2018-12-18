package main;

import java.util.Random;

import javax.swing.JOptionPane;

public class Game {

	public boolean started;
	public boolean turn;
	public int moves;
	public String winner;

	private static Game game = new Game();

	private Game() {
	}

	public static Game get() {
		return game;
	}

	public int moves() {
		return moves++;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public void win() {
		JOptionPane.showMessageDialog(null, winner + "have won!");
		stop();
	}

	public void stop() {
		started = false;
	}

	public void start() {
		Random r = new Random(System.currentTimeMillis());
		turn = r.nextBoolean();
	}
}
