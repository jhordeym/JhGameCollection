package main;

import java.awt.Color;

import javax.swing.JButton;

public class Piece {

	private int position;
	private JButton button;
	private String team;
	private boolean alive;

	public Piece() {
	}

	private Piece(JButton button) {
		this.button = button;
	}

	private Piece(JButton button, boolean alive) {
		this(button);
		this.alive = alive;
		this.team = "NOT NULL";
	}

	public Piece(JButton button, boolean alive, String team, int position) {
		this(button, alive);
		this.team = team;
		this.position = position;
	}

	/* Getters */
	public int getPosition() {
		return position;
	}

	public JButton getButton() {
		return button;
	}

	public String getTeam() {
		return team;
	}

	public boolean isAlive() {
		return alive;
	}

	/* Setters */
	public Piece setPosition(int position) {
		this.position = position;
		return this;
	}

	public Piece setButton(JButton button) {
		this.button = button;
		return this;
	}

	public Piece setTeam(String team) {
		this.team = team;
		return this;
	}

	public Piece setAlive(boolean alive) {
		this.alive = alive;
		return this;
	}

	public static Piece clone(Piece p) {
		JButton b = new JButton();
		b.setBackground(p.getButton().getBackground());
		return new Piece(b, p.isAlive(), p.getTeam(), p.getPosition());
	}
	
	public static Piece B() {
		JButton b = new JButton();
		b.setBackground(Color.BLACK);
		Piece p = new Piece(b);
		return p;
	}
	
	public static Piece W() {
		JButton b = new JButton();
		b.setBackground(Color.WHITE);
		Piece p = new Piece(b);
		return p;
	}
}
