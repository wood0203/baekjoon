import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N <= 2) {
            System.out.println(N);
            return;
        }

        String[] input = br.readLine().split(" ");
        int[] fruits = new int[input.length];
        for (int i = 0; i < N; i++) {
            fruits[i] = input[i].charAt(0) - '0';
        }

        int[] cnt = new int[10];
        int start = 0;
        cnt[fruits[start]]++;
        int end = 1;
        int answer = 2;
        int typeCnt = 1;
        while (end < fruits.length) {
            int fruit = fruits[end];
            if (typeCnt == 2 && cnt[fruit] == 0) {
                cnt[fruits[start]]--;
                if (cnt[fruits[start++]] == 0) typeCnt--;
                continue;
            }

            if (cnt[fruit] == 0) typeCnt++;
            cnt[fruit]++;
            answer = Integer.max(end++ - start + 1, answer);
        }

        System.out.println(answer);
    }
}