package blackjack;

import java.util.List;

import lib.Randoms;

/**
 * A Deck with generics but restricted the type of T to card.
 * @author wish
 *
 */
public class Deck<T extends Card> {
	private List<T> cards; //All cards, include dealt or not
	private int dealtIndex = 0; // At the beginning, all the cards are not dealt.
	
	public void setCards(List<T> cards) {
		this.cards = cards;
	}
	
	/**
	 * shuffle the cards use math.random methods.
	 */
	public void shuffle() {
		for (int i = 0; i < cards.size(); i++){
			//exchange card i with the random card from i to cards.size() - 1
			int j = Randoms.randomIntInRange(i, cards.size() - 1);
			T c1 = cards.get(i);
			T c2 = cards.get(j);
			cards.set(i, c2);
			cards.set(j, c1);
		}
	}
	
	public int remainingCards() {
		return cards.size() - dealtIndex;
	}
	
	/**
	 * @param number: number of players
	 * @return array of cards of size number 
	 */
	public T[] dealCards(int number) {
		if (remainingCards() < number) {
			return null;
		}
		
		@SuppressWarnings("unchecked")
		T[] resCards = (T[]) new Card[number];
		int count = 0;
		while (count < number) {
			T card = dealCard();
			if (card != null) {
				resCards[count] = card;
				count++;
			}
		}
		
		return resCards;
	}
	
	public T dealCard() {
		if (remainingCards() == 0) {
			return null;
		}
		
		T card = cards.get(dealtIndex);
		card.markUnavailable();
		dealtIndex++;
		
		return card;
	}
	
	public void print() {
		for (Card card : cards) {
			card.print();
		}
	} 
}
