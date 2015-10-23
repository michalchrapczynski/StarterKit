package com.capgemini.gameOfLife;

import java.util.HashSet;
import java.util.Set;

import com.capgemini.gameOfLife.Point;

public class GameOfLife {

	public Set<Point> scoreGame(Set<Point> startSpaceGame) {

		Set<Point> endSpaceGame = new HashSet<>();
		endSpaceGame.addAll(startSpaceGame);

		Set<Point> testAddSpaceGame = new HashSet<>();
		testAddSpaceGame.addAll(startSpaceGame);

		removePoint(startSpaceGame, endSpaceGame);

		addPoint(startSpaceGame, endSpaceGame, testAddSpaceGame);

		return endSpaceGame;

	}

	private void addPoint(Set<Point> startSpaceGame, Set<Point> endSpaceGame, Set<Point> testAddSpaceGame) {
		Set<Point> containerChekedPoint = new HashSet<>();
		for (Point point : startSpaceGame) {
			int x = point.getX();
			int y = point.getY();

			for (int i = x - 1; i < x + 2; i++) {

				for (int j = y - 1; j < y + 2; j++) {
					Point tempPoint = new Point(i, j);
					boolean checkCointainChekedPoint = true;

					for (Point chekedPoint : containerChekedPoint) {
						if (tempPoint.equals(chekedPoint)) {
							checkCointainChekedPoint = false;
						}
					}

					if (checkAddElement(startSpaceGame, endSpaceGame, tempPoint) && checkCointainChekedPoint) {
						int numbersNeighbors = 0;
						testAddSpaceGame.add(tempPoint);

						for (Point neighbour : testAddSpaceGame) {
							if (!tempPoint.equals(neighbour)) {
								numbersNeighbors += LookForNeighbor(tempPoint, neighbour);
							}

						}
						if (numbersNeighbors > 2) {

							endSpaceGame.add(tempPoint);
						} else {
							containerChekedPoint.add(tempPoint);
						}
						testAddSpaceGame.remove(tempPoint);
					}

				}

			}

		}
	}

	private boolean checkAddElement(Set<Point> startSpaceGame, Set<Point> endSpaceGame, Point actualPoint) {
		boolean equalNotExistPointStartSpaceGame = checkExistElementInSpaces(startSpaceGame, actualPoint);
		boolean equalNotExistPointEndSpaceGame = checkExistElementInSpaces(endSpaceGame, actualPoint);

		return equalNotExistPointStartSpaceGame && equalNotExistPointEndSpaceGame;
	}

	private boolean checkExistElementInSpaces(Set<Point> startSpaceGame, Point actualPoint) {
		boolean contains = true;
		for (Point point : startSpaceGame) {
			contains = point.equals(actualPoint);
			if (contains) {
				return false;
			}
		}
		return true;
	}

	private void removePoint(Set<Point> startSpaceGame, Set<Point> endSpaceGame) {
		for (Point owner : startSpaceGame) {
			int numbersNeighbors = 0;

			for (Point neighbour : startSpaceGame) {
				if (!owner.equals(neighbour)) {

					numbersNeighbors += LookForNeighbor(owner, neighbour);
				}
			}

			if (numbersNeighbors < 2 || numbersNeighbors > 3) {
				endSpaceGame.remove(owner);
			}
		}
	}

	private int LookForNeighbor(Point owner, Point neighbour) {
		int numbersNeighbors = 0;

		int xOwner = owner.getX();
		int yOwner = owner.getY();
		int xNeighbor = neighbour.getX();
		int yNeighbor = neighbour.getY();

		if (((yOwner - 1 == yNeighbor) || (yOwner + 1 == yNeighbor) || (yOwner == yNeighbor))
				&& ((xOwner - 1 == xNeighbor) || (xOwner + 1 == xNeighbor) || (xOwner == xNeighbor))) {
			numbersNeighbors++;
		}
		return numbersNeighbors;
	}

}
