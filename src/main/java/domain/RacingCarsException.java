package domain;

import java.util.List;

public class RacingCarsException {
	public static void checkValidCarNames(List<String> input) {
		checkOverlappingNames(input);
	}
	
	private static void checkOverlappingNames(List<String> input) {
		if (input.stream().distinct().count() != input.size()) {
			throw new IllegalArgumentException("중복되지 않은 이름을 입력해주세요");
		}
	}
}
