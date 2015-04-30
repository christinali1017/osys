package blackjack;

import java.util.ArrayList;
import java.util.List;

/**
 * BlackJack hand
 * Ace A could be 1 or 11
 * @author wish
 */
public class BlackJackHand extends Hand<BlackJackCard> {
	public BlackJackHand() {}
	
	/**
	 * Return the score of blackjack
	 * A could be 1 or 11, thus there are multiple possible scores for a blackjack hand,
	 * We return to return the highest that is under 21
	 * @return score
	 */
	public int score() {
		List<Integer> scores = possibleScores();
		int low = Integer.MIN_VALUE;
		int high = Integer.MAX_VALUE;
		for(int score : scores) {
			if(score > 21 && score < high) {
				high = score;
			} else if(score <= 21 && score > low) {
				low = score;
			}
		}
		return low <= 21 ? low: high;	
	}
	
	/**
	 * @return possible scores due to different values of a same card, like Ace
	 */
	private List<Integer> possibleScores() {
		List<Integer> scores = new ArrayList<Integer>();
		if (cards.size() == 0) {
			return scores;
		}
		for (BlackJackCard card : cards) {
			addScore(card, scores);
		}
		return scores;
	}
	
	/**
	 * Add card's value to score lists.
	 * @param card
	 * @param scores
	 */
	private void addScore(BlackJackCard card, List<Integer> scores) {
		if (scores.size() == 0) {
			scores.add(0);
		}
		for(int i = 0, len = scores.size(); i < len; i++) {
			int score = scores.get(i);
			scores.set(i, score + card.minValue());
			if (card.minValue() != card.maxValue()) {
				scores.add(score, card.maxValue());
			}
		}
	}
	
	
	/**
	 * @return if score reaches 21
	 */
	public boolean is21() {
		return score() == 21;
	}
	
	/**
	 * Check if it is over 21
	 * @return
	 */
	public boolean busted() {
		return score() > 21;
	}
	
	public boolean isBlackJack() {
		if(cards.size() != 2) {
			return false;
		}
		
		BlackJackCard cardA = cards.get(0);
		BlackJackCard cardB = cards.get(1);
		
		return ((cardA.isAce() && cardB.isFaceCard()) || (cardA.isFaceCard() && cardB.isAce()));
	}
}
