import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int answer = Integer.MAX_VALUE;

    public static int [] sour;
    public static int [] bitter;
    public static int [] visited;

    public static int nowSour;
    public static int nowBitter;

    public static BufferedReader br;
    public static StringTokenizer st;

    public static void combination(int idx, int numPick, int cntPick) {
        if (cntPick == numPick){
            answer = Math.abs(nowSour - nowBitter) < answer ? Math.abs(nowSour - nowBitter) : answer;
        } else {
            for(int i = idx; i < N; i++){
                if (visited[i] == 0){
                    visited[i] = 1;
                    nowSour *= sour[i];
                    nowBitter += bitter[i];

                    combination(i, numPick, cntPick + 1);

                    nowBitter -= bitter[i];
                    nowSour /= sour[i];
                    visited[i] = 0;
                }
            }
        }
    }

    public static void solution() throws Exception {
        for(int n = 1; n <= N; n++){
            combination(0, n, 0);
        }
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        sour = new int[N];
        bitter = new int[N];
        visited = new int[N];

        nowSour = 1;
        nowBitter = 0;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            sour[i] = Integer.parseInt(st.nextToken());
            bitter[i] = Integer.parseInt(st.nextToken());
        }

        solution();

        System.out.println(answer);
    }
}
