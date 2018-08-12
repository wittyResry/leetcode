import java.util.LinkedList;
import java.util.List;

public class CombinationSumIii {
    void dfs(int k, int n, int deep, int sum, LinkedList<Integer> tmp, List<List<Integer>> res) {
        if (deep > k || sum > n) return;
        if (deep == k && sum == n) {
            List<Integer> r = new LinkedList<Integer>();
            for (Integer it:tmp) {
                r.add(it);
            }
            res.add(r);
        }
        int begin = (tmp.size() > 0?tmp.getLast()+1:1);
        for (int i = begin; i <= 9; ++i) {
            tmp.addLast(i);
            dfs(k, n, deep + 1, sum + i, tmp, res);
            tmp.removeLast();
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        LinkedList<Integer> tmp = new LinkedList<Integer>();
        dfs(k, n, 0, 0, tmp, res);
        return res;
    }
}
