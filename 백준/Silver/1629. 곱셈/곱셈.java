import java.util.*;
import java.io.*;

public class Main {

    static int A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        System.out.println(calc(B));
    }

    static long calc(int cnt) {
        if (cnt == 1) return A % C;

        long firstHalf = calc(cnt / 2) % C;
        long secondHalf = cnt % 2 == 0 ? firstHalf : (firstHalf * (A % C)) % C;
        return (firstHalf * secondHalf) % C;
    }

}