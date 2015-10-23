package poker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		int winPlayerA = 0;
		int winPlayerB = 0;
		int remis = 0;

		ArbitrateDuel duel = new ArbitrateDuel();
		FileReader fileReader = new FileReader("src/poker.txt");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String textLine = bufferedReader.readLine();
		do {

			int actualResult = duel.getCard(textLine);

			if (actualResult == 1) {
				winPlayerA++;
			} else if (actualResult == 2) {
				winPlayerB++;
			} else {
				remis++;
			}

			textLine = bufferedReader.readLine();
		} while (textLine != null);

		bufferedReader.close();

		printScore(winPlayerA, winPlayerB, remis);

	}

	private static void printScore(int winPlayerA, int winPlayerB, int remis) {
		System.out.println("Gracz piewszy wygral : " + winPlayerA + " razy");
		System.out.println("Gracz drugi wygral : " + winPlayerB + " razy");
		System.out.println("Liczba remisow to : " + remis);
		System.out.println();
	}

}
