"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def minMeetingRooms(self, intervals: List[Interval]) -> int:
        intervals.sort(key=lambda x: x.start)
        minheap = []
        for interval in intervals:
            if minheap and minheap[0] <= interval.start:
                heapq.heappop(minheap)
            heapq.heappush(minheap, interval.end)
        return len(minheap)