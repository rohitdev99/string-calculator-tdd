package com.calculator;

public class StringCalculator {

	private int callCount = 0;

	public int add(String numbers) {
		callCount++;
		if (numbers == null || numbers.isEmpty()) {
			return 0;
		}

		String numString = numbers;
		String delimiter = ",|\n";

		if (numbers.startsWith("//")) {
			int delimiterEnd = numbers.indexOf('\n');
			String delimiterSection = numbers.substring(2, delimiterEnd);
			if (delimiterSection.startsWith("[")) {
				// Multiple delimiters or delimiters of any length
				java.util.List<String> delimiters = new java.util.ArrayList<>();
				int i = 0;
				while (i < delimiterSection.length()) {
					if (delimiterSection.charAt(i) == '[') {
						int close = delimiterSection.indexOf(']', i);
						delimiters.add(java.util.regex.Pattern.quote(delimiterSection.substring(i + 1, close)));
						i = close + 1;
					} else {
						i++;
					}
				}
				delimiter = String.join("|", delimiters);
			} else {
				// Single delimiter
				delimiter = java.util.regex.Pattern.quote(delimiterSection);
			}
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