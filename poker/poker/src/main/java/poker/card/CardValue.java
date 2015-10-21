package poker.card;

public enum CardValue {

	UNDEFINED(-1, "UNDEFINED"), TWO(2, "2"), THREE(3, "3"), FOUR(4, "4"), FIVE(5, "5"), SIX(6, "6"), SEVEN(7, "7"), EIGHT(8, "8"), NINE(9, "9"), TEN(10,
			"T"), JACK(11, "J"), QUEEN(12,
			"Q"), KING(13, "K"), ACE(14, "A");


	private int value;
	private String valueName;

	private CardValue(int value, String valueName) {
		this.value = value;
		this.valueName = valueName;
	}

	public static CardValue getValue(String value) {
		CardValue[] values = CardValue.values();
		for (int i = 0; i < values.length; i++) {
			if (values[i].valueName.equals(value)) {
				return values[i];
			}
		}
		return UNDEFINED;
	}

	public int getValue() {
		return value;
	}

	public int compare(CardValue toCompare) {
		return Integer.compare(value, toCompare.value);
	}

}
