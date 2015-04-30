package blackjack;

/**
 * Rules: http://en.wikipedia.org/wiki/Blackjack
 * The player or players are dealt an initial two-card hand and add together the value of their cards. 
 * Face cards (kings, queens, and jacks) are counted as ten points. A player and the dealer can count 
 * their own ace as 1 point or 11 points. 
 * 
 *  It is played with one or more decks of 52 cards. The object of the game is to beat the dealer, which
 *  can be done in a number of ways:
 *  Get 21 points on the player's first two cards (called a blackjack), without a dealer blackjack;
 *  Reach a final score higher than the dealer without exceeding 21; 
 *  Let the dealer draw additional cards until his or her hand exceeds 21.
 * 
 * BlackJack card
 * @author wish
 */
public class BlackJackCard extends Card{
	public BlackJackCard(int v, Suit s) {
		super(v, s);
	}
	
	/**
	 * @return value of blackjack card.
	 * if is ace, return 1,
	 * if is face card, return 10
	 * else return value
	 */
	public int value() {
		if(isAce()) {
			return 1;
		} else if (isFaceCard()){
			return 10;
		} else {
			return value;
		}
	}
	
	/**
	 * @return if a card is Ace
	 */
	public boolean isAce() {
		return value == 1;
	}
	
	/**
	 * @return  if is face card, such as "J", "Q", "K"
	 */
	public boolean isFaceCard() {
		return value >= 11 && value <= 13;
	}
	
	
	/**
	 * @return if is Ace, return 11, otherwise , return the original value
	 */
	public int maxValue() {
		if (isAce()) {
			return 11;
		} else {
			return value();
		} 
	}
	
	/**
	 * @return if is Ace, return 1, otherwise, return the original value
	 */
	public int minValue() {
		if (isAce()) {
			return 1;
		} else {
			return value();
		}
	}
	
	
}
