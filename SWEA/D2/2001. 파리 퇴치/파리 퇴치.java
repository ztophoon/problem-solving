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
        int sum, subCnt, max = 0;

        for(int r = 1; r <= N; r++){
            for(int c = 1; c <= N; c++){
                if(r < M | c < M){
                    continue;
                }

                subCnt = 0;
                sum = flyes[r][c];
                if (r - M > 0) {
                    sum -= flyes[r - M][c];
                    subCnt++;
                }
                if (c - M > 0) {
                    sum -= flyes[r][c - M];
                    subCnt++;
                }
                if (subCnt == 2){
                    sum += flyes[r - M][c - M];
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

            flyes = new int [N + 1][N + 1];
            for(int r = 1; r <= N; r++){
                st = new StringTokenizer(br.readLine());
                for(int c = 1; c <= N; c++){
                    flyes[r][c] = flyes[r][c-1] + flyes[r-1][c] - flyes[r-1][c-1] + Integer.parseInt(st.nextToken());
                }
            }

            bw.write(String.format("#%d %d\n", t, solution()));
        }

        bw.flush();
        bw.close();
    }
}
