import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            HashSet<String> set = new HashSet<>();
            int N = Integer.parseInt(br.readLine());
            ArrayList<String> arr = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                String number = br.readLine();
                arr.add(number);
            }

            Collections.sort(arr);
            boolean isCant = false;
            for (int j = 0; j < N; j++) {
                String number = arr.get(j);
                String temp = "";
                for (char n: number.toCharArray()) {
                    temp += n;
                    if (set.contains(temp)) {
                        isCant = true;
                        break;
                    }
                }

                if (!isCant) {
                    set.add(temp);
                }
            }

            if (isCant) {
                sb.append("NO").append("\n");
            } else {
                sb.append("YES").append("\n");
            }
        }

        sb.setLength(sb.length() - 1);
        System.out.println(sb.toString());
    }
}