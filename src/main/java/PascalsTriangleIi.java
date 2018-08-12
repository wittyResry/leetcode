import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleIi {
    //1           1
    //121         2
    //1331        3
    //14641       4
    //15101051    5
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            res.add(1);
            for (int j = i-1; j > 0; j--) {
                res.set(j, res.get(j) + res.get(j-1));
            }
        }
        return res;
    }
}
