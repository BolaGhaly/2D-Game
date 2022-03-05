package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import main.GamePanel;

public class characterSelect extends Frame implements ActionListener {

	JLabel l;
	JButton batman_button, robin_button;
	public BufferedImage batman, robin, nightwing;
	public static GamePanel gamePanel;

	characterSelect() {
		//ImageIcon batman = new ImageIcon("/player/batman/batman_down_1.png"); // load the image to a imageIcon
		//Image image = batman.getImage(); // transform it 
		//Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		//batman = new ImageIcon(newimg);  // transform it back
		//Icon batman= new ImageIcon("/player/batman/batman_down_1.png");
		//    	GamePanel gp = new GamePanel(""); 
		//    	gamePanel=gp;

		//        l=new JLabel("Batman");  
		//        l.setBounds(50,100, 250,20);      

		try {
			batman = ImageIO.read(getClass().getResourceAsStream("/player/batman/batman_character_select_128.png"));
			robin = ImageIO.read(getClass().getResourceAsStream("/player/robin/robin_character_select_128.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		batman_button = new JButton(new AbstractAction("Batman") {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				JFrame window = new JFrame();
				window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				window.setResizable(false);
				window.setTitle("2D RPG");

				GamePanel gamePanel = new GamePanel("Batman");
				window.add(gamePanel);

				window.pack();

				window.setLocationRelativeTo(null);
				window.setVisible(true);

				setVisible(false);

				gamePanel.startGameThread();

			}

		});

		batman_button.setBorder(BorderFactory.createEmptyBorder());
		batman_button.setContentAreaFilled(false);
		batman_button.setBounds(0, 0, 200, 200);
		batman_button.addActionListener(this);
		batman_button.setIcon(new ImageIcon(batman));

		add(batman_button);

		robin_button = new JButton(new AbstractAction("Robin") {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				JFrame window = new JFrame();
				window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				window.setResizable(false);
				window.setTitle("2D RPG");

				GamePanel gamePanel = new GamePanel("Robin");
				window.add(gamePanel);

				window.pack();

				window.setLocationRelativeTo(null);
				window.setVisible(true);

				setVisible(false);

				gamePanel.startGameThread();

			}

		});

		robin_button.setBorder(BorderFactory.createEmptyBorder());
		robin_button.setContentAreaFilled(false);
		robin_button.setBounds(300, 0, 200, 200);
		robin_button.addActionListener(this);
		robin_button.setIcon(new ImageIcon(robin));

		add(robin_button);

		setSize(600, 600);
		setLayout(null);
		setVisible(true);
		this.setBackground(Color.LIGHT_GRAY);
	}

	public static void main(String[] args) {

		new characterSelect();

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
