package com.sandeep.other;

public class Pair {
	
	private int pair1;
	private int pair2;
	
	public Pair(int pair1, int pair2) {
		this.pair1 = pair1;
		this.pair2 = pair2;
	}

	public int getPair1() {
		return pair1;
	}

	public void setPair1(int pair1) {
		this.pair1 = pair1;
	}

	public int getPair2() {
		return pair2;
	}

	public void setPair2(int pair2) {
		this.pair2 = pair2;
	}

	@Override
	public String toString() {
		return "Pair [pair1=" + pair1 + ", pair2=" + pair2 + "]";
	}
	
}
