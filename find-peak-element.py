class Solution:
    # @param nums, an integer[]
    # @return an integer
    def findPeakElement(self, nums):
        if len(nums) <= 1:
            return 0
        for i in range(0, len(nums)):
            if i == 0:
                if nums[i] > nums[i+1]:
                    return i
            elif i == len(nums) - 1:
                if nums[i] > nums[i-1]:
                    return i
            else:
                if nums[i] > nums[i-1] and nums[i] > nums[i+1]:
                    return i
                