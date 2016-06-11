LeetCode OJ
Subscribe
Problems 
Mock 
Articles
Discuss
Book
xiaoqinqiu 
Notes
|||

Type here...(Markdown is enabled)
 
73. Set Matrix Zeroes My Submissions QuestionEditorial Solution
Total Accepted: 68329 Total Submissions: 202527 Difficulty: Medium
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

Subscribe to see which companies asked this question

Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  No
Discuss Pick One

    


1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        if (matrix.size() == 0) return;
        //init
        for (int i = 0; i < matrix.size(); ++i) r[i] = false;
        for (int j = 0; j < matrix[0].size(); ++j) c[j] = false;
        //find
        for (int i = 0; i < matrix.size(); ++i) {
            for (int j = 0; j < matrix[i].size(); ++j) {
                if (matrix[i][j] == 0) {
                    r[i] = true;
                    c[j] = true;
                }
            }
        }
        //set
        for (int i = 0; i < matrix.size(); ++i) {
            for (int j = 0; j < matrix[i].size(); ++j) {
                if (r[i] || c[j]) matrix[i][j] = 0;
            }
        }
    }
private:
    int r[10005];
    int c[10005];
};
Custom Testcase  Run Code  Submit Solution
Submission Result: Accepted More Details 

Next challenges: (H) Word Ladder II  (M) 3Sum Smaller  (M) Wiggle Sort
Share your acceptance!

AddThis Sharing Buttons
Frequently Asked Questions | Terms of Service



Copyright © 2016 LeetCode

Send Feedback