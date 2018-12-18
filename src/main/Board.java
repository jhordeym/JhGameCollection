package main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import javax.swing.JButton;
import static main.Piece.*;

public class Board {

	private ArrayList<ArrayList<Piece>> field = new ArrayList<>();

	public Board() {
		int c = 0;
		while (c++ < 4) {
			field.add(new ArrayList<>(new ArrayList<>(Arrays.asList(B(), W(), B(), W(), B(), W(), B(), W()))
					.stream().map(Piece::clone).collect(Collectors.toList())));
			field.add(new ArrayList<>(new ArrayList<>(Arrays.asList(W(), B(), W(), B(), W(), B(), W(), B()))
					.stream().map(Piece::clone).collect(Collectors.toList())));
		}
	}

	public ArrayList<ArrayList<Piece>> getField() {
		return field;
	}
}
