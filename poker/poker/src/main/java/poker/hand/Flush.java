package poker.hand;

import poker.card.CardValue;

public class Flush extends Hand {

	public CardValue highCardFlush;

	public Flush(CardValue highCardFlush) {
		super(HandType.FLUSH);
		this.highCardFlush = highCardFlush;
	}

	@Override
	public int compareSameType(Hand toCompare) {
		Flush handToCompare = (Flush) toCompare;
		return highCardFlush.compare(handToCompare.highCardFlush);
	}

}
