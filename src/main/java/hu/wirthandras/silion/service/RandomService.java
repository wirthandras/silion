package hu.wirthandras.silion.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class RandomService {

	private Random r = new Random();

	public int nextInt(int bound) {
		return r.nextInt(bound);
	}
}
