package com.capgemini.gameOfLife;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.capgemini.gameOfLife.GameOfLife;
import com.capgemini.gameOfLife.Point;

@SuppressWarnings("deprecation")
public class GameOfLifeTest {

	GameOfLife scoreGame = new GameOfLife();



	@Test
	public void testRemove_1_Cell() {
		// given

		Set<Point> startSpaceGame = new HashSet<>();
		startSpaceGame.add(new Point(1, 1));

		Set<Point> expected = new HashSet<>();

		// when
		Set<Point> actual = scoreGame.scoreGame(startSpaceGame);
		// then
		assertEquals(expected, actual);
	}

	@Test
	public void testRemove_2_Cells() {
		// given

		Set<Point> startSpaceGame = new HashSet<>();
		startSpaceGame.add(new Point(1, 1));
		startSpaceGame.add(new Point(1, 2));

		Set<Point> expected = new HashSet<>();
		// when
		Set<Point> actual = scoreGame.scoreGame(startSpaceGame);
		// then
		assertEquals(expected, actual);
	}

	@Test
	public void testRemove_5_Cells_Cross() {
		// given

		Set<Point> startSpaceGame = new HashSet<>();
		startSpaceGame.add(new Point(1, 0));
		startSpaceGame.add(new Point(0, 1));
		startSpaceGame.add(new Point(1, 1));
		startSpaceGame.add(new Point(2, 1));
		startSpaceGame.add(new Point(1, 2));

		Set<Point> expected = new HashSet<>();
		expected.add(new Point(1, 1));
		// when
		Set<Point> actual = scoreGame.scoreGame(startSpaceGame);
		// then
		assertFalse(contanisAll(expected, actual));
	}

	@Test
	public void testRemove_9_Cells_9Cube() {
		// given

		Set<Point> startSpaceGame = new HashSet<>();
		startSpaceGame.add(new Point(2, 0));
		startSpaceGame.add(new Point(2, 1));
		startSpaceGame.add(new Point(2, 2));
		startSpaceGame.add(new Point(0, 0));
		startSpaceGame.add(new Point(0, 1));
		startSpaceGame.add(new Point(0, 2));
		startSpaceGame.add(new Point(1, 0));
		startSpaceGame.add(new Point(1, 1));
		startSpaceGame.add(new Point(1, 2));

		Set<Point> expected = new HashSet<>();
		expected.add(new Point(1, 0));
		expected.add(new Point(0, 1));
		expected.add(new Point(1, 1));
		expected.add(new Point(1, 2));
		expected.add(new Point(2, 1));
		// when
		Set<Point> actual = scoreGame.scoreGame(startSpaceGame);
		// then
		assertFalse(contanisAll(expected, actual));
	}

	@Test
	public void testRemove_5_Cells_CubeGame() {
		// given

		Set<Point> startSpaceGame = new HashSet<>();
		startSpaceGame.add(new Point(0, 0));
		startSpaceGame.add(new Point(1, 1));
		startSpaceGame.add(new Point(2, 2));
		startSpaceGame.add(new Point(0, 2));
		startSpaceGame.add(new Point(2, 0));

		Set<Point> expected = new HashSet<>();
		expected.add(new Point(0, 0));
		expected.add(new Point(1, 1));
		expected.add(new Point(2, 2));
		expected.add(new Point(0, 2));
		expected.add(new Point(2, 0));

		// when
		Set<Point> actual = scoreGame.scoreGame(startSpaceGame);
		// then
		assertFalse(contanisAll(expected, actual));
	}

	@Test
	public void testAdd_3_Cells_cornerLeftUpEmpty() {
		// given

		Set<Point> startSpaceGame = new HashSet<>();
		startSpaceGame.add(new Point(0, 1));
		startSpaceGame.add(new Point(1, 1));
		startSpaceGame.add(new Point(1, 0));

		Set<Point> expected = new HashSet<>();
		expected.add(new Point(0, 1));
		expected.add(new Point(1, 1));
		expected.add(new Point(1, 0));
		expected.add(new Point(0, 0));

		// when
		Set<Point> actual = scoreGame.scoreGame(startSpaceGame);
		// then
		assertTrue(isEqual(expected, actual));
	}

	@Test
	public void testAdd_3_Cells_cornerRightDownEmpty() {
		// given

		Set<Point> startSpaceGame = new HashSet<>();
		startSpaceGame.add(new Point(0, 0));
		startSpaceGame.add(new Point(0, 1));
		startSpaceGame.add(new Point(1, 0));

		Set<Point> expected = new HashSet<>();
		expected.add(new Point(0, 1));
		expected.add(new Point(1, 1));
		expected.add(new Point(1, 0));
		expected.add(new Point(0, 0));

		// when
		Set<Point> actual = scoreGame.scoreGame(startSpaceGame);
		// then
		assertTrue(isEqual(expected, actual));
	}

	@Test
	public void testAdd_3_Cells_cornerRightUpEmpty() {
		// given

		Set<Point> startSpaceGame = new HashSet<>();
		startSpaceGame.add(new Point(0, 0));
		startSpaceGame.add(new Point(0, 1));
		startSpaceGame.add(new Point(1, 1));

		Set<Point> expected = new HashSet<>();
		expected.add(new Point(0, 1));
		expected.add(new Point(1, 1));
		expected.add(new Point(1, 0));
		expected.add(new Point(0, 0));

		// when
		Set<Point> actual = scoreGame.scoreGame(startSpaceGame);
		// then
		assertTrue(isEqual(expected, actual));
	}

