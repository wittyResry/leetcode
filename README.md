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
### [345. 字符串反转](https://leetcode.com/problems/reverse-vowels-of-a-string/description/)
* 刚开始考虑用substring，出现一次超时，先转charArray后处理
### [367. 判断是不是一个数的开方](https://leetcode.com/problems/valid-perfect-square/description/)
* 直接用二分应该是log(n)的复杂度，然后特判一下left和right的边界，保证没有遗漏的情况
### [504. 七进制数](https://leetcode.com/problems/base-7/submissions/)
* 整数转7进制数，时间复杂度O(logN)，空间复杂度O(logN)
### [784. 字母大小写全排列](https://leetcode.com/problems/letter-case-permutation)
* dfs, 时间复杂度O(调用栈栈深度), 空间复杂度(调用栈深度)
