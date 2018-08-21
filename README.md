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
### [345. 字符串反转](https://leetcode.com/problems/reverse-vowels-of-a-string/description/)
* 刚开始考虑用substring，出现一次超时，先转charArray后处理
### [367. 判断是不是一个数的开方](https://leetcode.com/problems/valid-perfect-square/description/)
* 直接用二分应该是log(n)的复杂度，然后特判一下left和right的边界，保证没有遗漏的情况
