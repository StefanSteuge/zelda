package com.example.zelda.link;


import com.example.zelda.engine.Game;
import com.example.zelda.karacter.KaracterState;

/**
 * Superclass for link's state.
 * 
 * @author maartenhus
 */
public class LinkState extends KaracterState {
	protected Link link;
	protected Game game;

	public LinkState(Link link) {
		super(link);
		this.link = link;
		this.game = link.getGame();
	}
}
