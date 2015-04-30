package blackjack;

/**
 * Abstract class of card. Number 2 - 10, 11 for Jack, 12 for queen, 13 for king, 1 for Ace
 * @author wish
 */
public abstract class Card {
	/* Check if the card is available to be given out to someone */
	private boolean available = true;
	
	protected int value;
	protected Suit suit;
	
	public Card(int v, Suit s) {
		value = v;
		suit = s;
	}
	
	public abstract int value();
	
	public Suit suit() {
		return suit;
	}
	
	public boolean isAvailable() {
		return available;
	}
	
	public void markUnavailable() {
		available = false;
	}
	
	public void markAvailable() {
		available = true;
	}
	
	public void print() {
		String[] values = {"A", "1", "2","3", "4", "5", "6", "7", "8", "9", "J", "Q", "K" }; 
		System.out.print(values[value-1]);
		switch (suit) {
			case Club:
				System.out.print("club");
			case Heart:
				System.out.print("heart");
			case Spade:
				System.out.print("Spade");
			case Diamond:
				System.out.print("Diamond");
				
		}
		System.out.print(" ");
	}
}
