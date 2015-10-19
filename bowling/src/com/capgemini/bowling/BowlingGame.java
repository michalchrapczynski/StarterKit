package com.capgemini.bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame implements BowlingGameResultCalculator {

	private List<Integer> listScore = new ArrayList<>();
	private List<Integer> listAbsolutScore = new ArrayList<>();
	private boolean finish = false;
	private int absoluteScore = 0;

	@Override
	public void roll(int numberOfPins) {
		listScore.add(numberOfPins);

	}

	private void checkAddPoints() {
		listAbsolutScore.addAll(listScore);
		for (int i = 2; i < listScore.size(); i++) {

			if (i % 2 == 0 && listScore.get(i - 2) == 10) {
				changeValueIfStrike(i);

			} else if (i % 2 == 0 && listScore.get(i - 2) + listScore.get(i - 1) == 10) {
				changeValueIfSpare(i);

			}
		}
	}

	private void changeValueIfStrike(int i) {
		if (i == 20) {
			int tempValue = listScore.get(i) * 2;
			listAbsolutScore.set(i, tempValue);
		} else {
			int tempValue = listScore.get(i) * 2 + listScore.get(i + 1);
			listAbsolutScore.set(i, tempValue);
		}
	}

	private void changeValueIfSpare(int i) {
		int tempValue = listScore.get(i) * 2;
		listAbsolutScore.set(i, tempValue);
	}

	@Override
	public int score() {
		checkAddPoints();
		for (Integer r : listAbsolutScore) {
			absoluteScore += r;
		}
		return absoluteScore;

	}

	@Override
	public boolean isFinished() {
		return finish;
	}

}
