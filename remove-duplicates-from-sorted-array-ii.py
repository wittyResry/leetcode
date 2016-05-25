class Solution:
    # @param A a list of integers
    # @return an integer
    def removeDuplicates(self, A):
        A.sort()
        l = len(A)
        cnt = 0
        for i in range(0, l):
            if i == 0:
                pre2 = A[i]
                cnt = cnt + 1
            elif i == 1:
                pre1 = A[i]
                cnt = cnt + 1
            else:
                if pre1 == A[i] and pre2 == A[i]:
                    pre2 = pre1
                    pre1 = A[i]
                    continue
                pre2 = pre1
                pre1 = A[i]
                A[cnt] = A[i]
                cnt = cnt + 1
        return cnt