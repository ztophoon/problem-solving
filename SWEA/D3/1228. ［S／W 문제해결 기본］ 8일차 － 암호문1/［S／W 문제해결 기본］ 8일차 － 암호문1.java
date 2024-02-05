import java.io.*;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {

    public static int testCase = 10;
    public static int N;
    public static int Ops;

    public static LinkedList<Integer> li = new LinkedList<>();

    public static BufferedReader br;
    public static BufferedWriter bw;
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x, y;
        for (int t = 1; t <= testCase; t++) {
            li = new LinkedList<>();
            N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                li.add(Integer.parseInt(st.nextToken()));
            }

            Ops = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            while(Ops-- > 0){
                if (st.nextToken().toCharArray()[0] != 'I'){
                    continue;
                }

                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());

                for(int j = 0; j < y; j++){
                    li.add(x + j, Integer.parseInt(st.nextToken()));
                }
            }

            int cnt = 0;
            bw.write(String.format("#%d ", t));
            for(Integer num : li){
                bw.write(String.format("%d ", num));
                if(++cnt == 10){
                    break;
                }
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
