public class 比较版本 {
    public static int compareVersion(String version1, String version2) {
        String[] parts1 = version1.split(".");
        String[] parts2 = version2.split(".");
        int minlen = Math.min(parts1.length, parts2.length);
        for (int i = 0; i < minlen; i++) {
            int n1 = Integer.parseInt(parts1[i]);
            int n2 = Integer.parseInt(parts2[i]);
            if (n1 != n2) {
                return n1 > n2 ? 1 : -1;
            }
        }
        if (parts1.length > minlen) {
            for (int i = minlen; i < parts1.length; i++) {
                int n = Integer.parseInt(parts1[i]);
                if (n != 0) {
                    return 1;
                }
            }
        } else if (parts2.length > minlen) {
            for (int i = minlen; i < parts2.length; i++) {
                int n = Integer.parseInt(parts2[i]);
                if (n != 0) {
                    return -1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("0.1", "1.1"));
    }
}
