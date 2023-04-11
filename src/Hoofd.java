import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.Random;
import java.util.HashSet;
import java.util.Collections;

public class Hoofd {
	public static void main(String[] args) {
KAPOT		
		System.out.println("How many players?");
		Scanner scan = new Scanner(System.in);

		try {
			String userInput = scan.nextLine();
			int playerNum = Integer.parseInt(userInput);
			System.out.println(playerNum);
		
			Deck deck = new Deck();
			ArrayList<Player> Players = new ArrayList<Player>();
			
			for (int curr = 0; curr < playerNum; curr++) {
				Player player = new Player();
				for (int i = 0; i < 2; i++) {
					Card card = deck.drawCard();
					player.addCard(card);
				}
				Players.add(player);
			}
			Set<String> validInputs = new HashSet<String>();
			
			String[] valids = {"c", "q", "p"};
			for (String validInput: valids) {
				validInputs.add(validInput);
			}
			Set<Integer> passedPlayers = new HashSet<Integer>();
			
			while (Players.size() > passedPlayers.size()) {
				for (int curr = 0; curr < Players.size(); curr++) {
					if (passedPlayers.contains(curr)) {
						continue;
					}
					Player player = Players.get(curr);
					int currScore = player.getScore();
					System.out.println("Your score is " + currScore);
					System.out.println("Do you want to play?");
					System.out.println("Valid inputs are c (new card), p (pass) and q (quit)");
					userInput = scan.nextLine();
					while (!validInputs.contains(userInput)) {
						System.out.println("Invalid input use: c, q, p");
						userInput = scan.nextLine();
					}
					
					switch (userInput) {
						case "q":
							System.out.println("Removed player");
							break;
						case "c":
							player.addCard(deck.drawCard());
							break;
						case "p":
							passedPlayers.add(curr);
							
					}
				}
			}
		}
		catch (NumberFormatException ex) {
			ex.printStackTrace();
		}		
		scan.close();
		
	}
}
