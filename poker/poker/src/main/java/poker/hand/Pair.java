package poker.hand;

import poker.card.CardValue;

public class Pair extends Hand {

	public CardValue valueOfPair;
	public CardValue highCardNextToPair;

	public Pair(CardValue valueOfPair, CardValue highCardNextToPair) {
		super(HandType.PAIR);
		this.valueOfPair = valueOfPair;
		this.highCardNextToPair = highCardNextToPair;
	}

	@Override
	public int compareSameType(Hand toCompare) {
		Pair handToCompare = (Pair) toCompare;
		return valueOfPair.compare(handToCompare.valueOfPair) + highCardNextToPair.compare(handToCompare.highCardNextToPair);
	}

}
