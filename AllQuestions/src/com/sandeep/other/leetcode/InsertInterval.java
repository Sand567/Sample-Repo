package com.sandeep.other.leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class InsertInterval {
	
	static class Interval {
		private int start;
		private int end;
		
		Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "[" + start + ", " + end + "]";
		}
		
	}

	public static void main(String[] args) {
		
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 2));
		intervals.add(new Interval(3, 5));
		intervals.add(new Interval(6, 7));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(12, 16));
		
		intervals.forEach(System.out::println);
		
		Interval key = new Interval(4, 9);
		
		System.out.println();
		
		List<Interval> result = new ArrayList<>();
		result.addAll(insert(intervals, key));
		
		result.forEach(System.out::println);
	}

	private static Collection<? extends Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> output = new ArrayList<>();
		
		for (Interval interval : intervals) {
			if (interval.end < newInterval.start) {
				output.add(interval);
			} else if (interval.start > newInterval.end) {
				output.add(newInterval);
				newInterval = interval;
			} else if (interval.end >= newInterval.start || interval.start <= newInterval.end) {
				newInterval = new Interval(Math.min(interval.start, newInterval.start), 
						Math.max(interval.end, newInterval.end));
			}
		}
		
		output.add(newInterval);
		return output;
	}

}
