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
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        int end = Integer.MIN_VALUE;
        for (Interval interval : intervals) {
            if (end != Integer.MIN_VALUE && end > interval.start) {
                return false;
            }
            end = interval.end;
        }
        return true;
    }
}
