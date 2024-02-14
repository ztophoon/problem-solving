import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int [] arr;

    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int solution() throws IOException {
        int answer = 0;

        int [] dp = new int [N];
        for(int i = 0; i < N; i++){
            int cnt = 0;
            for(int j = 0; j <= i; j++){
                if(arr[j] < arr[i] && cnt < dp[j]){
                    cnt++;
                }
            }
            dp[i] = cnt + 1;
            answer = Math.max(dp[i], answer);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int [N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(solution() + "");
        bw.close();
    }
}
