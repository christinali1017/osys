package blackjack;

import java.util.ArrayList;
import java.util.List;

/**
 * BlackJack player
 * @author wish
 */
public class BlackJackPlayer extends Player<BlackJackCard> {
	public BlackJackPlayer() {}
	
	/**
	 * Return the score of blackjack
	 * A could be 1 or 11, thus there are multiple possible scores for a blackjack hand,
	 * We return to return the highest that is under 21
	 * @return score
	 * 
	 * Be careful, we need to calculate the scores every time other than just add the last card, 
	 * because every time ace can act as 1 or 11.
	 */
	public int score() {
		List<Integer> scores = possibleScores();
		int low = Integer.MIN_VALUE;   // low is <= 21
		int high = Integer.MAX_VALUE;  // high is always greater than 21
		for(int score : scores) {
			if(score > 21 && score < high) {
				high = score;
			} else if(score <= 21 && score > low) {
				low = score;
			}
		}
		
		//is low is not Min_VALUE, then we should return low, because high is over 21, already busted
		return low ==  Integer.MIN_VALUE ? high: low;	
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
				scores.add(score + card.maxValue());
			}
		}
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
		
		BlackJackCard c1 = cards.get(0);
		BlackJackCard c2 = cards.get(1);
		
		return ((c1.isAce() && c2.isFaceCard()) || (c1.isFaceCard() && c2.isAce()));
	}
}
