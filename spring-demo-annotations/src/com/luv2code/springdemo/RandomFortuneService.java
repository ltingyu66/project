package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	
	//create an array of string
	private String[] data = {
			"Beware of the wolf in sheep's",
			"Diligence is the mother",
			"The journey is reward"
	};
	// create a random number
	private Random myRandom = new Random();
	
	
	@Override
	public String getFortune() {
		// pick a random string from the array
		int index = myRandom.nextInt(data.length);
		String theFortune = data[index];
		return theFortune;
	}

}
