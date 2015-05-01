package blackjack;

import java.util.ArrayList;
import java.util.List;

public class GameAutomator {
	private Deck<BlackJackCard> deck;
	private BlackJackPlayer[] players;
	
	//The dealer has to take hits until his or her cards total 17 or more points. (In some casinos the dealer also hits on a "soft" 17, e.g. an initial ace and six.) 
	private static final int SOFT_HIT = 17;
	
	public GameAutomator(int num) {
		players = new BlackJackPlayer[num];
		for (int i = 0; i < num; i++) {
			players[i] = new BlackJackPlayer();
		}
		
		deck = new Deck<BlackJackCard>();
//		initialize();
	}
	
	/**
	 * Initialize deck and deal 2 cards to each player
	 * @return initialize result
	 */
	public boolean initialize() {
		System.out.println("-----------Initialize------------");
		/*initialize deck*/
		List<BlackJackCard> cards = new ArrayList<BlackJackCard>();
		for (int i = 1; i <= 13; i++) {
			for (int j = 0; j <= 3; j++) {
				Suit suit = Suit.getSuit(j);
				cards.add(new BlackJackCard(i, suit));
			}
		}
		
		deck.setCards(cards);
		deck.shuffle();
		
		
		/*deal 2 cards to each player*/
		for (BlackJackPlayer player : players) {
			BlackJackCard c1 = deck.dealCard();
			BlackJackCard c2 = deck.dealCard();
			
			if (c1 == null || c2 == null) {
				System.out.println("Initialize Error, too many players, out of cards");
				return false;
			}
			
			player.addCard(c1);
			player.addCard(c2);
		}
		return true;
	}
	
	/**
	 * @return list of blackjacks
	 */
	public List<Integer> getBlackJacks() {
		List<Integer> bjs = new ArrayList<Integer>();
		for (int i = 0; i < players.length; i++) {
			if (players[i].isBlackJack()) {
				bjs.add(i);
			}
		}
		return bjs;
	}
	
	/**
	 * @return list of winners
	 */
	public List<Integer> getWinners(){
		List<Integer> winners = new ArrayList<Integer>();
		int winScore = 0;
		for (int i = 0; i < players.length; i++) {
			BlackJackPlayer player = players[i];
			if (!player.busted()) {
				if (player.score() > winScore) {
					winScore = player.score();
					winners.clear();
					winners.add(i);
				} else if (player.score() == winScore) {
					winners.add(i);
				}
			}
		}
		return winners;
	}
	
	/**
	 * Player Play
	 * @param player
	 * @return play result, if cards is empty return false;
	 * 
	 * We don't use i in this function, because players[i] = player, add just for case that we need the index i
	 */
	public boolean play(BlackJackPlayer player /*, int i*/) {
		while(player.score() <= SOFT_HIT) {
			BlackJackCard c = deck.dealCard();
			if (c == null) {
				return false;
			}
			player.addCard(c);
		}
		return true;
	}
		
	/**
	 * All play
	 * @return play result
	 */
	public boolean playAll() {
		for (int i = 0; i < players.length; i++) {
			if (!play(players[i] /*, i*/)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Print players' scores
	 */
	public void printCurrentScores() {
		for (int i = 0; i < players.length; i++) {
			System.out.print("Player " + i + " " + players[i].score() + " " );
			players[i].print();
			System.out.println();
		}
	}
	
	
}
