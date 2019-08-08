class 验证IP地址 {
    public String validIPAddress(String IP) {
        if (isIPv4(IP)) {
            return "IPv4";
        }
        if (isIPv6(IP)) {
            return "IPv6";
        }
        return "Neither";
    }

    private boolean isIPv4(String IP) {
        String[] parts = IP.split("\\.");
        if (parts.length != 4) {
            return false;
        }
        if (count(IP, '.') != 3) {
            return false;
        }
        for (String part : parts) {
            if (!checkv4(part)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkv4(String part) {
        if (part == null || part.length() == 0) {
            return false;
        }
        if (part.length() > 3) {
            return false;
        }
        for (char c : part.toCharArray()) {
            if (c > '9' || c < '0') {
                return false;
            }
        }
        if (part.length() > 1 && part.startsWith("0")) {
            return false;
        }
        int num;
        try {
            num = Integer.valueOf(part);
        } catch (NumberFormatException e) {
            return false;
        }
        if (num <= 255 && num >= 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkv6(String part) {
        part = part.toLowerCase();
        if (part == null || part.length() == 0) {
            return false;
        }
        if (part.equals("0")) {
            return true;
        }
        if (part.length() > 4) {
            return false;
        }
        boolean allZero = true;
        for (char c : part.toCharArray()) {
            if (c != '0') {
                allZero = false;
                break;
            }
        }
        if (allZero) {
            return false;
        }
        for (char c : part.toCharArray()) {
            if (!((c <= '9' && c >= '0') || (c <= 'f' && c >= 'a'))) {
                return false;
            }
        }
        return true;
    }

    private boolean isIPv6(String ip) {
        String[] parts = ip.split("\\:");
        if (parts.length != 8) {
            return false;
        }
        if (count(ip, ':') != 7) {
            return false;
        }
        for (String part : parts) {
            if (!checkv6(part)) {
                return false;
            }
        }
        return true;

    }

    private int count(String str, char t) {
        int num = 0;
        for (char c : str.toCharArray()) {
            if (c == t) {
                num++;
            }
        }
        return num;
    }


    public static void main(String[] args) {
        验证IP地址 验证IP地址 = new 验证IP地址();
        验证IP地址.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334::");

    }
}