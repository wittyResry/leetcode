import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    private Map<Integer, Integer> mp = new HashMap<Integer, Integer>();

    public List<Integer> topKFrequent(int[] nums, int k) {
        mp.clear();
        for (int i = 0; i < nums.length; ++i) {
            if (mp.containsKey(nums[i])) {
                mp.put(nums[i], mp.get(nums[i]) + 1);
            } else {
                mp.put(nums[i], 1);
            }
        }
        Node[] st = new Node[mp.size()];
        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            Node node = new Node();
            node.num = entry.getKey();
            node.times = entry.getValue();
            st[cnt++] = node;
        }
        Arrays.sort(st, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.times != o2.times ? o2.times - o1.times : o1.num - o2.num;
            }
        });
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < cnt && i < k; ++i) {
            res.add(st[i].num);
        }
        return res;
    }

    class Node {
        public int num;
        public int times;
    }

    public void main() {
        int[] nums = new int[] { 1, 1, 1, 2, 2, 3 };
        int k = 2;
        System.out.println(new TopKFrequentElements().topKFrequent(nums, k));
    }

    public static void main(String[] args) {
        new TopKFrequentElements().main();
    }
}
