package poker.hand;

import poker.card.CardValue;

public class FourOfAKind extends Hand {

	public CardValue valueOfFourOfAKind;

	public FourOfAKind(CardValue valueOfFourOfAKind) {
		super(HandType.FOUROFAKIND);
		this.valueOfFourOfAKind = valueOfFourOfAKind;

	}

	@Override
	public int compareSameType(Hand toCompare) {
		FourOfAKind handToCompare = (FourOfAKind) toCompare;
		return valueOfFourOfAKind.compare(handToCompare.valueOfFourOfAKind);
	}

}
