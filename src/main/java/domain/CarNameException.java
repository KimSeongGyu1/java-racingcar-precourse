package domain;

public class CarNameException {
	private static final int MAX_NAME_LENGTH = 5;
	private static final int MIN_NAME_LENGTH = 1;
	
	public static void checkValidCarName(String input) {
		checkLenOfCarName(input);
	}
	
	private static void checkLenOfCarName(String input) {
		if (input.length() > MAX_NAME_LENGTH
				|| input.length() < MIN_NAME_LENGTH) {
			throw new IllegalArgumentException("5자 이하의 비어있지 않은 이름을 입력해주세요");
		}
	}
}
