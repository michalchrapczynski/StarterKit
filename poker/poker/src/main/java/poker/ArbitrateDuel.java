package poker;

import poker.hand.Hand;

public class ArbitrateDuel {

	HandParser parser = new HandParser();

	public void getCard(String cardsPlayers) {
		String a = cardsPlayers.substring(0, cardsPlayers.length() / 2);
		String b = cardsPlayers.substring((cardsPlayers.length() / 2) + 1);

		arbitrate(a, b);
	}

	public int arbitrate(String prayerA, String playerB) {
		Hand handPlayerA = parser.parse(prayerA);
		Hand handPlayerB = parser.parse(playerB);

		int winA = 0;
		int winB = 0;
		int remis = 0;

		int score = handPlayerA.compare(handPlayerB);

		switch (score) {
		case 1:
			winA++;
			break;
		case 0:
			remis++;
			break;
		case -1:
			winB++;
			break;
		default:
			break;
		}

		System.out.println("Gracz piewszy wygral : " + winA + " razy");
		System.out.println("Gracz drugi wygral : " + winB + " razy");
		System.out.println("Liczba remisow to : " + remis);
		System.out.println();
		return score;
	}

}
