# String Calculator TDD

A Java implementation of the String Calculator kata, developed using Test-Driven Development (TDD).

## Features
- Add numbers in a string separated by commas or newlines
- Support for custom delimiters, including multiple delimiters and delimiters of any length
- Throws an exception for negative numbers, listing all negatives in the message
- Ignores numbers greater than 1000
- Tracks the number of times the `add` method is called

## Usage

The main class is `com.calculator.StringCalculator`.

Example usage:
```java
StringCalculator calculator = new StringCalculator();
int result = calculator.add("1,2,3"); // returns 6
```

### Supported Input Formats
- `""` → returns 0
- `"1"` → returns 1
- `"1,2"` → returns 3
- `"1\n2,3"` → returns 6
- `"//;\n1;2"` → returns 3 (custom delimiter `;`)
- `"//[***]\n1***2***3"` → returns 6 (delimiter `***`)
- `"//[*][%]\n1*2%3"` → returns 6 (multiple delimiters `*` and `%`)
- `"//[**][%%]\n1**2%%3"` → returns 6 (multiple delimiters of length > 1)

### Negative Numbers
Throws `IllegalArgumentException` with all negative numbers listed:
```java
calculator.add("-1,-2,3"); // throws exception: "negatives not allowed: -1,-2"
```

### Numbers Greater Than 1000
Numbers > 1000 are ignored:
```java
calculator.add("2,1001"); // returns 2
calculator.add("2,1000"); // returns 1002
```

### Call Count
Get the number of times `add` was called:
```java
calculator.getCalledCount();
```

## Running Tests

This project uses JUnit for testing. To run all tests:

```
mvn test
```

## Project Structure
- `src/main/java/com/calculator/StringCalculator.java` — main implementation
- `src/test/java/com/calculator/StringCalculatorTest.java` — test suite

## License
MIT