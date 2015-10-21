package poker.card;

public class Card {
	public CardValue value;
	public String color;

	public Card(String value, String color) {
		this.value = CardValue.getValue(value);
		this.color = color;
	}

}
