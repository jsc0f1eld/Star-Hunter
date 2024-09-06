// The pause GameState can only be activated
// by calling GameStateManager#setPaused(true).

package com.nopyra.StarHunter.GameState;

import java.awt.Graphics2D;

import com.nopyra.StarHunter.Manager.Content;
import com.nopyra.StarHunter.Manager.GameStateManager;
import com.nopyra.StarHunter.Manager.JukeBox;
import com.nopyra.StarHunter.Manager.Keys;

public class PauseState extends GameState {
	
	public PauseState(GameStateManager gsm) {
		super(gsm);
	}
	
	public void init() {}
	
	public void update() {
		handleInput();
	}
	
	public void draw(Graphics2D g) {
		
		Content.drawString(g, "paused", 40, 25);
		
		Content.drawString(g, "arrow", 12, 56);
		Content.drawString(g, "keys", 16, 65);
		Content.drawString(g, ": move", 52, 60);
		
		Content.drawString(g, "space", 12, 79);
		Content.drawString(g, ": action", 52, 79);
		
		Content.drawString(g, "F1:", 25, 95);
		Content.drawString(g, "return", 68, 95);
		Content.drawString(g, "to menu", 68, 105);
		
	}
	public void handleInput() {
		if(Keys.isPressed(Keys.ESCAPE)) {
			gsm.setPaused(false);
			JukeBox.resumeLoop("music1");
		}
		if(Keys.isPressed(Keys.F1)) {
			gsm.setPaused(false);
			gsm.setState(GameStateManager.MENU);
		}
	}
	
}
