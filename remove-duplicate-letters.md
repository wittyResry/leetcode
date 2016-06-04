```
Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Example:
Given "bcabc"
Return "abc"

Given "cbacdcbc"
Return "acdb"
思路：
如果当前的字符没“访问”过，且它比放入res中的已“访问”过的字符要小，并且那些已在res最后的一个字符还有后续储备，说明使用当前的这个替代res最后一个更优。可以扔掉res最后的这个字符，并且更新vis数组为“未访问”，等待后续从储备中拿。
```