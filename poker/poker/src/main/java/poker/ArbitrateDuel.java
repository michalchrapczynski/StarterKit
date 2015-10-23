package poker;

import poker.hand.Hand;

public class ArbitrateDuel {

	HandParser parser = new HandParser();

	public int getCard(String cardsPlayers) {
		String a = cardsPlayers.substring(0, cardsPlayers.length() / 2);
		String b = cardsPlayers.substring((cardsPlayers.length() / 2) + 1);

		return arbitrate(a, b);
	}

	public int arbitrate(String prayerA, String playerB) {
		Hand handPlayerA = parser.parse(prayerA);
		Hand handPlayerB = parser.parse(playerB);

		int result = 0;

		// int winA = 0;
		// int winB = 0;
		// int remis = 0;

		int score = handPlayerA.compare(handPlayerB);

		if (score > 0) {
			// winA++;
			result = 1;
		} else if (score < 0) {
			// winB++;
			result = 2;
		} else {
			// remis++;
		}

		return result;

		/*
		 * System.out.println("Gracz piewszy wygral : " + winA +
		 * " razy z układem: " + handPlayerA.getType()); System.out.println(
		 * "Gracz drugi wygral : " + winB + " razy"); System.out.println(
		 * "Liczba remisow to : " + remis); System.out.println();
		 */
	}

}
