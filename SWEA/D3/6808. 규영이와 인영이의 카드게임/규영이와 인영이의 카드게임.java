import java.io.*;
import java.util.*;

public class Solution {

    public static BufferedReader br;
    public static BufferedWriter bw;
    public static StringTokenizer st;

    public static int testCase;

    public static int win, lose;
    public static int [] cards, kCard, iCard, used;

    public static void solution(int depth, int kScore, int iScore) {
        if(depth == 9){
            if (kScore > iScore){
                win++;
            } else if (kScore < iScore) {
                lose++;
            }
        } else {
            for(int i = 0; i < 9; i++){
                if(used[i] == 1){
                    continue;
                }

                int kNewScore = kScore, iNewScore = iScore;
                if(kCard[depth] > iCard[i]){
                    kNewScore += (kCard[depth] + iCard[i]);
                } else if (kCard[depth] < iCard[i]){
                    iNewScore += (kCard[depth] + iCard[i]);
                }

                used[i] = 1;
                solution(depth + 1, kNewScore, iNewScore);
                used[i] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            win = 0;
            lose = 0;

            cards = new int [19];
            kCard = new int [9];
            iCard = new int [9];
            used = new int [9];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 9; i++){
                kCard[i] = Integer.parseInt(st.nextToken());
                cards[kCard[i]] = 1;
            }

            int idx = 0;
            for(int i = 1; i <= 18; i++){
                if(cards[i] == 0) {
                    iCard[idx++] = i;
                }
            }

            solution(0, 0, 0);

            bw.write(String.format("#%d %d %d\n", t, win, lose));
        }

        bw.close();
    }
}
