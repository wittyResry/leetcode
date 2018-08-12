#include<algorithm>
const int M = 100005;
struct Node {
    int y;
    int x;
}st[M];
int vis[M];
bool cmp(Node a, Node b) {
    if (a.y != b.y) return a.y < b.y;
    return a.x < b.x;
}
class Solution {
public:
    int maxArea(vector<int>& a) {
        int n = a.size();
        for (int i = 0; i < M; ++i) vis[i] = 0;
        for (int i = 0; i < n; ++i) {
            st[i].y = a[i];
            st[i].x = i+1;
        }
        sort(st, st+n, cmp);
        int mi = 1, ma = n;
        int res = 0;
        for (int i = 0; i < n; ++i)  {
            int pos_x = st[i].x;
            int pos_y = st[i].y;
            int delt1 = (pos_x - mi);
            int delt2 = (ma - pos_x);
            int container1 = delt1 * pos_y;
            int container2 = delt2 * pos_y;
            if (container1 > res) res = container1;
            if (container2 > res) res = container2;
            {
                vis[pos_x] = 1;
                while (vis[mi] == 1) ++mi;
                while (vis[ma] == 1) --ma;
            }
        }
        return res;
    }
};