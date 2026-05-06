/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        int max = intervals.stream().mapToInt(e -> e.end).max().orElse(0);
        boolean zeros = false;
        int[] dp = new int[max+1];
        for (int i = 0; i < intervals.size(); i++) {
            int start = intervals.get(i).start;
            int end = intervals.get(i).end;
            if (dp[start] != 0) {
                return false;
            }
            dp[start] = Math.max(dp[start], end);
        }
        // int right = Integer.MIN_VALUE;
        for (int i = 0, right = 0; i < dp.length; i++) {
            if (i == right) {
                right = Integer.MIN_VALUE;
            }
            if (dp[i]!=0) {
                if (right != Integer.MIN_VALUE) {
                    return false;
                }
                right = dp[i];
            }
        }

        return true;
    }
}
