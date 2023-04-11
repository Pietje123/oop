import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private ArrayList<Card> currentlyInDeck;
	private ArrayList<Card> fullDeck;
	
	public Deck() {
		ArrayList<Card> newDeck = new ArrayList<Card>();
		
		String[] suits = {"Heart", "Spade", "Diamonds", "Clubs" };
		for (String suit : suits) {
			for (int i = 1; i < 14; i++) {
				Card card = new Card(i, suit, i);
				newDeck.add(card);
			}	
		}
		this.fullDeck = newDeck;
		shuffleDeck();
	}	
	
	public void shuffleDeck() {
		Collections.shuffle(this.fullDeck);
		this.currentlyInDeck = this.fullDeck;
	}
	
	public ArrayList<Card> getCurrentlyInDeck(){
		return this.currentlyInDeck;
	}
	
	public Card drawCard() {
		Card first = this.currentlyInDeck.get(0);
		this.currentlyInDeck.remove(0);
		return first;
	}
}
