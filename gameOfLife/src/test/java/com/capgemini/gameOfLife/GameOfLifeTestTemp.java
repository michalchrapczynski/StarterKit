package com.capgemini.gameOfLife;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.capgemini.gameOfLife.GameOfLife;
import com.capgemini.gameOfLife.Point;

@SuppressWarnings("deprecation")
public class GameOfLifeTestTemp {

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
		expected.add(new Point(0, 1));
		expected.add(new Point(1, 0));
		expected.add(new Point(2, 1));
		expected.add(new Point(1, 2));
		// when
		Set<Point> actual = scoreGame.scoreGame(startSpaceGame);
		// then
		assertTrue(isEqual(expected, actual));
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
		expected.add(new Point(0, 0));
		expected.add(new Point(0, 2));
		expected.add(new Point(2, 0));
		expected.add(new Point(2, 2));
		// when
		Set<Point> actual = scoreGame.scoreGame(startSpaceGame);
		// then
		assertTrue(isEqual(expected, actual));
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

		// when
		Set<Point> actual = scoreGame.scoreGame(startSpaceGame);
		// then
		assertTrue(isEqual(expected, actual));
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
