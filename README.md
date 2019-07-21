### [3. 无重复字符的最长子串](https://leetcode.com/problems/longest-substring-without-repeating-characters/)
* 字符串处理滑动窗口，定义[i,j) 左闭右开，可以向左右滑动。那么就可将复杂度大大降低，从O(N^3)下降到O(2*N)，原因为每个index扫过i和j各一次。时间复杂度O(N)，空间复杂度O(N).
* 优化滑动窗口，就是将一边不是一个一个加，是跳跃者加（容易想起跳跃表），那么就可以将复杂度的常量继续下降.
* 注意边界的处理.
### [4. 两个数组取中位数](https://leetcode.com/problems/median-of-two-sorted-arrays/)
* 二分复杂的O(n+m)，要求复杂度log，i为数组nums1的分割，分割为nums1[i-1]和nums1[i];j为nums2的分割，分类讨论：
case1: m+n长度为偶数：
i + j = m - i + n - j
j = (m + n) / 2 - i
中位数为：(max(A[i-1],B[j-1]) + min(A[i],B[j]))/2
case2: m+n长度为奇数，定义左半部分比右半部分多1：
i + j = m - i  + n - j + 1
j = (m + n + 1) / 2 - i
中位数为：max(A[i-1], B[j-1])
### [5. 最长回文子串](https://leetcode-cn.com/problems/longest-palindromic-substring/solution/)
* 回文对称性，枚举中心节点的方式来处理，复杂度O(N^2)，空间复杂度O(1)
### [6. Z字形](https://leetcode-cn.com/problems/zigzag-conversion/) 
* 模拟题，时间复杂度: O(N)
### [8. 字符串转换整数 (atoi)](https://leetcode.com/problems/string-to-integer-atoi/)
* 考虑超过限制的情况，读题很重要。复杂度O(N)
### [53. 最大子序和](https://leetcode.com/problems/problems/maximum-subarray/description/)
* 动态规划，最大子段和。定义好“相邻”的动态规划方程。时间复杂度O(N), 空间复杂度O(N)
### [70. 爬楼梯](https://leetcode.com/problems/climbing-stairs/description/)
* 动态规划，dp[n] = dp[n-1] + dp[n-2]，时间复杂度：O(N), 空间复杂度O(N)
### [101. 对称二叉树](https://leetcode.com/problems/symmetric-tree/description/)
* 对树进行左右节点交换。注意null不能作为函数传入值。遍历树的复杂度: O(N),空间复杂度：O(N)
### [102. 二叉树的层次遍历](https://leetcode.com/problems/binary-tree-level-order-traversal/description/)
* dfs或者bfs，效率dfs更快一些，时间复杂度均为O(N)，dfs空间复杂度为栈的深度，bfs空间复杂度为O(N)
### [103. 二叉树的锯齿形层次遍历](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/)
* dfs，同上，时间复杂度O(N)
### [104. 二叉树的最大深度](https://leetcode.com/problems/maximum-depth-of-binary-tree/description/)
* dfs，同上，时间复杂度O(N)
### [105. 从前序与中序遍历序列构造二叉树](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/)
* 递归，找到根节点，时间复杂度O(N)，空间复杂度O(N)
### [106. 从中序与后序遍历序列构造二叉树](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/submissions/1)
* 递归，找到根节点，时间复杂度O(N)，空间复杂度O(N)
### [107. 二叉树的层次遍历 II](https://leetcode.com/submissions/detail/172700470/)
* 先求出最大深度，然后遍历方式做下优化即可，时间复杂度均为O(N)，dfs空间复杂度为栈的深度
### [108. 将有序数组转换为二叉搜索树](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/)
* 先构造出树，再采用二叉树中序遍历，复杂度O(N)，空间复杂度O(N)
### [109. 有序链表转换二叉搜索树](https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/)
* 有序链表转为二叉搜索树，时间复杂度O(N)，空间复杂度O(N)
### [110. 检查一个树是否平衡二叉树](https://leetcode-cn.com/problems/balanced-binary-tree/)
* 首先递归计算每个节点作为子树的高度，然后按照平衡二叉树定义，递归判断左子树和右子树高度差不超过1，时间和空间复杂度O(N)
### [111. 二叉树的最小深度](https://leetcode.com/problems/minimum-depth-of-binary-tree/submissions/)
* 递归计算子树最矮高度，时间复杂度O(N)，空间复杂度O(N)
### [114. 二叉树展开为链表](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/)
* 递归题目，先递归处理左子树，再处理右边子树。把左子树（flatten后的）接在root后并把左边设置为null，然后挪到最后，再将右子树（flatten后的）接在末尾。时间复杂度O(N),空间复杂度:O(1)
### [193. grep正则表达式](https://leetcode.com/problems/valid-phone-numbers/description/)
* grep思路比较，但是用sed -nr也能实现此功能，并且sed还能替换整个文本中的字符，用处较广
```sh
grep -E "^(\([0-9]{3}\) ){1}[0-9]{3}-[0-9]{4}$|^([0-9]{3}-){2}[0-9]{4}$" file.txt
sed -nr '/^(\([0-9]{3}\) ){1}[0-9]{3}-[0-9]{4}$|^([0-9]{3}-){2}[0-9]{4}$/p' file.txt
egrep "(\([0-9]{3}\) ){1}[0-9]{3}-[0-9]{4}$|^([0-9]{3}-){2}[0-9]{4}$" file.txt
```
### [201. 数字范围按位与](https://leetcode.com/problems/bitwise-and-of-numbers-range/description/)
* 连续数字按位与，结论如下：
```java
    public int rangeBitwiseAnd(int m, int n) {
        int i = 0;
        while(m != n){
            m >>= 1;
            n >>= 1;
            i++;
        }
        return m << i;
    }
```
### [208. 实现 Trie 前缀树](https://leetcode.com/problems/implement-trie-prefix-tree/description/)
* 前最树的特点是每个字母作为一个节点，实现节点共用，节省存储；查找某个前缀是否存在，或者某个节点是否存在。空间换时间，复杂度为O(N),空间复杂度为O(N*M)
### [210. Course Schedule II](https://leetcode.com/problems/course-schedule-ii/description/)
* 图论题。输出DAG图判断是否有环，如果判断无环输出拓扑序列。每个边遍历一次，每个点遍历一次，故时间复杂度O(N*M)，空间复杂度为O(N*M)
### [211. 添加与搜索单词 - 数据结构设计](https://leetcode.com/problems/add-and-search-word-data-structure-design/description/)
* 字典树+递归。每个单子每个节点至多遍历一次，时间复杂度O(N*len(word))，单词共享节点，空间复杂度O(N*len(word))
### [212. 单词搜索 II](https://leetcode.com/problems/word-search-ii/description/)
* 思路是dfs+字典树。但是解过程中，因为dir问题wa了很久，然后又遇到没有判断删除的次数，导致多删了。解决多删除的方法是用一个Map<String, Integer>计数即可。此题数据量不大，不用删除优化也能暴力解。复杂度建字典树复杂度+搜索复杂度。如果加动态删除字典树优化后，每个单子最多在图里面被搜索一次。所以整体复杂度是O(M*len(word)*SIZE(board))
### [226. 翻转二叉树](https://leetcode.com/problems/invert-binary-tree/submissions/)
* 可用递归的方式，但是要消耗比较大的内存，如何不消耗内存，完成呢？时间复杂度O(N)，空间复杂度O(1)
### [300. 最长上升子序列](https://leetcode.com/problems/longest-increasing-subsequence/submissions/)
* 方法1：动态规划，状态转移方程：`dp[i] = max(dp[i], dp[j] + 1) if j < i and num[j] < num[i]`
* 方法2：构造中间数组，缓存当前状态即可
### [322. 零钱兑换]((https://leetcode.com/problems/coin-change/)
* 动态规划，dp[n] = min(dp[n-coins[1..m]]) + 1, 其中n范围在0...amount, 时间复杂度O(amount*m),空间复杂度O(amount)
### [345. 字符串反转](https://leetcode.com/problems/reverse-vowels-of-a-string/description/)
* 刚开始考虑用substring，出现一次超时，先转charArray后处理
### [367. 判断是不是一个数的开方](https://leetcode.com/problems/valid-perfect-square/description/)
* 直接用二分应该是log(n)的复杂度，然后特判一下left和right的边界，保证没有遗漏的情况
### [504. 七进制数](https://leetcode.com/problems/base-7/submissions/)
* 整数转7进制数，时间复杂度O(logN)，空间复杂度O(logN)
### [784. 字母大小写全排列](https://leetcode.com/problems/letter-case-permutation)
* dfs, 时间复杂度O(调用栈栈深度), 空间复杂度(调用栈深度)
