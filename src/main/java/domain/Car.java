package domain;

public class Car {
	private static final int MAX_NAME_LENGTH = 5;
	private static final int MIN_NAME_LENGTH = 1;
	
	private final String name;
	private int position = 0;
	
	public Car(String name) {
		checkValidCarName(name);
		this.name = name;
	}
	
	public void checkValidCarName(String input) {
		checkLenOfCarName(input);
	}
	
	private void checkLenOfCarName(String input) {
		if (input.length() > MAX_NAME_LENGTH
				|| input.length() < MIN_NAME_LENGTH) {
			throw new IllegalArgumentException("5자 이하의 비어있지 않은 이름을 입력해주세요");
		}
	}
	
	public String getName() {
		return this.name;
	}
}
