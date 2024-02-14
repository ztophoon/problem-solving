import java.io.*;
import java.util.*;

public class Solution {

    public static int testCase = 10;

    public static int N;
    public static String [] arr;

    public static BufferedReader br;
    public static BufferedWriter bw;
    public static StringTokenizer st;

    public static boolean isNum(String val) {
        if(val.equals("+") || val.equals("-") || val.equals("*") || val.equals("/")){
            return false;
        } else {
            return true;
        }
    }

    public static int solution() {
        for(int idx = 1; idx <= N; idx++){
            String val = arr[idx];
            if(!isNum(val) && idx * 2 + 1 > N){ // 리프 노드에 연산자가 있는 경우
                return 0;
            }
            if(isNum(val) && idx * 2 + 1 <= N && (isNum(arr[idx * 2]) || isNum(arr[idx * 2 + 1]))){ // 노드의 값이 숫자 인데, 자식 노드도 숫자인 경우
                return 0;
            }
        }
        return 1; // 예외 케이스에 모두 해당하지 않는 경우
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int t = 1; t <= testCase; t++) {

            N = Integer.parseInt(br.readLine());
            arr = new String [4 * N]; // 이진트리를 배열을 통해 구현

            for(int j = 0; j < N; j++){
                st = new StringTokenizer(br.readLine());

                int node = Integer.parseInt(st.nextToken());
                String inp = st.nextToken();

                arr[node] = inp;
            }

            bw.write(String.format("#%d %d\n", t, solution()));
        }
        bw.close();
    }
}
