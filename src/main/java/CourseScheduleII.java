
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
import java.util.List;

/**
 * @author Qingyu Li
 * @since 2018/08/18
 */
public class CourseScheduleII {
    List<Integer>[] t;
    int             in[];
    boolean         vis[];
    int             res[];

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        t = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            t[i] = new ArrayList<>();
        }
        in = new int[numCourses];
        for (int i = 0; i < prerequisites.length; ++i) {
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];
            t[u].add(v);
            in[v]++;
        }
        vis = new boolean[numCourses];
        res = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            int k = -1;
            for (int j = 0; j < numCourses; ++j) {
                if (in[j] == 0 && !vis[j]) {
                    k = j;
                }
            }
            if (k == -1) {
                return new int[0];
            }
            vis[k] = true;
            for (int j = 0; j < t[k].size(); ++j) {
                --in[t[k].get(j)];
            }
            res[i] = k;
        }
        return res;
    }
}
