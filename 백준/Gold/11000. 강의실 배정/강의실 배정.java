import java.io.*;
import java.util.*;

public class Main {

    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int N, answer;

    public static PriorityQueue<int []> timesPQ = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] < o2[0]) {
                    return -1;
                }
                if (o1[0] > o2[0]) {
                    return 1;
                }
                if (o1[1] < o2[1]) {
                    return -1;
                }
                return 1;
            }
        }
    );
    public static PriorityQueue<Integer> endTimesPQ = new PriorityQueue<>();

    public static void solution() {
        while(!timesPQ.isEmpty()){
            int [] sAndT = timesPQ.poll();
            int start = sAndT[0];
            int termi = sAndT[1];

            if(!endTimesPQ.isEmpty() && endTimesPQ.peek() <= start){
                endTimesPQ.poll();
            } else {
                answer++;
            }
            // endTimesPQ.add(termi);
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            timesPQ.offer(new int [] {s, t});
            endTimesPQ.offer(t);
        }

        solution();

        bw.write(Integer.toString(answer));
        bw.close();
    }
}
