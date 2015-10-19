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

						for (Point point2 : testAddSpaceGame) {
							if (!tempPoint.equals(point2)) {
								int xNeighbor = point2.getX();
								int yNeighbor = point2.getY();
								numbersNeighbors += LookForNeighbor(i, j, xNeighbor, yNeighbor);
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
		for (Point point : startSpaceGame) {
			int xOwner = point.getX();
			int yOwner = point.getY();
			int numbersNeighbors = 0;

			for (Point point2 : startSpaceGame) {
				if (!point.equals(point2)) {
					int xNeighbor = point2.getX();
					int yNeighbor = point2.getY();

					numbersNeighbors += LookForNeighbor(xOwner, yOwner, xNeighbor, yNeighbor);
				}
			}

			if (numbersNeighbors < 2 || numbersNeighbors > 3) {
				endSpaceGame.remove(point);
			}
		}
	}

	private int LookForNeighbor(int xOwner, int yOwner, int xNeighbor, int yNeighbor) {
		int numbersNeighbors = 0;
		if (((yOwner - 1 == yNeighbor) || (yOwner + 1 == yNeighbor) || (yOwner == yNeighbor))
				&& ((xOwner - 1 == xNeighbor) || (xOwner + 1 == xNeighbor) || (xOwner == xNeighbor))) {
			numbersNeighbors++;
		}
		return numbersNeighbors;
	}

}
