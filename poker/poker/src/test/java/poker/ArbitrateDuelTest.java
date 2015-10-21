package poker;

import org.fest.assertions.Assertions;
import org.junit.Test;

public class ArbitrateDuelTest {

	ArbitrateDuel battle = new ArbitrateDuel();

	@Test
	public void highCardIsAce_winPlayerB() {
		// given
		String playerA = "QS KH 2C 3H 4C";
		String playerB = "QS AH 2C 3H 4C";
		int expected = -1;
		// when
		int actual = battle.arbitrate(playerA, playerB);
		// then
		Assertions.assertThat(actual).isEqualTo(expected);

	}

	@Test
	public void onePairEitherPlayers_5vs10_winPlayerA() {
		// given
		String playerA = "QS TH TC 3H 4C";
		String playerB = "QS 5H 5C 3H 4C";
		int expected = 1;
		// when
		int actual = battle.arbitrate(playerA, playerB);
		// then
		Assertions.assertThat(actual).isEqualTo(expected);

	}

	@Test
	public void onePairEitherPlayers_winPlayerB() {
		// given
		String playerA = "QS TH TC 3H 4C";
		String playerB = "KS TH TC 3H 4C";
		int expected = -1;
		// when
		int actual = battle.arbitrate(playerA, playerB);
		// then
		Assertions.assertThat(actual).isEqualTo(expected);

	}

	@Test
	public void twoPairEitherPlayers_winPlayerB() {
		// given
		String playerA = "QS TH 4C QH TC";
		String playerB = "QS TH TC QH AC";
		int expected = -1;
		// when
		int actual = battle.arbitrate(playerA, playerB);
		// then
		Assertions.assertThat(actual).isEqualTo(expected);

	}

	@Test
	public void Poker_winPlayerA() {
		// given
		String playerA = "QS JS TS 9S 8S";
		String playerB = "8C 7C 9C 6C 5C";
		int expected = 1;
		// when
		int actual = battle.arbitrate(playerA, playerB);
		// then
		Assertions.assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void test1_wrong() {
		// given
		String playerA = "6H 8D 2D 9H JD";
		String playerB = "6C 4S 5H 5S 6D";
		int expected = -1;
		// when
		int actual = battle.arbitrate(playerA, playerB);
		// then
		Assertions.assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void test2_wrong() {
		// given
		String playerA = "TH 8H 5C QS TC";
		String playerB = "9H 4D JC KS JS";
		int expected = -1;
		// when
		int actual = battle.arbitrate(playerA, playerB);
		// then
		Assertions.assertThat(actual).isLessThanOrEqualTo(expected);
	}

	@Test
	public void test3_wrong() {
		// given
		String playerA = "3D KH QD 6C 6S";
		String playerB = "AD AS 8H 2H QS";
		int expected = -1;
		// when
		int actual = battle.arbitrate(playerA, playerB);
		// then
		Assertions.assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void test4_wrong() {
		// given
		String playerA = "5H JH TS 7S TD";
		String playerB = "6H AD QD 8H 8S";
		int expected = 1;
		// when
		int actual = battle.arbitrate(playerA, playerB);
		// then
		Assertions.assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void test5_wrong() {
		// given
		String playerA = "QS 9C QD 6H JS";
		String playerB = "5D AC 8D 2S AS";
		int expected = -1;
		// when
		int actual = battle.arbitrate(playerA, playerB);
		// then
		Assertions.assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void test6_wrong() {
		// given
		String playerA = "JH 8C 3D 3C 6C";
		String playerB = "KC TD 7H 7C 4C";
		int expected = -1;
		// when
		int actual = battle.arbitrate(playerA, playerB);
		// then
		Assertions.assertThat(actual).isLessThanOrEqualTo(expected);
	}

	@Test
	public void test7_wrong() {
		// given
		String playerA = "8S 5D 8H 4C 6HC";
		String playerB = "KC 3H 7C 5S KD";
		int expected = -1;
		// when
		int actual = battle.arbitrate(playerA, playerB);
		// then
		Assertions.assertThat(actual).isLessThanOrEqualTo(expected);
	}

}
