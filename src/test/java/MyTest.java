
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

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Qingyu Li
 * @since 2018/08/31
 */
public class MyTest {
    public static final Logger LOGGER = LoggerFactory.getLogger(MyTest.class);

    @Test
    public void test1() {
        Object o = null;
        newInstance(o);
        Assert.assertEquals("", null, o);
    }

    private void newInstance(Object o) {
        if (o == null) {
            o = new Object();
        }
    }

    @Test
    public void test2() {
        Map<String, String> m = new ConcurrentHashMap<>();
        Throwable result1 = null;
        try {
            m.put("", null);
        } catch (Throwable e) {
            result1 = e;
        }
        Assert.assertEquals("test put value null", true, result1 instanceof NullPointerException);
        Throwable result2 = null;
        try {
            m.get(null);
        } catch (Throwable e) {
            result2 = e;
        }
        Assert.assertEquals("test get key null", true, result2 instanceof NullPointerException);
    }
}
