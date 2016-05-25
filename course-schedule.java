public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        int[] in = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            lists.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; ++i) {
            ++in[prerequisites[i][0]];
            lists.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; ++i) {
            if (in[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i : lists.get(cur)) {
                if ((--in[i]) == 0) {
                    queue.offer(i);
                }
            }
        }
        for (int i = 0; i < numCourses; ++i) {
            if (in[i] != 0) return false;
        }
        return true;
    }
}