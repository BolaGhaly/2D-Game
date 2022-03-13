package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class CharacterSelectButton {

	//String charcterName;

	public CharacterSelectButton() {

	}

	public JButton createButton(CharacterSelect cSelectWindow, String characterName, BufferedImage characterSprite,
			int topLeftX, int topLeftY, int xSize, int ySize) {

		JButton button = new JButton(new AbstractAction(characterName) {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				JFrame window = new JFrame();
				window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				window.setResizable(false);
				window.setTitle("2D RPG");

				GamePanel gamePanel = new GamePanel(characterName);
				window.add(gamePanel);

				window.pack();

				window.setLocationRelativeTo(null);
				window.setVisible(true);

				cSelectWindow.setVisible(false);

				gamePanel.setupGame();
				gamePanel.startGameThread();

			}

		});

		button.setBorder(BorderFactory.createEmptyBorder());
		button.setContentAreaFilled(false);
		button.setBounds(topLeftX, topLeftY, xSize, ySize);

		button.setIcon(new ImageIcon(characterSprite));

		return button;
	}
}