	@Test
	public void testAdd_3_Cells_cornerLeftDownEmpty() {
		// given

		Set<Point> startSpaceGame = new HashSet<>();
		startSpaceGame.add(new Point(0, 0));
		startSpaceGame.add(new Point(1, 0));
		startSpaceGame.add(new Point(1, 1));

		Set<Point> expected = new HashSet<>();
		expected.add(new Point(0, 1));
		expected.add(new Point(1, 1));
		expected.add(new Point(1, 0));
		expected.add(new Point(0, 0));

		// when
		Set<Point> actual = scoreGame.scoreGame(startSpaceGame);
		// then
		assertTrue(isEqual(expected, actual));

	}

	// MouseHead (Up)
	// █X█
	// .█

	@Test
	public void testAdd_3_Cells_MouseHeadUp() {
		// given

		Set<Point> startSpaceGame = new HashSet<>();
		startSpaceGame.add(new Point(0, 0));
		startSpaceGame.add(new Point(1, 1));
		startSpaceGame.add(new Point(2, 0));

		Set<Point> expected = new HashSet<>();
		expected.add(new Point(1, 1));
		expected.add(new Point(1, 0));

		// when
		Set<Point> actual = scoreGame.scoreGame(startSpaceGame);
		// then
		assertTrue(isEqual(expected, actual));

	}

	@Test
	public void testAdd_3_Cells_MouseHeadDown() {
		// given

		Set<Point> startSpaceGame = new HashSet<>();
		startSpaceGame.add(new Point(0, 1));
		startSpaceGame.add(new Point(1, 0));
		startSpaceGame.add(new Point(2, 1));

		Set<Point> expected = new HashSet<>();
		expected.add(new Point(1, 1));
		expected.add(new Point(1, 0));


		// when
		Set<Point> actual = scoreGame.scoreGame(startSpaceGame);
		// then
		assertTrue(isEqual(expected, actual));

	}

	@Test
	public void testAdd_3_Cells_MouseHeadRight() {
		// given

		Set<Point> startSpaceGame = new HashSet<>();
		startSpaceGame.add(new Point(2, 0));
		startSpaceGame.add(new Point(1, 1));
		startSpaceGame.add(new Point(2, 2));

		Set<Point> expected = new HashSet<>();
		expected.add(new Point(1, 1));
		expected.add(new Point(2, 1));

		// when
		Set<Point> actual = scoreGame.scoreGame(startSpaceGame);
		// then
		assertTrue(isEqual(expected, actual));

	}

	@Test
	public void testAdd_3_Cells_MouseHeadLeft() {
		// given

		Set<Point> startSpaceGame = new HashSet<>();
		startSpaceGame.add(new Point(0, 0));
		startSpaceGame.add(new Point(1, 1));
		startSpaceGame.add(new Point(0, 2));

		Set<Point> expected = new HashSet<>();
		expected.add(new Point(1, 1));
		expected.add(new Point(0, 1));

		// when
		Set<Point> actual = scoreGame.scoreGame(startSpaceGame);
		// then
		assertTrue(isEqual(expected, actual));
	}

	@Test
	public void testAdd_3_Cells_HorizontalLine() {
		// given

		Set<Point> startSpaceGame = new HashSet<>();
		startSpaceGame.add(new Point(0, 1));
		startSpaceGame.add(new Point(1, 1));
		startSpaceGame.add(new Point(2, 1));

		Set<Point> expected = new HashSet<>();
		expected.add(new Point(1, 1));
		expected.add(new Point(1, 2));
		expected.add(new Point(1, 0));

		// when
		Set<Point> actual = scoreGame.scoreGame(startSpaceGame);
		// then
		assertTrue(isEqual(expected, actual));
	}

	@Test
	public void testAdd_3_Cells_VerticalLine() {
		// given

		Set<Point> startSpaceGame = new HashSet<>();
		startSpaceGame.add(new Point(1, 0));
		startSpaceGame.add(new Point(1, 1));
		startSpaceGame.add(new Point(1, 2));

		Set<Point> expected = new HashSet<>();
		expected.add(new Point(1, 1));
		expected.add(new Point(0, 1));
		expected.add(new Point(2, 1));

		// when
		Set<Point> actual = scoreGame.scoreGame(startSpaceGame);
		// then
		assertTrue(isEqual(expected, actual));
	}

	@Test
	public void testIntegration_ReverseChar_L() {
		// given

		Set<Point> startSpaceGame = new HashSet<>();
		startSpaceGame.add(new Point(1, 2));
		startSpaceGame.add(new Point(2, 2));
		startSpaceGame.add(new Point(2, 4));
		startSpaceGame.add(new Point(2, 3));

		Set<Point> expected = new HashSet<>();
		expected.add(new Point(1, 2));
		expected.add(new Point(2, 2));
		expected.add(new Point(1, 3));
		expected.add(new Point(2, 3));
		expected.add(new Point(3, 3));


		// when
		Set<Point> actual = scoreGame.scoreGame(startSpaceGame);
		// then
		assertTrue(isEqual(expected, actual));
	}

	private boolean isEqual(Set<Point> expected, Set<Point> actual) {
		if (expected.size() == actual.size()) {
			return contanisAll(expected, actual);
		}
		return false;
	}

	/**
	 * Sprawdzenie czy wszystkie points zawierają się w container
	 */
	private boolean contanisAll(Set<Point> points, Set<Point> container) {
		boolean isEqual = true;

		for (Point point : points) {
			isEqual = cointains(point, container);
			if (!isEqual) {
				break;
			}
		}

		return isEqual;
	}

	/**
	 * Sprawdzenie czy point zawiera się w container
	 */
	private boolean cointains(Point point, Set<Point> container) {
		boolean contains = false;
		for (Point point2 : container) {
			contains = point.equals(point2);
			if (contains) {
				break;
			}
		}

		return contains;
	}

}
