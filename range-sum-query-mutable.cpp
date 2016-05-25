int a[100005],b[100005];
int n;
class NumArray {
public:
    void updateValue(int x, int val) {
        for(int nx = x; nx <= n; nx += nx&(-nx)) {
            a[nx] += val;
        }
    }
    int getValue(int x) {
        if (x == 0) return 0;
        int sum = 0;
        for (int nx = x; nx > 0; nx -= nx&(-nx)) {
            sum += a[nx];
        }
        return sum;
    }
    NumArray(vector<int> &nums) {
        n = 100000;
        for (int i = 0; i <= n; ++i) {
            a[i] = 0;
        }
        for (int i = 0; i < nums.size(); ++i) {
            b[i+1] = nums[i];
            updateValue(i+1, b[i+1]);
        }
    }

    void update(int i, int val) {
        ++i;
        updateValue(i, -b[i]);
        b[i] = val;
        updateValue(i, val);
    }

    int sumRange(int i, int j) {
        ++i;++j;
        return getValue(j) - getValue(i-1);
    }
};


// Your NumArray object will be instantiated and called as such:
// NumArray numArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);i