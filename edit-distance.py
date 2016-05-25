class Solution:
    # @param {string} word1
    # @param {string} word2
    # @return {integer}
    
    def getEditDistance(self, str1, str2):
      len1 = len(str1)
      len2 = len(str2)
      #step 1
      if len1 == 0:
        return len2
      if len2 == 0:
        return len1
      d = [[0 for col in range(len2 + 1)] for row in range(len1 + 1)]
      #step 2
      for i in range(0, len1+1, 1):
        d[i][0] = i
      for j in range(0, len2+1, 1):
        d[0][j] = j
      #step 3
      for i in range(1, len1+1, 1):
        str1_i = str1[i-1]
        for j in range(1, len2+1, 1):
          str2_j = str2[j-1]
          cost = 1
          if str1_i == str2_j:
            cost = 0
          else:
            cost = 1
          d[i][j] = d[i-1][j] + 1
          if d[i][j-1] + 1 < d[i][j]:
            d[i][j] = d[i][j-1] + 1
          if d[i-1][j-1] + cost < d[i][j]:
            d[i][j] = d[i-1][j-1] + cost
      #    print d
      #print 'end:'
      #print d
      return d[len1][len2]
    def minDistance(self, word1, word2):
        return self.getEditDistance(word1, word2);
        