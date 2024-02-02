import java.io.IOException;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class Solution {
    public static int solution(int N, int M){

        int bit = (1 << N) - 1;

        if((M & bit) == bit){
            return 0;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] ans = new String [] {"ON", "OFF"};
        int T = Integer.parseInt(br.readLine());

        int N, M;
        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            System.out.printf("#%d %s\n", t, ans[solution(N, M)]);
        }
    }
}
