package view;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class InputView {
	private static Scanner SCANNER = new Scanner(System.in);
	
	public static List<String> enterCarNames() {
		try {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분");
			return ParseStringToList(SCANNER.nextLine());
		} catch (IllegalArgumentException e) {
			System.out.println("적절한 이름들을 입력해주세요");
			return enterCarNames();
		}
	}
	
	private static List<String> ParseStringToList(String input) {
		List<String> output = new ArrayList<String>();
		String[] splittedString = input.split(",");
		for (String partition : splittedString) {
			output.add(partition.trim());
		}
		return output;
	}
}
