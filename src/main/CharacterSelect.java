package main;

import javax.imageio.ImageIO;
import main.CharacterSelectButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import main.GamePanel;

public class CharacterSelect extends Frame implements ActionListener {

	JButton batman_button, robin_button, signal_button, soldier1_button;
	public BufferedImage batman, robin, signal, soldier1;
	public static GamePanel gamePanel;

	CharacterSelect() {

		try {
			batman = ImageIO.read(getClass().getResourceAsStream("/player/batman/batman_character_select_128.png"));
			robin = ImageIO.read(getClass().getResourceAsStream("/player/robin/robin_character_select_128.png"));
			signal = ImageIO.read(getClass().getResourceAsStream("/player/signal/signal_character_select_128.png"));
			soldier1 = ImageIO
					.read(getClass().getResourceAsStream("/player/soldiers/soldier1_character_select_128.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		//		batman_button = new JButton(new AbstractAction("Batman") {
		//			@Override
		//			public void actionPerformed(ActionEvent e) {
		//				// TODO Auto-generated method stub
		//
		//				JFrame window = new JFrame();
		//				window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//				window.setResizable(false);
		//				window.setTitle("2D RPG");
		//
		//				GamePanel gamePanel = new GamePanel("Batman");
		//				window.add(gamePanel);
		//
		//				window.pack();
		//
		//				window.setLocationRelativeTo(null);
		//				window.setVisible(true);
		//
		//				setVisible(false);
		//
		//				gamePanel.setupGame();
		//				gamePanel.startGameThread();
		//
		//			}
		//
		//		});
		//
		//		batman_button.setBorder(BorderFactory.createEmptyBorder());
		//		batman_button.setContentAreaFilled(false);
		//		batman_button.setBounds(0, 0, 200, 200);
		//		batman_button.addActionListener(this);
		//		batman_button.setIcon(new ImageIcon(batman));
		//
		//		add(batman_button);

		//Object to create buttons for player to choose character
		CharacterSelectButton button = new CharacterSelectButton();

		//Button for player to use Batman
		batman_button = button.createButton(this, "Batman", batman, 0, 0, 200, 200);
		batman_button.addActionListener(this);
		add(batman_button);

		//Button for player to use Robin
		robin_button = button.createButton(this, "Robin", robin, 200, 0, 200, 200);
		robin_button.addActionListener(this);
		add(robin_button);

		////Button for player to use Signal
		signal_button = button.createButton(this, "Signal", signal, 400, 0, 200, 200);
		signal_button.addActionListener(this);
		add(signal_button);

		//Button for player to use Soldier 1
		soldier1_button = button.createButton(this, "Soldier 1", soldier1, 0, 200, 200, 200);
		soldier1_button.addActionListener(this);
		add(soldier1_button);

		//		robin_button = new JButton(new AbstractAction("Robin") {
		//			@Override
		//			public void actionPerformed(ActionEvent e) {
		//				// TODO Auto-generated method stub
		//
		//				JFrame window = new JFrame();
		//				window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//				window.setResizable(false);
		//				window.setTitle("2D RPG");
		//
		//				GamePanel gamePanel = new GamePanel("Robin");
		//				window.add(gamePanel);
		//
		//				window.pack();
		//
		//				window.setLocationRelativeTo(null);
		//				window.setVisible(true);
		//
		//				setVisible(false);
		//
		//				gamePanel.setupGame();
		//				gamePanel.startGameThread();
		//
		//			}
		//
		//		});
		//
		//		robin_button.setBorder(BorderFactory.createEmptyBorder());
		//		robin_button.setContentAreaFilled(false);
		//		robin_button.setBounds(300, 0, 200, 200);
		//		robin_button.addActionListener(this);
		//		robin_button.setIcon(new ImageIcon(robin));
		//
		//		add(robin_button);
		//		
		//		
		//		
		//		signal_button = new JButton(new AbstractAction("Signal") {
		//			@Override
		//			public void actionPerformed(ActionEvent e) {
		//				// TODO Auto-generated method stub
		//
		//				JFrame window = new JFrame();
		//				window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//				window.setResizable(false);
		//				window.setTitle("2D RPG");
		//
		//				GamePanel gamePanel = new GamePanel("Signal");
		//				window.add(gamePanel);
		//
		//				window.pack();
		//
		//				window.setLocationRelativeTo(null);
		//				window.setVisible(true);
		//
		//				setVisible(false);
		//				
		//				gamePanel.setupGame();
		//				gamePanel.startGameThread();
		//
		//			}
		//
		//		});
		//
		//		signal_button.setBorder(BorderFactory.createEmptyBorder());
		//		signal_button.setContentAreaFilled(false);
		//		signal_button.setBounds(0, 200, 200, 200);
		//		signal_button.addActionListener(this);
		//		signal_button.setIcon(new ImageIcon(signal));
		//
		//		add(signal_button);

		setSize(600, 600);
		setLayout(null);
		setVisible(true);
		this.setBackground(Color.LIGHT_GRAY);
	}

	public static void main(String[] args) {

		new CharacterSelect();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		//		JFrame window = new JFrame();
		//		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//		window.setResizable(false);
		//		window.setTitle("2D RPG");
		//		
		//		GamePanel gamePanel = new GamePanel("Batman");
		//		window.add(gamePanel);
		//		
		//		window.pack();
		//		
		//		window.setLocationRelativeTo(null);
		//		window.setVisible(true);
		//		
		//		this.setVisible(false);
		//		
		//		gamePanel.startGameThread();

	}

}