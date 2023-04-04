package com.tech.tnshop;

import lombok.RequiredArgsConstructor;
import org.apache.commons.text.similarity.LevenshteinDistance;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@RequiredArgsConstructor
class TnshopApplicationTests {

	@Test
	void test () {
		String[] items = {"apple", "banana", "orange", "grape"};
		String inputString = "apple";
		LevenshteinDistance distance = new LevenshteinDistance();
		String result = Arrays.stream(items)
				.filter(item -> distance.apply(item.toLowerCase(), inputString.toLowerCase()) <= inputString.length() / 2)
				.min(Comparator.comparingInt(item -> distance.apply(item.toLowerCase(), inputString.toLowerCase())))
				.orElse(null);
		assertNotNull(result, "Result should not be null");
		assertEquals("apple", result, "Result should equal 'apple'");
	}

}
