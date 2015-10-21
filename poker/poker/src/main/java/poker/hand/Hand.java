package poker.hand;

public abstract class Hand {

	private HandType type;

	public Hand(HandType type) {
		this.type = type;
	}

	public HandType getType() {
		return type;
	}

	public int compare(Hand toCompare) {
		int typeCompare = type.compare(toCompare.getType());
		return typeCompare == 0 ? compareSameType(toCompare) : typeCompare;
	}

	public abstract int compareSameType(Hand toCompare);
}
