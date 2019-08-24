import java.util.LinkedList;

public class 字节流第一个不重复的 {


    private static int[] counts = new int[128];
    private static LinkedList<Character> list = new LinkedList<>();

    //Insert one char from stringstream
    public static void Insert(char ch) {
        counts[ch]++;
        if (counts[ch] == 1) {
            list.add(ch);
        } else if (counts[ch] == 2) {
            list.remove(Character.valueOf(ch));
        }
    }

    //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce() {
        if (list.size() == 0) {
            return '#';
        } else {
            return list.get(0);
        }
    }

    public static void main(String[] args) {
        String s = "google";
        for (int i = 0; i < s.length(); i++) {
            Insert(s.charAt(i));
            System.out.print(FirstAppearingOnce());
        }
    }
}
