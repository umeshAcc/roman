package com.umesh.roman.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NumberConverter {
	private final Map<Character, Integer> roman = new HashMap<Character, Integer>() {

		{
			put('I', 1);
			put('V', 5);
			put('X', 10);
			put('L', 50);
			put('C', 100);
			put('D', 500);
			put('M', 1000);
		}
	};

	@GetMapping(path = "/convert-to-roman/{input}", produces = "plain/text")
	public @ResponseBody String convertToRoman(@PathVariable Integer input) {
		validateNumber(input);
		String roman = numberToRoman(input);
		return String.format("%s", roman);
	}

	@GetMapping(path = "/convert-to-number/{input}", produces = "plain/text")
	public @ResponseBody String convertToNumber(@PathVariable String input) {
		validateRoman(input);
		if(input.equals("M(V)")) {
			return "4000";
		}
		int result = romanToNumber(input);
		System.out.println(result);
		return String.format("%d", result);
	}

	private void validateNumber(int input) {
		if (input <= 0 || input > 4000) {
			throw new NumberFormatException("Invalid number");
		}
	}

	private void validateRoman(String input) {
		if (input == null) {
			throw new NumberFormatException("Invalid Roman numeral");
		}
		if(input.equals("M(V)")) {
			return;
		}
		String regex = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
		Pattern p = Pattern.compile(regex);
	
		Matcher m = p.matcher(input);
		if (!m.matches()) {
			throw new NumberFormatException("Invalid Roman numeral");
		}
	}

	private String numberToRoman(int number) {
		validateNumber(number);
		String m[] = { "", "M", "MM", "MMM", "M(V)" };
		String c[] = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
		String x[] = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
		String i[] = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
		String thousands = m[number / 1000];
		String hundreds = c[(number % 1000) / 100];
		String tens = x[(number % 100) / 10];
		String ones = i[number % 10];

		String ans = thousands + hundreds + tens + ones;

		return ans;
	}

	private int romanToNumber(String str) {
		int sum = 0;
		int n = str.length();
		for (int i = 0; i < n; i++) {
			if (i != n - 1 && roman.get(str.charAt(i)) < roman.get(str.charAt(i + 1))) {
				sum += roman.get(str.charAt(i + 1)) - roman.get(str.charAt(i));
				i++;
			} else {
				sum += roman.get(str.charAt(i));
			}
		}
		return sum;
	}
}
