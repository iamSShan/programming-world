/*
Problem: https://leetcode.com/problems/merge-intervals/
*/
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


class MergeOverlappingIntervals {


	public static int[][] merge(int[][] intervals) {
		// Sort array based on first index of each element
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

		// To store final intervals
		List<int []> list = new ArrayList<>();

		// We will use first element to compare with array
		int start = intervals[0][0];
		int end = intervals[0][1];

		for(int i=0; i<intervals.length; i++) {
			// First element should be less than second element of 2nd or prev element
			if(intervals[i][0] <= end) {
				// End will be updated to max
				end = Math.max(intervals[i][1], end);
			}
			// If not overlapping
			else {
				// Then simply add current start and end to final list and update start and end to current elements
				list.add(new int[]{start, end});
				start = intervals[i][0];
				end = intervals[i][1];
			}
		}
		// Add the final start and end 
		list.add(new int[]{start, end});
		// Convert list to array
		return list.toArray(new int[0][]);
	}

	public static void main(String[] args) {
		int[][] intervals = {{1,3}, {2, 6}, {8, 10}, {15,18}};
		int[][] output = merge(intervals);
		for(int row=0; row<output.length; row++) {
			for(int col=0; col<output[row].length; col++) {
				System.out.print(output[row][col]+ "\t");
			}
		}
	}
}