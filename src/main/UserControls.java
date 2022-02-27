package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class UserControls implements KeyListener {
	
	public boolean moveUp, moveDown, moveLeft, moveRight;

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		int keyCode = e.getKeyCode();
		
		if(keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {
			moveUp= true;
		}
		
		if(keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT) {
			moveLeft = true;
		}
		
		if(keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) {
			moveDown = true; 
		}
		
		if(keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT) {
			moveRight = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		int keyCode = e.getKeyCode();
		
		if(keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {
			moveUp= false;
		}
		
		if(keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT ){
			moveLeft = false;
		}
		
		if(keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN ) {
			moveDown = false; 
		}
		
		if(keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT ) {
			moveRight =false;
		}
	}

}
