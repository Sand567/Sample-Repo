package com.sandeep.other.leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

 */
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
		
		intervals.forEach(i -> System.out.print(i + " "));
		
		Interval key = new Interval(4, 9);
		
		System.out.println("\nNew Interval: " + key);

		List<Interval> result = new ArrayList<>(insert(intervals, key));
		
		result.forEach(res -> System.out.print(res + " "));
	}

	private static Collection<? extends Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> output = new ArrayList<>();
		
		for (Interval interval : intervals) {
			// if interval is before newInterval
			if (newInterval == null || interval.end < newInterval.start) {
				output.add(interval);
			} else if (newInterval.end < interval.start) {
				// if newInterval is before interval
				output.add(newInterval);
				newInterval = null;
				output.add(interval);
			} else {
				// overlapping case: newInterval overlaps with interval
				newInterval.start = Math.min(newInterval.start, interval.start);
				newInterval.end = Math.max(newInterval.end, interval.end);
			}
		}
		
		if (newInterval == null) {
			return output;
		}

		output.add(newInterval);
		return output;
	}

}
