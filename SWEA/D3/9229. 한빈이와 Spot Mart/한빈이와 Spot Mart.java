import java.io.*;
import java.util.*;

public class Solution {

    public static int N, M;
    public static int [] ws;

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int solution() {
        int l = 0;
        int r = N - 1;

        int ans = -1;
        int now;

        while(l < r) {
            now = ws[l] + ws[r];
            if(now <= M){
                ans = Math.max(ans, now);
            }

            if(now > M){
                r--;
            } else if (now < M){
                l++;
            } else {
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {

        int tc = Integer.parseInt(br.readLine());

        for(int t = 1; t <= tc; t++){

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            ws = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                ws[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(ws);

            bw.write(String.format("#%d %d\n", t, solution()));
        }

        bw.flush();
        bw.close();
    }

}
