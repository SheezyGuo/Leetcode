import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


/**
 * Welcome to vivo !
 */

public class Vivo {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        ArrayList<Integer> list = new ArrayList<>(input.length);
        for (int i : input) {
            list.add(i);
        }
        int output = solution(list);
        System.out.println(output);
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    private static int solution(ArrayList<Integer> list) {
        int s = 0, e = 0, i = 0, max = 0, ms = 0, me = 0;
        int len = list.size();
        while (i < len) {
            if (i == 0 || list.get(i).equals(list.get(i + 1))) {
                e++;
                if (e - s > max) {
                    max = e - s;
                    me = e - 1;
                    ms = s;
                }
                i++;
            } else {
                s = i;
                e = i;
                i++;
            }
        }

        // TODO Write your code here

        return 0;
    }
}