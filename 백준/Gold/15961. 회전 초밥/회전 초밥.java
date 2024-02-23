import java.io.*;
import java.util.*;

public class Main {

    public static int N, D, K, C, answer;
    public static int sushiCnt, noEventSushiIn;
    public static int [] isSushiIn;
    
    public static Queue<Integer> sushiQ = new ArrayDeque<>();
    public static Queue<Integer> savedQ = new ArrayDeque<>();

    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void rolling(int n, int sushi){
        if(sushi == C){
            noEventSushiIn = 0;
        }

        if(isSushiIn[sushi] == 0){
            sushiCnt++;
        }
        sushiQ.add(sushi);
        isSushiIn[sushi]++;

        if(n < K){
            savedQ.add(sushi);
            return;
        }

        answer = Math.max(answer, sushiCnt + noEventSushiIn);

        int outSushi = sushiQ.poll();
        isSushiIn[outSushi]--;

        if(isSushiIn[outSushi] == 0){
            sushiCnt--;
        }
        if(isSushiIn[C] == 0){
            noEventSushiIn = 1;
        }
    }

    public static void solution() throws IOException {
        int rollNum;
        for(rollNum = 1; rollNum <= N; rollNum++){
            int sushi = Integer.parseInt(br.readLine());
            rolling(rollNum, sushi);
        }

        for(int savedSushi : savedQ){
            rolling(rollNum++, savedSushi);
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        noEventSushiIn = 1;
        isSushiIn = new int [D+1];

        solution();

        bw.write(answer + "");
        bw.close();
    }
}
