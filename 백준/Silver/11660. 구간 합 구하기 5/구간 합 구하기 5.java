import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;

    public static int startR, startC, endR, endC;
    public static int cornerR, cornerC;

    public static int[][] sums;
    
    public static StringBuilder sb;
    public static BufferedReader br;
    public static BufferedWriter bw;
    public static StringTokenizer st;

    public static void solution() throws Exception {
        int ans = sums[endR][endC];
        int subCnt = 0;

        if (startR > 1 || startC > 1) {
            if(cornerR > 0) {
                ans -= sums[cornerR][endC];
                subCnt++;
            }
            if(cornerC > 0){
                ans -= sums[endR][cornerC];
                subCnt++;
            }
            if(subCnt == 2){
                ans += sums[cornerR][cornerC];
            }
        }

        sb.append(ans).append("\n");
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()) + 1;
        M = Integer.parseInt(st.nextToken()) + 1;

        sums = new int[N][N];

        int num;
        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N; j++) {
                num = Integer.parseInt(st.nextToken());

                sums[i][j] = sums[i][j-1] + sums[i-1][j] - sums[i-1][j-1] + num;
            }
        }

        for (int i = 0; i < M - 1; i++) {
            st = new StringTokenizer(br.readLine());

            startR = Integer.parseInt(st.nextToken());
            startC = Integer.parseInt(st.nextToken());
            endR = Integer.parseInt(st.nextToken());
            endC = Integer.parseInt(st.nextToken());

            cornerR = startR - 1;
            cornerC = startC - 1;

            solution();
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
