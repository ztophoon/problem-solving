import java.io.*;
import java.util.*;

public class Main {

    public static int N, M;
    public static int totalSum;
    public static int [] inp;

    public static int max = Integer.MIN_VALUE;

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int solution() throws IOException {

        int left = max;
        int right = totalSum;

        int mid = 0, cnt, sum;
        while(left <= right) {
            mid = (right + left) / 2;

            cnt = 0;
            sum = 0;

            for (int n : inp){
                if(sum + n > mid){
                    cnt++;
                    sum = 0;
                }
                sum += n;
            }
            if (sum > 0) {
                cnt++;
            }

            if (M >= cnt) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        inp = new int [N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            inp[i] = Integer.parseInt(st.nextToken());

            totalSum += inp[i];
            max = Math.max(max, inp[i]);
        }

        bw.write(solution() + "");

        bw.flush();
        bw.close();
    }
}
