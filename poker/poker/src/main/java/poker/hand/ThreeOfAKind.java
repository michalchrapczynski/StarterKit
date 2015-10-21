package poker.hand;

import poker.card.CardValue;

public class ThreeOfAKind extends Hand {

	public CardValue valueOfThreeOfAKind;

	public ThreeOfAKind(CardValue valueOfThreeOfAKind) {
		super(HandType.THREEOFAKIND);
		this.valueOfThreeOfAKind = valueOfThreeOfAKind;
	}

	@Override
	public int compareSameType(Hand toCompare) {
		ThreeOfAKind handToCompare = (ThreeOfAKind) toCompare;
		return valueOfThreeOfAKind.compare(handToCompare.valueOfThreeOfAKind);
	}

}
