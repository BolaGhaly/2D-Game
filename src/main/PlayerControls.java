package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;

public class PlayerControls implements KeyListener {

	public boolean moveUp, moveDown, moveLeft, moveRight;
	GamePanel gamePanel;
	public boolean checkDebugTime = false;

	public PlayerControls(GamePanel gp) {
		this.gamePanel = gp;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		int keyCode = e.getKeyCode();

		if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {
			moveUp = true;
		}

		if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT) {
			moveLeft = true;
		}

		if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) {
			moveDown = true;
		}

		if (keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT) {
			moveRight = true;
		}

		// Zoom in and out
		// I on keyboard zooms in.
		// O on keyboard zooms out.
		if (keyCode == KeyEvent.VK_I) {
			gamePanel.zoomInOut(1);
		}

		if (keyCode == KeyEvent.VK_O) {
			gamePanel.zoomInOut(-1);
		}

		// DEBUG
		if (keyCode == KeyEvent.VK_T) {
			if (checkDebugTime == false) {
				checkDebugTime = true;
			} else if (checkDebugTime == true) {
				checkDebugTime = false;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

		int keyCode = e.getKeyCode();

		if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {
			moveUp = false;
		}

		if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT) {
			moveLeft = false;
		}

		if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) {
			moveDown = false;
		}

		if (keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT) {
			moveRight = false;
		}
	}

}
