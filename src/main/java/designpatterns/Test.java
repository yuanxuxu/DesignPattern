package designpatterns;

import java.util.*;

class Test {
	public static void main(String[] args) {

	}

	// Nov 9th, 2022
	public int countPrimes(int n) {
		boolean[] primes = new boolean[n];
		Arrays.fill(primes, true);
		int count = 0;

		// 0 or 1 is not prime numbers
		for (int i = 2; i < n; i++) {
			if (primes[i]) {
				count++;
				for (int j = 2; i * j < n; j++) {
					primes[i * j] = false;
				}
			}
		}

		return count;
	}
}