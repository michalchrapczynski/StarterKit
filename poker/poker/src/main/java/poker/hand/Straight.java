package poker.hand;

import poker.card.CardValue;

public class Straight extends Hand {

	public CardValue highCardStraight;

	public Straight(CardValue highCardStraight) {
		super(HandType.STRAIGHT);
		this.highCardStraight = highCardStraight;
	}

	@Override
	public int compareSameType(Hand toCompare) {
		Straight handToCompare = (Straight) toCompare;
		return highCardStraight.compare(handToCompare.highCardStraight);
	}

}
