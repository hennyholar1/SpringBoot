package com.training.learning;

import com.training.learning.dao.StudentRepository;
import com.training.learning.domain.Services;
import com.training.learning.domain.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.security.SecureRandom;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootApplication
public class LearningApplication implements CommandLineRunner {

	@Autowired
	StudentRepository studentRepository;

	private static final SecureRandom secureRandom = new SecureRandom();
	private static final List<String> STREET_NAMES = List.of("Main", "Park", "Oak", "Pine", "Maple", "Elm", "Washington", "Jefferson", "Lincoln", "Broadway");
	private static final List<String> STATES = List.of("AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY");
	private static final List<String> STREET_TYPES = List.of("St", "Ave", "Dr", "Blvd", "Ct", "Close", "Cir", "Pl");

	public static void main(String[] args) {
		SpringApplication.run(LearningApplication.class, args);
	}

	@Bean
	Services services() {
		return new Services(secureRandom.nextInt(1000) + 1);
	}

	@Override
	@Profile("dev")
	public void run(String... args) throws Exception {
		for (int i=0; i <= 5; i++) {
			studentRepository.save(new Students((generateRandomString() + " " + generateRandomString()), generateRandomAddress()));
		}
		System.out.println("The students full name list:      " + studentRepository.getListOfFirstNames());
	}


	public static String generateRandomString() {
		final var length = 2 + secureRandom.nextInt(8);
		var stringBuilder = new StringBuilder(length);
		IntStream.range(0, length).forEach(i -> stringBuilder.append((char) ('a' + secureRandom.nextInt(26))));
		stringBuilder.setCharAt(0, Character.toUpperCase(stringBuilder.charAt(0)));

		return stringBuilder.toString();
	}


	public static String generateRandomAddress() {
		var houseNumber = secureRandom.nextInt(1000) + 1;
		var streetName = STREET_NAMES.get(secureRandom.nextInt(STREET_NAMES.size()));
		var streetType = STREET_TYPES.get(secureRandom.nextInt(STREET_TYPES.size()));
		var city = generateRandomString();
		var state = STATES.get(secureRandom.nextInt(STATES.size()));
		//var zipCode = Math.abs(secureRandom.nextInt(100000));
		var zipCode = (Math.abs(secureRandom.nextInt(100000)) % 100000) + 1;

		return houseNumber + " " + streetName + " " + streetType + ", " + city + ", " + state + " " + zipCode;
	}
}