import java.io.*;
import java.util.*;

public class Main {

    public static int N, M, answer;
    public static int [][] play;

    public static int [] roster;
    public static String rosterStr;

    public static int [] base;

    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void hit(int run){
        for(int i = 3; i >= 1; i--){
            if(base[i] == 0){
                continue;
            }

            if(i + run >= 4){
                base[0]++;
                base[i] = 0;
                continue;
            }

            base[i + run] = 1;
            base[i] = 0;
        }

        base[run] = 1;
    }

    public static void homerun(){
        for(int i = 1; i <= 3; i++){
            base[0] += base[i];
            base[i] = 0;
        }
        base[0] += 1; // 타자 홈인
    }

    public static void baseball(){
        int score = 0;
        int hitterOrder = 0;

        for(int inning = 0; inning < N; inning++){
            int [] nowInning = play[inning];
            base = new int [4];

            int out = 0;
            while(out < 3){
                int hitterPlay = nowInning[roster[hitterOrder++ % 9] - 1];

                if(hitterPlay == 0){
                    out++;
                } else if(hitterPlay == 4){
                    homerun();
                } else {
                    hit(hitterPlay);
                }
            }

            score += base[0];
        }

        answer = Math.max(answer, score);
    }

    public static void getPlayers(int cnt) {
        if (cnt == 9) {
            char[] arr = rosterStr.toCharArray();
            for (int i = 0; i < 9; i++) {
                roster[arr[i] - '0' - 1] = i + 1;
            }

            baseball();
            return;
        }

        String oriRoster = rosterStr;
        for (int i = 1; i <= 9; i++) {
            if (rosterStr.contains(Integer.toString(i))) {
                continue;
            }

            rosterStr += Integer.toString(i);
            getPlayers(cnt + 1);
            rosterStr = oriRoster;
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        play = new int [N][9];
        roster = new int [9];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++){
                play[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rosterStr = "4";
        getPlayers(1);

        bw.write(Integer.toString(answer));
        bw.close();
    }
}
