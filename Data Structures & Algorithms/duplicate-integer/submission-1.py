class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        myset = set()
        for i in range(len(nums)):
            if nums[i] in myset:
                return True
            myset.add(nums[i])
        return False