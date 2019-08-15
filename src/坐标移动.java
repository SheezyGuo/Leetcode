import java.util.Scanner;

public class 坐标移动 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] parts = line.split(";");
            int x = 0, y = 0;
            for (String p : parts) {
                if (p.matches("[WASD]\\d+")) {
                    switch (p.charAt(0)) {
                        case 'W':
                            y += Integer.parseInt(p.substring(1));
                            break;
                        case 'S':
                            y -= Integer.parseInt(p.substring(1));
                            break;
                        case 'A':
                            x -= Integer.parseInt(p.substring(1));
                            break;
                        case 'D':
                            x += Integer.parseInt(p.substring(1));
                            break;
                    }
                }
            }
            System.out.println(String.format("%d,%d", x, y));
        }
    }
}
