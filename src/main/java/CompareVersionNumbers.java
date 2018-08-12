public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        if (version1.equals(version2)) return 0;
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < v1.length && i < v2.length; ++i) {
            Integer t1 = new Integer(v1[i]);
            Integer t2 = new Integer(v2[i]);
            if (t1 < t2) {
                return -1;
            } else if (t1 > t2) {
                return 1;
            } else {
                continue;
            }
        }
        if (v1.length == v2.length) return 0;
        if (v1.length > v2.length) {
            int flag = 0;
            for (int i = v2.length; i < v1.length; ++i) {
                Integer t = new Integer(v1[i]);
                if (t != 0) flag = 1;
            }
            return flag;
        } else {
            int flag = 0;
            for (int i = v1.length; i < v2.length; ++i) {
                Integer t = new Integer(v2[i]);
                if (t != 0) flag = -1;
            }
            return flag;
        }
    }
}
