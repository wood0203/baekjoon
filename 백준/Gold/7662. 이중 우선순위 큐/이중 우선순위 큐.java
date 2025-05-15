
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int testCase = 0; testCase < T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            HashMap<Integer, Integer> cnt = new HashMap<>();
            PriorityQueue<Integer> minQueue = new PriorityQueue<>();
            PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                String command = input[0];
                int value = Integer.parseInt(input[1]);
                if (command.equals("I")) {
                    minQueue.offer(value);
                    maxQueue.offer(value);
                    cnt.put(value, cnt.getOrDefault(value, 0) + 1);
                    continue;
                } 
                else {
                	if (value == 1) {
                        while (!maxQueue.isEmpty()) {
                            int top = maxQueue.poll();
                            if (cnt.get(top) == 0) continue;
                            else {
                            	cnt.put(top, cnt.get(top) - 1);
                            	break;
                            }
                        }
                    } else {
                        while (!minQueue.isEmpty()) {
                            int top = minQueue.poll();
                            if (cnt.get(top) == 0) continue;
                            else {
                            	cnt.put(top, cnt.get(top) - 1);
                            	break;
                            }
                        }
                    }
                }
            }
            
            // 최종 정답 도출
            int answer = 0;
            while (!maxQueue.isEmpty() && cnt.get(maxQueue.peek()) == 0) {
                maxQueue.poll();
            }

            if (maxQueue.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                answer = maxQueue.peek();
                while (!minQueue.isEmpty() && cnt.get(minQueue.peek()) == 0) {
                    minQueue.poll();
                }
                
                sb.append(answer).append(" ").append(minQueue.peek()).append("\n");
            }
            
        }
        System.out.println(sb.toString());

    }

}