import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int N, M;
    public static int start, end;

    public static int [] nums;
    public static int [] sums;

    public static StringBuilder sb; // 결과를 저장할 StringBuilder
    public static BufferedReader br; // 결과를 저장할 StringBuilder
    public static BufferedWriter bw; // 결과를 출력하기 위한 BufferedWriter
    public static StringTokenizer st; // 결과를 출력하기 위한 BufferedWriter

    public static void solution() throws Exception {
        int ans = 0;

        if(start - 1 < 0){
            ans = sums[end];
        } else {
            ans = sums[end] - sums[start - 1];
        }

        sb.append(ans).append("\n");
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 받기 위한 버퍼리더
        bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 결과를 출력하기 위한 버퍼라이터
        sb = new StringBuilder(); // 결과를 저장할 StringBuilder 초기화

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        sums = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());

            if(i > 0){
                sums[i] = sums[i-1] + nums[i];
            } else {
                sums[i] = nums[i];
            }
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken()) - 1;
            end = Integer.parseInt(st.nextToken()) - 1;

            solution();
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
