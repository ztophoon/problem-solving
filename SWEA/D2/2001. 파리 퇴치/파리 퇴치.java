import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    public static int testCase;
    public static int N;
    public static int M;
    public static int [][] flyes;

    public static BufferedReader br;
    public static BufferedWriter bw;
    public static StringTokenizer st;

    public static int solution() {
        int sum, max = 0;

        for(int r = 0; r < N; r++){
            for(int c = 0; c < N; c++){
                if(r < M - 1 | c < M - 1){
                    continue;
                }

                sum = 0;
                for(int rr = r - M + 1; rr <= r; rr++){
                    for(int cc = c - M + 1; cc <= c; cc++){
                        sum += flyes[rr][cc];
                    }
                }

                max = max < sum ? sum : max;
            }
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            flyes = new int [N][N];
            for(int r = 0; r < N; r++){
                st = new StringTokenizer(br.readLine());
                for(int c = 0; c < N; c++){
                    flyes[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            bw.write(String.format("#%d %d\n", t, solution()));
        }

        bw.flush();
        bw.close();
    }
}
