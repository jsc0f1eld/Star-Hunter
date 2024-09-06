// Congratulations for finishing the game.
// Gives you a rank based on how long it took for you to beat the game

// Under two minutes = Speed Runner
// Under three minutes = Adventurer
// Under four minutes = Beginner
// Four minutes or greater = Novice

package com.nopyra.StarHunter.GameState;

import java.awt.Color;
import java.awt.Graphics2D;

import com.nopyra.StarHunter.Main.GamePanel;
import com.nopyra.StarHunter.Manager.Content;
import com.nopyra.StarHunter.Manager.Data;
import com.nopyra.StarHunter.Manager.GameStateManager;
import com.nopyra.StarHunter.Manager.JukeBox;
import com.nopyra.StarHunter.Manager.Keys;


public class GameOverState extends GameState {
	
	private Color color;
	
	private int rank;
	private long ticks;
	
	public GameOverState(GameStateManager gsm) {
		super(gsm);
	}
	
	public void init() {
		color = new Color(0, 0, 0);
		ticks = Data.getTime();
		if(ticks < 3600) rank = 1;
		else if(ticks < 5400) rank = 2;
		else if(ticks < 7200) rank = 3;
		else rank = 4;
	}
	
	public void update() {}
	
	public void draw(Graphics2D g) {
		
		g.setColor(color);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT2);
		
		Content.drawString(g, "finish time", 21, 20);
		
		int minutes = (int) (ticks / 1800);
		int seconds = (int) ((ticks / 30) % 60);
		if(minutes < 10) {
			if(seconds < 10) Content.drawString(g, "0" + minutes + ":0" + seconds, 44, 35);
			else Content.drawString(g, "0" + minutes + ":" + seconds, 44, 35);
		}
		else {
			if(seconds < 10) Content.drawString(g, minutes + ":0" + seconds, 44, 35);
			else Content.drawString(g, minutes + ":" + seconds, 44, 35);
		}
		
		Content.drawString(g, "rank:", 47, 52);
		if(rank == 1) Content.drawString(g, "speed runner", 18, 68);
		else if(rank == 2) Content.drawString(g, "adventurer", 24, 68);
		else if(rank == 3) Content.drawString(g, "beginner", 32, 68);
		else if(rank == 4) Content.drawString(g, "newbie", 8, 68);
		
		Content.drawString(g, "THANKS FOR", 25, 95);
		Content.drawString(g, " PLAYING", 29, 110);
		
	}
	
	public void handleInput() {
		if (Keys.isPressed(Keys.SPACE)) {
			JukeBox.play("collect");
			gsm.setState(GameStateManager.MENU);
		}
	}
}

