package poker.hand;



import poker.card.CardValue;

public class HighCard extends Hand {

	public CardValue highCard;

	/**
	 * for unit testing
	 */
	public HighCard(CardValue highCard) {
		super(HandType.HIGHCARD);
		this.highCard = highCard;
	}

	@Override
	public int compareSameType(Hand toCompare) {
		HighCard handToCompare = (HighCard) toCompare;
		return highCard.compare(handToCompare.highCard);
	}

}
