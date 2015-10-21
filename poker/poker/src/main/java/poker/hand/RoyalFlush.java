package poker.hand;

import poker.card.CardValue;

public class RoyalFlush extends Hand {

	public CardValue highCardRoyalFlush;

	public RoyalFlush(CardValue highCardRoyalFlush) {
		super(HandType.HIGHCARD);
		this.highCardRoyalFlush = highCardRoyalFlush;
	}

	@Override
	public int compareSameType(Hand toCompare) {
		RoyalFlush handToCompare = (RoyalFlush) toCompare;
		return highCardRoyalFlush.compare(handToCompare.highCardRoyalFlush);
	}

}
