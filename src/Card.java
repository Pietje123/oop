
public class Card {
	private int number;
	private String Suit;
	private int points;
	
	public Card(int num, String suit, int point) {
		this.number = num;
		this.Suit = suit;
		
		if (point == 1) {
			this.points = point + 10;
		} else if (point < 10){
			this.points = point;
		} else {
			this.points = 10;
		}
	}
	public void setPoints(int new_points) {
		this.points = new_points;
	}

	public String getSuit() {
		return this.Suit;
	}
	
	public int getPoints() {
		return this.points;
	}
	
	public int getNumber() {
		return this.number;
	}
	
}
