package poker.hand;

import poker.card.CardValue;

public class TwoPair extends Hand {

	public CardValue valueOfFirstPair;
	public CardValue valueOfSecondPair;
	public CardValue highCardBetweenSecondPair;

	public TwoPair(CardValue valueOfPair, CardValue valueOfSecondPair, CardValue highCardBetweenSecondPair) {
		super(HandType.TWOPAIR);
		this.valueOfFirstPair = valueOfPair;
		this.valueOfSecondPair = valueOfSecondPair;
		this.highCardBetweenSecondPair = highCardBetweenSecondPair;

	}

	@Override
	public int compareSameType(Hand toCompare) {
		TwoPair handToCompare = (TwoPair) toCompare;

		if (valueOfFirstPair.compare(handToCompare.valueOfFirstPair) == 0) {
			if (valueOfSecondPair.compare(handToCompare.valueOfSecondPair) == 0) {
				return highCardBetweenSecondPair.compare(handToCompare.highCardBetweenSecondPair);
			}
			return valueOfSecondPair.compare(handToCompare.valueOfSecondPair);
		}
		return valueOfFirstPair.compare(handToCompare.valueOfFirstPair);

	}
}
