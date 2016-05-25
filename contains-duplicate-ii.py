class Solution(object):
    def containsNearbyDuplicate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        dic = dict();
        l = len(nums);
        for i in range(l):
            index = dic.get(nums[i])
            if index >= 0 and i - index <= k:
                return True;
            dic[nums[i]] = i;
        return False;