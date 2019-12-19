package application;

public class Rounds {
	private static final int MIN_ROUNDS = 1;
	
	private int rounds;
	
	public Rounds(int input) {
		checkValidInput(input);
		this.rounds = input;
	}
	
	private void checkValidInput(int input) {
		if (input < MIN_ROUNDS) {
			throw new IllegalArgumentException("1 이상의 숫자를 입력해주세요");
		}
	}
}
