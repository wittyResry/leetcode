
/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Qingyu Li
 * @since 2018/08/18
 */
public class CourseScheduleII {
    List<Integer>[] g;
    int             in[];
    int             res[];

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        g = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            g[i] = new ArrayList<>();
        }
        in = new int[numCourses];
        for (int i = 0; i < prerequisites.length; ++i) {
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];
            g[u].add(v);
            in[v]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (in[i] == 0) {
                queue.offer(i);
            }
        }
        res = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            if (queue.isEmpty()) {
                return new int[0];
            }
            int k = queue.poll();
            for (int j = 0; j < g[k].size(); ++j) {
                int val = g[k].get(j);
                if (--in[val] == 0) {
                    queue.offer(val);
                }
            }
            res[i] = k;
        }
        return res;
    }
}
