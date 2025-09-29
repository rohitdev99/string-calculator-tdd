package com.calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

	public int add(String numbers) {
		if (numbers == null || numbers.isEmpty()) {
			return 0;
		}

		String delimiter = ",|\n";
		String numString = numbers;

		if (numbers.startsWith("//")) {
			int delimiterEnd = numbers.indexOf('\n');
			delimiter = java.util.regex.Pattern.quote(numbers.substring(2, delimiterEnd));
			numString = numbers.substring(delimiterEnd + 1);
		}

		String[] tokens = numString.split(delimiter);
		List<Integer> negatives = new ArrayList<>();
		int sum = 0;
		for (String token : tokens) {
			if (!token.isEmpty()) {
				int num = Integer.parseInt(token.trim());
				if (num < 0) {
					negatives.add(num);
				}
				sum += num;
			}
		}
		if (!negatives.isEmpty()) {
			throw new IllegalArgumentException("negatives not allowed: " + negatives);
		}
		return sum;
	}

}