package poker.hand;

import poker.card.CardValue;

public class StraightFlush extends Hand {

	public CardValue highCardstrightFlush;

	public StraightFlush(CardValue highCardstrightFlush) {
		super(HandType.STRAIGHTFLUSH);
		this.highCardstrightFlush = highCardstrightFlush;
	}

	@Override
	public int compareSameType(Hand toCompare) {
		StraightFlush handToCompare = (StraightFlush) toCompare;
		return highCardstrightFlush.compare(handToCompare.highCardstrightFlush);
	}

}
