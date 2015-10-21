package poker.hand;

public enum HandType {

	HIGHCARD(1), PAIR(2), TWOPAIR(3), THREEOFAKIND(4), STRAIGHT(5), FLUSH(6), FULL(7), FOUROFAKIND(8), STRAIGHTFLUSH(9), ROYALFLUSH(10);

	private int value;

	private HandType(int value) {
		this.value = value;
	}

	public int compare(HandType toCompare) {
		return Integer.compare(value, toCompare.value);
	}

}
