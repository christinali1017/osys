package blackjack;

/**
 * suit of a card
 * @author wish
 */
public enum Suit {
	Club(0), Diamond(1), Heart(2), Spade(3);
	
	private int value;
	private Suit(int v) {
		this.value = v;
	}
	
	public int getValue() {
		return value;
	}
	
	public static Suit getSuit(int value) {
		switch (value) {
			case 0:
				return Suit.Club;
			case 1:
				return Suit.Diamond;
			case 2: 
				return Suit.Heart;
			case 3: 
				return Suit.Spade;
			default:
				return null;
		}
	}
	
	
}


