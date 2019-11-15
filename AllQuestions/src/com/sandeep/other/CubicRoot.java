package com.sandeep.other;

public class CubicRoot {

	public static void main(String[] args) {
		
		double n = 3;
		System.out.println(findCubicRoot(n));

	}

	private static double findCubicRoot(double n) {
		
		double start = 0;
		double end = n;
		
		// precision of decimal point
		double precision = 0.0000001;
		
		while (true) {
			
			System.out.println("Begin loop start: " + start + ", end: " + end);
			
			double mid = (start + end) / 2;
			double error = diff(n, mid);
			
			System.out.println("mid: " + mid + ", error: " + error);
			
            // If error is less than precision then mid is 
            // our answer so return mid 
			if (error <= precision) {
				return mid;
			}
			
            // If mid*mid*mid is greater than n set
            // end = mid 
			if ((mid * mid * mid) > n) {
				end = mid;
			} else {
				
	            // If mid*mid*mid is less than n set 
	            // start = mid 
				start = mid;
			}
			
		}
		
	}

	private static double diff(double n, double mid) {
		
		if (n > (mid * mid * mid)) {
			return (n - (mid * mid * mid));
		} else {
			return ((mid * mid * mid) - n);
		}
		
	}

}
