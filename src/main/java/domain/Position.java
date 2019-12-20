package domain;

import java.util.Random;

public class Position {
	private static final int RAND_RANGE = 10;
	private static final int THRESHOLD = 3;
	
	private static Random RANDOM = new Random();
	private int position = 0;
	
	public Position() {}
	
	public void goOrStay() {
		if (RANDOM.nextInt(RAND_RANGE) > THRESHOLD) {
			position++;
		}
	}
	
	public int getPosition() {
		return this.position;
	}
	
	public boolean isBiggerThan(Position input) {
		if (this.position > input.getPosition()) {
			return true;
		}
		return false;
	}
	
	public boolean isSmallerThan(Position input) {
		if (this.position < input.getPosition()) {
			return true;
		}
		return false;
	}
	
	public void setTo(Position input) {
		this.position = input.getPosition();
	}
	
	public String toString() {
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < this.position; i++) {
			output.append("-");
		}
		return output.toString();
	}
}
