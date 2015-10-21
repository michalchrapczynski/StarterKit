package poker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		ArbitrateDuel duel = new ArbitrateDuel();

		FileReader fileReader = new FileReader("src/poker.txt");
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		String textLine = bufferedReader.readLine();
		do {
			System.out.println(textLine);

			duel.getCard(textLine);

			textLine = bufferedReader.readLine();
		} while (textLine != null);

		bufferedReader.close();

	}

}
