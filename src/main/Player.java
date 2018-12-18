package main;

import java.util.ArrayList;
import java.util.List;

public class Player {

	String team;
	
	List<Piece> pieces = new ArrayList<>();
	
	Player(String team) {
		this.team = team;
	}
	
	void move(Piece oldP, Piece newP) {
		
	}
}
