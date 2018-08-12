### (193. grep正则表达式)[https://leetcode.com/problems/valid-phone-numbers/description/]
* grep思路比较，但是用sed -nr也能实现此功能，并且sed还能替换整个文本中的字符，用处较广
### (345. 字符串反转)[https://leetcode.com/problems/reverse-vowels-of-a-string/description/]
* 刚开始考虑用substring，出现一次超时，先转charArray后处理
### (367. 判断是不是一个数的开方)[https://leetcode.com/problems/valid-perfect-square/description/]
* 直接用二分应该是log(n)的复杂度，然后特判一下left和right的边界，保证没有遗漏的情况
