package blackjack;

import java.util.List;

/**
 * Test of blackjack game
 * @author wish
 */
public class Test {
	public static void main(String[] args) {
		int numOfPlayers = 5;
		GameAutomator game = new GameAutomator(numOfPlayers);
		
		if (game.initialize()) {
			game.printCurrentScores();
			System.out.println("---------------------------------");
			List<Integer> bjs = game.getBlackJacks();
			
			/* if blackjack exists, game over*/
			if (bjs.size() > 0) {
				System.out.println("Game over!");
				System.out.print("BlackJack: ");
				for (int i : bjs) {
					System.out.print("Player " + i + ", ");
				}
			} else {
				boolean res = game.playAll();
				if (res) {
					System.out.println("Game over!");
					
					game.printCurrentScores();
					System.out.println("---------------------------------");
					List<Integer> winners = game.getWinners();
					
					if (winners.size() > 0) {
						System.out.print("Winners: ");
						for (int i : winners) {
							System.out.print("Player " + i + ", ");
						}
					} else {
						System.out.println("Draw! All players are busted");
					}
				} else {
					System.out.println("Out of cards, current scores are: ");
					game.printCurrentScores();
				}
			}
 			
		}
	}

}
