package main;

import static main.Comps.STARTBUTTON;
import static main.Comps.BLUEPLAYER;
import static main.Comps.PLACES;
import static main.Comps.PREVPOS;
import static main.Comps.REDPLAYER;
import static main.Comps.REDTURN;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class CheckersGame extends JPanel {

	public CheckersGame() {
		setLayout(new GridLayout(8, 8));
		setBackground(Color.WHITE);
		initField();
		//changeButtons();
	}

	private void changeButtons() {
		boolean flag = false;
		int counter = 0;
		int reds = 12, blacks = 12, none = 8;

		for (Entry<Integer, JButton> c : Comps.FIELD.entrySet()) {
			Integer pos = c.getKey();
			boolean cond = pos % 2 == 0;

			if (counter == 8) {
				flag = !flag;
				counter = 0;
			}
			counter++;

			JButton piece = c.getValue();
			JLabel lbl = new JLabel();
			if (cond != flag) {
				piece.setBackground(Color.BLACK);
				if (reds > 0) {
					lbl.setIcon(Comps.RED);
					piece.add(lbl);
					Comps.REDPLAYER.put(pos, piece);
					reds--;
				} else if (none > 0) {
					Comps.PLACES.put(pos, piece);
					none--;
				} else if (blacks > 0) {
					lbl.setIcon(Comps.BLUE);
					piece.add(lbl);
					Comps.BLUEPLAYER.put(pos, piece);
					reds--;
				}
				piece.addActionListener(this::clicked);
			} else {
				piece.setEnabled(false);
				piece.setBackground(Color.WHITE);
			}
		}
	}

	private void initField() {
		Board board = new Board();
		board.getField().stream().forEach(l -> l.stream().forEach(piece -> this.add(piece.getButton())));
	}

	public void clicked(ActionEvent e) {
		JButton clickedButton = (JButton) e.getSource();

		int pos = Integer.parseInt(clickedButton.getName());
		if (Comps.BLUEPLAYER.get(pos) != null) {
			// blue piece
			System.out.println("BLUE PLAYER == POS: " + clickedButton.getName());
			if (playerChosen(clickedButton)) {

				calculatePossibleMoves(pos, "BLUE");
			} else {
			}

		} else if (Comps.REDPLAYER.get(pos) != null) {
			// red piece
			System.out.println("RED PLAYER == POS: " + clickedButton.getName());
			if (playerChosen(clickedButton)) {

				calculatePossibleMoves(pos, "RED");
			} else {
			}
		} else if (Comps.PLACES.get(pos) != null) {
			// places to move
			System.out.println("FREE SPOT == POS: " + clickedButton.getName());
			if (PREVPOS != -1) {

				JButton prevButton = getPrevButton();

				clickedButton.setBackground(Color.ORANGE);

				prevButton.setBackground(Color.RED);

				PLACES.put(PREVPOS, clickedButton);

				if (REDTURN) {
					REDPLAYER.put(pos, prevButton);
					REDPLAYER.remove(PREVPOS);
				} else {
					BLUEPLAYER.put(pos, prevButton);
					BLUEPLAYER.remove(PREVPOS);
				}
				PLACES.remove(pos);

				REDTURN = !REDTURN;

				System.out.println("piece moved from " + PREVPOS + " TO " + pos);

				STARTBUTTON.setBackground(Color.CYAN);

			}
		} else {
			// should never get here
			System.out.println("CAN'T MOVE HERE");
		}
	}

	private JButton getPrevButton() {
		if (REDTURN)
			return REDPLAYER.get(PREVPOS);
		else
			return BLUEPLAYER.get(PREVPOS);
	}

	private boolean playerChosen(JButton b) {
		if (b.getBackground().equals(Color.YELLOW)) {
			b.setBackground(Color.BLACK);
			PREVPOS = -1;
			return false;
		} else {
			b.setBackground(Color.YELLOW);
			PREVPOS = Integer.parseInt(b.getName());
			return true;
		}
	}

	private void calculatePossibleMoves(int pos, String team) {
		int rightPos;
		int leftPos;
		if (team.equals("RED")) {
			rightPos = pos + 7;
			leftPos = pos + 9;
		} else {
			rightPos = pos - 7;
			leftPos = pos - 9;
		}
		JButton l = PLACES.get(leftPos);
		JButton r = PLACES.get(rightPos);

		if (l != null) {
			l.setBackground(Color.GREEN);
			l.setEnabled(true);
		}

		if (r != null) {
			r.setBackground(Color.GREEN);
			r.setEnabled(true);
		}
	}

}
