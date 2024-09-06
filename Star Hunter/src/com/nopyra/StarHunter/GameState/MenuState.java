// The main menu GameState.

package com.nopyra.StarHunter.GameState;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.nopyra.StarHunter.Manager.Content;
import com.nopyra.StarHunter.Manager.GameStateManager;
import com.nopyra.StarHunter.Manager.JukeBox;
import com.nopyra.StarHunter.Manager.Keys;

public class MenuState extends GameState {
	
	private BufferedImage bg;
	private BufferedImage star;
	
	private int currentOption = 0;
	private String[] options = {
		"START",
		"QUIT"
	};
	
	public MenuState(GameStateManager gsm) {
		super(gsm);
	}
	
	public void init() {
		bg = Content.MENUBG[0][0];
		star = Content.STARS[0][0];
		JukeBox.load("/SFX/collect.wav", "collect");
		JukeBox.load("/SFX/menuoption.wav", "menuoption");
	}
	
	public void update() {
		handleInput();
	}
	
	public void draw(Graphics2D g) {
		
		g.drawImage(bg, 0, 0, null);
		
		Content.drawString(g, options[0], 46, 90);
		Content.drawString(g, options[1], 50, 100);
		
		if(currentOption == 0) g.drawImage(star, 25, 86, null);
		else if(currentOption == 1) g.drawImage(star, 25, 96, null);
		
	}
	
	public void handleInput() {
		if(Keys.isPressed(Keys.DOWN) && currentOption < options.length - 1) {
			JukeBox.play("menuoption");
			currentOption++;
		}
		if(Keys.isPressed(Keys.UP) && currentOption > 0) {
			JukeBox.play("menuoption");
			currentOption--;
		}
		if(Keys.isPressed(Keys.ENTER)) {
			JukeBox.play("collect");
			selectOption();
		}
	}
	
	private void selectOption() {
		if(currentOption == 0) {
			gsm.setState(GameStateManager.PLAY);
		}
		if(currentOption == 1) {
			System.exit(0);
		}
	}
	
}
