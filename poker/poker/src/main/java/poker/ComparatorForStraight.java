package poker;

import poker.card.Card;

public class ComparatorForStraight implements java.util.Comparator<Card> {

	public int compare(Card o1, Card o2) {
		if (o1.value.getValue() < o2.value.getValue())
			return -1;
		else if (o1.value.getValue() > o2.value.getValue()) {
			return 1;
		}
		return 0;

	}

}
