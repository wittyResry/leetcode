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
import java.util.Collections;
import java.util.List;

/**
 * @author Qingyu Li
 * @since 2019/03/24
 */
public class PartitionArrayIntoThreePartsWithEqualSum {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            list.add(A[i]);
        }
        int part_sum = sum / 3;
        if (sum % 3 == 0) {
            for (int time = 0; time < 2000; time++) {
                if (solve(list, part_sum)) {
                    return true;
                }
                Collections.shuffle(list);
            }
            return false;
        } else {
            return false;
        }
    }
    private boolean solve(List<Integer> list, int part_sum) {
        int n = list.size();
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < n; i++) {
            if (a < part_sum) a += list.get(i);
            else if (b < part_sum) b += list.get(i);
            else c += list.get(i);
        }
        return a == b && b == c;
    }
}
