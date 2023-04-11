import java.util.ArrayList;

public class Player {
	private ArrayList<Card> Cards = new ArrayList<Card>();
	
	public void addCard(Card card) {
		this.Cards.add(card);
	}
	
	public ArrayList<Card> getCards(){
		return this.Cards;
	}
	
	public void emptyHand() {
		this.Cards.clear();
	}
	
	public int getScore() {
		return this.calculateScore();
	}
	
	
	private int calculateScore() {
		int score = 0;
		int aceNum = 0;
		for (Card card : this.Cards) {
			score += card.getPoints();
			if (card.getNumber() == 1) {
				aceNum++;
			}
		}
		
		while (score > 21) {
			if (aceNum > 0) {
				score -=10;
				aceNum -=1;
			}
		}
		
		return score;
	}
	
}
