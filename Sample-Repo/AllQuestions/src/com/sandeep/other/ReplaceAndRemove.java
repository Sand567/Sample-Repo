package com.sandeep.other;

import java.util.Arrays;

public class ReplaceAndRemove {

	public static void main(String[] args) {
		
		char[] c = {'a', 'c', 'd', 'b', 'b', 'c', 'a', 'b'};
		replaceAndRemove(c, c.length);

	}

	private static void replaceAndRemove(char[] c, int length) {
		
		int writeIdx = 0;
		int aCount = 0;
		
		char[] letters = new char[c.length];
		
		for (int i = 0; i < length; i++) {
			
			if (c[i] != 'b') {
				letters[writeIdx++] = c[i];
			}
			
			if (c[i] == 'a') {
				aCount++;
			}
			
		}
		
		System.out.println("letters length: " + letters.length);
		System.out.println("writeIdx: " + writeIdx);
		System.out.println("aCount: " + aCount);
		System.out.println(Arrays.toString(letters));
		
		int curIdx = writeIdx - 1;
		writeIdx = writeIdx + aCount - 1;
		final int finalSize = writeIdx + 1;
		
		System.out.println("Before curIdx: " + curIdx);
		System.out.println("Before writeIdx: " + writeIdx);
		System.out.println("Before finalSize: " + finalSize);
		
		while (curIdx >= 0) {
			if (letters[curIdx] == 'a') {
				letters[writeIdx--] = 'd';
				letters[writeIdx--] = 'd';
			} else {
				letters[writeIdx--] = letters[curIdx];
			}
			
			curIdx--;
		}
		
		System.out.println("After curIdx: " + curIdx);
		System.out.println("After writeIdx: " + writeIdx);
		System.out.println("After finalSize: " + finalSize);
		System.out.println(Arrays.toString(letters));
		
	}

}
