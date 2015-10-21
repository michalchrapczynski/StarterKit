package poker;

import org.fest.assertions.Assertions;
import org.junit.Test;

import poker.card.CardValue;
import poker.hand.Flush;
import poker.hand.FourOfAKind;
import poker.hand.Full;
import poker.hand.Hand;
import poker.hand.HighCard;
import poker.hand.Pair;
import poker.hand.Straight;
import poker.hand.StraightFlush;
import poker.hand.ThreeOfAKind;
import poker.hand.TwoPair;

public class PokerTest {
	private HandParser testClass = new HandParser();

	@Test
	public void highCardIsKing() {
		// given
		String info = "QS KH 2C 3H 4C";
		HighCard expected = new HighCard(CardValue.KING);

		// when
		Hand actual = testClass.parse(info);

		// then
		Assertions.assertThat(actual).isInstanceOf(HighCard.class);
		Assertions.assertThat(actual.compare(expected)).isEqualTo(0);
	}

	@Test
	public void pairAreAce() {
		// given
		String info = "AS AH 2C 3H 4C";
		Pair expected = new Pair(CardValue.ACE, CardValue.FOUR);

		// when
		Hand actual = testClass.parse(info);

		// then
		Assertions.assertThat(actual).isInstanceOf(Pair.class);
		Assertions.assertThat(actual.compare(expected)).isEqualTo(0);
	}

	@Test
	public void pairAreAc2e() {
		// given
		String info = "3S 2C 2H 3C 4H";
		TwoPair expected = new TwoPair(CardValue.THREE, CardValue.TWO, CardValue.FOUR);

		// when
		Hand actual = testClass.parse(info);

		// then
		Assertions.assertThat(actual).isInstanceOf(TwoPair.class);
		Assertions.assertThat(actual.compare(expected)).isEqualTo(0);
	}

	@Test
	public void threeSomeAreAce() {
		// given
		String info = "AS AH AC 4H 2C";
		ThreeOfAKind expected = new ThreeOfAKind(CardValue.ACE);

		// when
		Hand actual = testClass.parse(info);

		// then
		Assertions.assertThat(actual).isInstanceOf(ThreeOfAKind.class);
		Assertions.assertThat(actual.compare(expected)).isEqualTo(0);
	}

	@Test
	public void straight() {
		// given
		String info = "7H 9C 5S 8H 6C";
		Straight expected = new Straight(CardValue.NINE);

		// when
		Hand actual = testClass.parse(info);

		// then
		Assertions.assertThat(actual).isInstanceOf(Straight.class);
		Assertions.assertThat(actual.compare(expected)).isEqualTo(0);
	}

	@Test
	public void flush() {
		// given
		String info = "3S 7S 9S 8S TS";
		Flush expected = new Flush(CardValue.TEN);

		// when
		Hand actual = testClass.parse(info);

		// then
		Assertions.assertThat(actual).isInstanceOf(Flush.class);
		Assertions.assertThat(actual.compare(expected)).isEqualTo(0);
	}

	@Test
	public void full() {
		// given
		String info = "3S 3H 9S 9H 9C";
		Full expected = new Full(CardValue.NINE, CardValue.THREE);

		// when
		Hand actual = testClass.parse(info);

		// then
		Assertions.assertThat(actual).isInstanceOf(Full.class);
		Assertions.assertThat(actual.compare(expected)).isEqualTo(0);
	}

	@Test
	public void fourSame() {
		// given
		String info = "3S 9D 9S 9H 9C";
		FourOfAKind expected = new FourOfAKind(CardValue.NINE);

		// when
		Hand actual = testClass.parse(info);

		// then
		Assertions.assertThat(actual).isInstanceOf(FourOfAKind.class);
		Assertions.assertThat(actual.compare(expected)).isEqualTo(0);
	}

	@Test
	public void StraightFlush() {
		// given
		String info = "4S 5S 6S 7S 8S";
		StraightFlush expected = new StraightFlush(CardValue.EIGHT);

		// when
		Hand actual = testClass.parse(info);

		// then
		Assertions.assertThat(actual).isInstanceOf(StraightFlush.class);
		Assertions.assertThat(actual.compare(expected)).isEqualTo(0);
	}

	@Test
	public void StraightFirstAce() {
		// given
		String info = "AS 2C 3S 4H 5S";
		Straight expected = new Straight(CardValue.FIVE);

		// when
		Hand actual = testClass.parse(info);

		// then
		Assertions.assertThat(actual).isInstanceOf(Straight.class);
		Assertions.assertThat(actual.compare(expected)).isEqualTo(0);
	}

	@Test
	public void StraightFlushFirstAce() {
		// given
		String info = "AS 2S 3S 4S 5S";
		StraightFlush expected = new StraightFlush(CardValue.FIVE);

		// when
		Hand actual = testClass.parse(info);

		// then
		Assertions.assertThat(actual).isInstanceOf(StraightFlush.class);
		Assertions.assertThat(actual.compare(expected)).isEqualTo(0);
	}

}
