import java.io.*;
import java.util.*;

public class Main {

    public static int N, L;
    public static int [] arr;

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int solution() throws IOException {
        Arrays.sort(arr);

        int now = L;
        for(int i = 0; i < N; i++){
            if(arr[i] <= now){
                now++;
            } else {
                break;
            }
        }

        return now;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        arr = new int [N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(solution() + "");
        bw.close();
    }
}
