package main;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Comps {
	
	static Game game = Game.get();

	static JLabel P1LABEL = new JLabel("RED PLAYER: 12", SwingConstants.CENTER);
	static JButton STARTBUTTON = new JButton("Start game");
	static JLabel P2LABEL = new JLabel("BLUE PLAYER: 12", SwingConstants.CENTER);
	
	public static Map<Integer, JButton> FIELD = new HashMap<>();
	public static Map<Integer, JButton> REDPLAYER = new HashMap<>();
	public static Map<Integer, JButton> BLUEPLAYER = new HashMap<>();
	public static Map<Integer, JButton> PLACES = new HashMap<>();

	public static final ImageIcon RED = new ImageIcon(
			new ImageIcon("res/red.png").getImage().getScaledInstance(64, 64, Image.SCALE_DEFAULT));
	public static final ImageIcon BLUE = new ImageIcon(
			new ImageIcon("res/blue.png").getImage().getScaledInstance(64, 64, Image.SCALE_DEFAULT));

	public static boolean REDTURN = false;
	public static boolean GAMESTARTED = false;
	
	public static int PREVPOS = -1;


}
