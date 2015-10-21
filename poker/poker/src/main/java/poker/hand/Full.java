package poker.hand;

import poker.card.CardValue;

public class Full extends Hand {

	public CardValue valueOfThreeSome;
	public CardValue valueOfPair;

	public Full(CardValue valueOfThreeSome, CardValue valueOfPair) {
		super(HandType.FULL);
		this.valueOfThreeSome = valueOfThreeSome;
		this.valueOfPair = valueOfPair;
	}

	@Override
	public int compareSameType(Hand toCompare) {
		Full handToCompare = (Full) toCompare;
		return valueOfThreeSome.compare(handToCompare.valueOfThreeSome) + valueOfPair.compare(handToCompare.valueOfPair);
	}

}
