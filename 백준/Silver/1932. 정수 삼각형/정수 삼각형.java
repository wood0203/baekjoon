import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> nums = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            nums.add(new ArrayList<>());
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                int num = Integer.parseInt(st.nextToken());
                int sum = 0;
                if (j > 0) {
                    sum = Integer.max(sum, nums.get(i - 1).get(j - 1));
                }
                if (j < i) {
                    sum = Integer.max(sum, nums.get(i - 1).get(j));
                }
                nums.get(i).add(sum + num);
                answer = Integer.max(answer, sum + num);
            }
        }

        System.out.println(answer);
    }

}