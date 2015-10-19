package com.capgemini.bowling;

import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class BowlingGameTest {

	BowlingGameResultCalculator score = new BowlingGame();

	@Test
	public void test01() {
		// given
		int[] actualThrows = { 1, 2, };
		// when
		for (int actualThrow : actualThrows) {
			score.roll(actualThrow);
		}
		int result = score.score();
		// then
		Assert.assertEquals(3, result);
	}

	@Test
	public void test02() {
		// given
		int[] actualThrows = { 5, 5, 3 };
		// when
		for (int actualThrow : actualThrows) {
			score.roll(actualThrow);
		}
		int result = score.score();
		// then
		Assert.assertEquals(16, result);
	}

	@Test
	public void test03() {
		// given
		int[] actualThrows = { 10, 0, 3, 2 };
		// when
		for (int actualThrow : actualThrows) {
			score.roll(actualThrow);
		}
		int result = score.score();
		// then
		Assert.assertEquals(20, result);
	}

	@Test
	public void test() {
		// given
		int[] actualThrows = { 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2,
				1, 2, 1, 2 };
		// when
		for (int actualThrow : actualThrows) {
			score.roll(actualThrow);
		}
		int result = score.score();
		// then
		Assert.assertEquals(30, result);
	}

	@Test
	public void test1() {
		// given
		int[] actualThrows = { 5, 5, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2,
				1, 2, 1, 2 };
		// when
		for (int actualThrow : actualThrows) {
			score.roll(actualThrow);
		}
		int result = score.score();
		// then
		Assert.assertEquals(38, result);
	}

	@Test
	public void test2() {
		// given
		int[] actualThrows = { 1, 2, 1, 2, 1, 2, 8, 2, 1, 2, 1, 2, 1, 2, 1, 2,
				1, 2, 1, 2 };
		// when
		for (int actualThrow : actualThrows) {
			score.roll(actualThrow);
		}
		int result = score.score();
		// then
		Assert.assertEquals(38, result);
	}

	@Test
	public void test3() {
		// given
		int[] actualThrows = { 10, 0, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2,
				1, 2, 1, 2 };
		// when
		for (int actualThrow : actualThrows) {
			score.roll(actualThrow);
		}
		int result = score.score();
		// then
		Assert.assertEquals(40, result);
	}

	@Test
	public void test4() {
		// given
		int[] actualThrows = { 7, 2, 10, 0, 8, 2, 5, 3, 10, 0, 3, 1, 9, 0, 7,
				3, 5, 5, 8, 1 };
		// when
		for (int actualThrow : actualThrows) {
			score.roll(actualThrow);
		}
		int result = score.score();
		// then
		Assert.assertEquals(121, result);
	}

	@Test
	public void test5() {
		// given
		int[] actualThrows = { 7, 2, 10, 0, 8, 2, 5, 3, 10, 0, 3, 1, 9, 0, 7,
				3, 5, 5, 8, 2, 8 };
		// when
		for (int actualThrow : actualThrows) {
			score.roll(actualThrow);
		}
		int result = score.score();
		// then
		Assert.assertEquals(138, result);
	}

	@Test
	public void test6() {
		// given
		int[] actualThrows = { 8, 1, 2, 3, 4, 6, 8, 1, 10, 0, 6, 1, 9, 1, 10,
				0, 10, 0, 5, 5, 9 };
		// when
		for (int actualThrow : actualThrows) {
			score.roll(actualThrow);
		}
		int result = score.score();
		// then
		Assert.assertEquals(153, result);
	}

	@Test
	public void test7() {
		// given
		int[] actualThrows = { 8, 1, 2, 3, 4, 6, 8, 1, 10, 0, 6, 1, 9, 1, 10, 0, 10, 0, 10, 0, 9 };
		// when
		for (int actualThrow : actualThrows) {
			score.roll(actualThrow);
		}
		int result = score.score();
		// then
		Assert.assertEquals(153, result);
	}


}
