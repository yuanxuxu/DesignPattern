package designpatterns;

import java.util.*;

class Test {
	public static void main(String[] args) {

	}

	// Oct 28th, 2022
	public int minDeletions(String s) {
		Set<Integer> v = new HashSet<>();
		int[] count = new int[26];
		for (char c : s.toCharArray()) {
			count[c - 'a']++;
		}
		int res = 0;
		for (int i = 0; i < 26; i++) {
			while (count[i] > 0 && !v.add(count[i])) {
				count[i]--; // pick a non-used freq for cur char
				res++;
			}
		}

		return res;
	}
}