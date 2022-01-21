package main.java.com.petecapra.euchre.model;

import com.petecapra.euchre.model.Colour;

/**
 * Author: petecapra
 * Date: 24/09/11
 */
public enum Suit {

	HEARTS(Colour.RED),
	DIAMONDS(Colour.RED),
	CLUBS(Colour.BLACK),
	SPADES(Colour.BLACK);

	private Colour colour;

	Suit(Colour colour) {
		this.colour = colour;
	}

	public Colour getColour() {
		return colour;
	}
}
