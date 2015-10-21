package poker;

import java.util.ArrayList;
import java.util.List;

import poker.card.Card;
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

public class HandParser {

	public Hand parse(String hand) {
		List<Card> cardsOnHand = getCardsOnHand(hand);
		return getHand(cardsOnHand);
	}

	private List<Card> getCardsOnHand(String hand) {
		String[] cards = hand.split(" ");
		List<Card> cardsOnHand = new ArrayList<Card>();

		for (int i = 0; i < cards.length; i++) {
			String value = cards[i].substring(0, 1);
			String color = cards[i].substring(1);

			cardsOnHand.add(new Card(value, color));
		}

		return cardsOnHand;
	}

	public Hand getHand(List<Card> cards) {
		Hand hand = null;
		CardValue highestCard = getHighestCard(cards);
		CardValue pair = getSet(cards, 2);
		CardValue secondPair = getSet(cards, 2, pair);
		CardValue threeOfAKind = getSet(cards, 3);
		CardValue fourOfAKind = getSet(cards, 4);
		boolean straight = isStraight(cards);
		boolean flush = isFlush(cards);

		if (flush && straight) {
			hand = new StraightFlush(highestCard);
		} else if (flush && straight) {
			hand = new StraightFlush(CardValue.FIVE);
		} else if (flush) {
			hand = new Flush(highestCard);
		} else if (straight) {
			hand = new Straight(highestCard);
		} else if (straight) {
			hand = new Straight(CardValue.FIVE);
		} else if (is(fourOfAKind)) {
			hand = new FourOfAKind(fourOfAKind);
		} else if (is(pair) && is(threeOfAKind)) {
			hand = new Full(threeOfAKind, pair);
		} else if (is(threeOfAKind)) {
			hand = new ThreeOfAKind(threeOfAKind);
		} else if (is(secondPair)) {
			hand = new TwoPair(pair, secondPair, getHighestCardIfIstPairOrTwoPairs(cards, pair, secondPair));
		} else if (is(pair)) {
			hand = new Pair(pair, getHighestCardIfIstPairOrTwoPairs(cards, pair, CardValue.UNDEFINED));
		} else {
			hand = new HighCard(highestCard);
		}

		return hand;
	}

	public boolean is(CardValue c) {
		return c != null;
	}

	private CardValue getHighestCard(List<Card> cards) {
		CardValue highestCard = cards.get(0).value;

		for (int i = 1; i < cards.size(); i++) {
			if (highestCard.compare(cards.get(i).value) < 0) {
				highestCard = cards.get(i).value;
			}
		}
		return highestCard;
	}

	private CardValue getHighestCardIfIstPairOrTwoPairs(List<Card> cards, CardValue firstPair, CardValue secondPair) {
		CardValue highestCard = cards.get(0).value;
		for (int i = 1; i < cards.size(); i++) {
			if (highestCard.compare(firstPair) != 0 && highestCard.compare(secondPair) != 0) {
				if (highestCard.compare(cards.get(i).value) < 0) {
					if (cards.get(i).value.compare(firstPair) != 0 && cards.get(i).value.compare(secondPair) != 0) {
						highestCard = cards.get(i).value;
					}
				}
			} else {
				highestCard = cards.get(i).value;
			}
		}
		return highestCard;
	}

	private CardValue getSet(List<Card> cards, int n) {
		return getExactNumberOfCards(cards, n, CardValue.UNDEFINED);
	}

	private CardValue getSet(List<Card> cards, int expectedNumber, CardValue otherThan) {
		return otherThan == null ? null : getExactNumberOfCards(cards, expectedNumber, otherThan);
	}

	private CardValue getExactNumberOfCards(List<Card> cards, int expectedNumber, CardValue otherThan) {
		List<CardValue> excludeList = new ArrayList<CardValue>();
		excludeList.add(otherThan);

		for (int i = 0; i < cards.size(); i++) {
			int expectedMore = expectedNumber - 1;
			CardValue card = cards.get(i).value;

			if (!excludeList.contains(card)) {
				for (int j = i + 1; j < cards.size(); j++) {
					if (card.compare(cards.get(j).value) == 0) {
						expectedMore--;
					}
				}
				if (expectedMore == 0) {
					return card;
				}
			}
			excludeList.add(card);
		}
		return null;
	}

	private boolean isStraight(List<Card> cards) {
		int expectedtStraight = 1;
		for (int i = 0; i < cards.size(); i++) {
			CardValue card = cards.get(i).value;
			for (int j = 1; j < cards.size(); j++) {
				if ((card.getValue() + 1) == cards.get(j).value.getValue()) {
					expectedtStraight++;
				}
			}

			if (expectedtStraight == 5) {
				return true;
			}
		}
		return false;
	}

	private boolean isFlush(List<Card> cards) {
		int expectedMore = 1;

		String card = cards.get(0).color;

		for (int j = 1; j < cards.size(); j++) {
			if (card.equals(cards.get(j).color)) {
				expectedMore++;
			}
		}

		if (expectedMore == 5) {
			return true;
		}

		return false;
	}
}
