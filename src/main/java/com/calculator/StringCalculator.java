package com.calculator;

public class StringCalculator {

	private int callCount = 0;

	public int add(String numbers) {

		callCount++;

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
        int sum = 0;
        StringBuilder negatives = new StringBuilder();
        for (String token : tokens) {
            if (!token.isEmpty()) {
                int num = Integer.parseInt(token.trim());
                if (num < 0) {
                    if (negatives.length() > 0) negatives.append(",");
                    negatives.append(num);
                }
                if (num <= 1000) {
                    sum += num;
                }
            }
        }
        
		if (negatives.length() > 0) {
			throw new IllegalArgumentException("negatives not allowed: " + negatives);
		}
		return sum;
	}

	public int getCalledCount() {
		return callCount;
	}

}