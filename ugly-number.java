class Solution {
public:
    bool isUgly(int num) {
        
        int a[] = {2, 3, 5};
        for (int i = 0; i < 3; ++i) {
            while(num % a[i] == 0 && num != 0) num /= a[i];
        }
        return num == 1;
    }
};