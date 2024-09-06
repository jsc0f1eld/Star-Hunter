// Contains a reference to the Player.
// Draws all relevant information at the
// bottom of the screen.

package com.nopyra.StarHunter.HUD;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.nopyra.StarHunter.Entity.Star;
import com.nopyra.StarHunter.Entity.Player;
import com.nopyra.StarHunter.Main.GamePanel;
import com.nopyra.StarHunter.Manager.Content;

public class Hud {
	
	private int yoffset;
	
	private BufferedImage bar;
	private BufferedImage star;
	private BufferedImage boat;
	private BufferedImage axe;
	
	private Player player;
	
	private int numStars;
	
	private Font font;
	private Color textColor; 
	
	public Hud(Player p, ArrayList<Star> d) {
		
		player = p;
		numStars = d.size();
		yoffset = GamePanel.HEIGHT;
		
		bar = Content.BAR[0][0];
		star = Content.STARS[0][0];
		boat = Content.ITEMS[0][0];
		axe = Content.ITEMS[0][1];
		
		font = new Font("Arial", Font.PLAIN, 10);
		textColor = new Color(229, 235, 56);
		
	}
	
	public void draw(Graphics2D g) {
		
		// draw hud
		g.drawImage(bar, 0, yoffset, null);
		
		// draw star bar
		g.setColor(textColor);
		g.fillRect(8, yoffset + 6, (int)(28.0 * player.numStars() / numStars), 4);
		
		// draw star amount
		g.setColor(textColor);
		g.setFont(font);
		String s = player.numStars() + "/" + numStars;
		Content.drawString(g, s, 40, yoffset + 3);
		if(player.numStars() >= 10) g.drawImage(star, 80, yoffset, null);
		else g.drawImage(star, 72, yoffset, null);
		
		// draw items
		if(player.hasBoat()) g.drawImage(boat, 100, yoffset, null);
		if(player.hasAxe()) g.drawImage(axe, 112, yoffset, null);
		
		// draw time
		int minutes = (int) (player.getTicks() / 1800);
		int seconds = (int) ((player.getTicks() / 30) % 60);
		if(minutes < 10) {
			if(seconds < 10) Content.drawString(g, "0" + minutes + ":0" + seconds, 85, 3);
			else Content.drawString(g, "0" + minutes + ":" + seconds, 85, 3);
		}
		else {
			if(seconds < 10) Content.drawString(g, minutes + ":0" + seconds, 85, 3);
			else Content.drawString(g, minutes + ":" + seconds, 85, 3);
		}
		
		
		
	}
	
}
