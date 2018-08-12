class SegmentTreeSumNode {
public:
    int sum;
    SegmentTreeSumNode *negibor[4] = {NULL, NULL, NULL, NULL};
    pair<int, int> leftTop = make_pair(0, 0);
    pair<int, int> rightBottom = make_pair(0, 0);
    SegmentTreeSumNode(int sum) : sum(sum){}
};

class Solution {
    SegmentTreeSumNode* root;
    vector<vector<int>> nums;
public:
    NumMatrix(vector<vector<int>> &matrix) {
        if(matrix.empty()) return;
        nums = matrix;
        int m = matrix.size(), n = matrix[0].size();
        if(!m || !n) return;
        root = buildSegmentTree(matrix, make_pair(0,0), make_pair(m-1, n-1));
    }

    void update(int row, int col, int val) {
        int diff = val - nums[row][col];
        if(!diff) return;
        nums[row][col] = val;
        update(row, col, diff, root);
    }

    int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        if(root) sumRange(row1, col1, row2, col2, root, res);
        return res;
    }
    SegmentTreeSumNode* buildSegmentTree(vector<vector<int>>& matrix, pair<int, int> start, pair<int , int> end){
        if(start.first > end.first || start.second > end.second) return NULL;
        SegmentTreeSumNode* node = new SegmentTreeSumNode(0);
        node->leftTop = start;
        node->rightBottom = end;
        if(start == end){
            node->sum = matrix[start.first][start.second];
            return node;
        }
        int midx = (start.first + end.first)/2;
        int midy = (start.second + end.second)/2;
        node->negibor[0] = buildSegmentTree(matrix, start, make_pair(midx, midy));
        node->negibor[1] = buildSegmentTree(matrix, make_pair(start.first, midy+1), make_pair(midx, end.second));
        node->negibor[2] = buildSegmentTree(matrix, make_pair(midx + 1, start.second), make_pair(end.first, midy));
        node->negibor[3] = buildSegmentTree(matrix, make_pair(midx+1, midy+1), end);
        for (int i = 0; i<4; ++i) {
            if(node->negibor[i]) node->sum += node->negibor[i]->sum;
        }
        return node;
    }

    void update(int row, int col, int diff, SegmentTreeSumNode* node){
        if(row >= (node->leftTop).first && row <= (node->rightBottom).first && col >= (node->leftTop).second && col <= (node->rightBottom).second){
            node->sum += diff;
            for (int i = 0; i<4; ++i) {
                if(node->negibor[i]) update(row, col, diff, node->negibor[i]);
            }
        }
    }

    void sumRange(int row1, int col1, int row2, int col2, SegmentTreeSumNode* node, int& res){
        pair<int, int> start = node->leftTop;
        pair<int, int> end = node->rightBottom;
        int top = max(start.first, row1);
        int bottom = min(end.first, row2);
        if(bottom < top) return;
        int left = max(start.second, col1);
        int right = min(end.second, col2);
        if(left > right) return;
        if(row1 <= start.first && col1 <= start.second && row2 >= end.first && col2 >= end.second){
            res += node->sum;
            return;
        }
        for (int i = 0; i<4; ++i) {
            if(node->negibor[i]) sumRange(row1, col1, row2, col2, node->negibor[i], res);
        }
    }
};

// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);
