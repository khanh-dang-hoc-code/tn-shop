package com.tech.tnshop;

import lombok.RequiredArgsConstructor;
import org.apache.commons.text.similarity.LevenshteinDistance;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

@SpringBootTest
@RequiredArgsConstructor
class TnshopApplicationTests {

	private final BCryptPasswordEncoder passwordEncoder;

	@Test
	public void test () {
		String[] items = {"apple", "banana", "orange", "grape"};
		String inputString = "aaaaaa";
		LevenshteinDistance distance = new LevenshteinDistance();
		String result = Arrays.stream(items)
				.filter(item -> distance.apply(item.toLowerCase(), inputString.toLowerCase()) <= inputString.length() / 2)
				.min(Comparator.comparingInt(item -> distance.apply(item.toLowerCase(), inputString.toLowerCase())))
				.orElse(null);

		System.out.println(result);
	}


}
