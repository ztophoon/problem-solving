import java.io.*;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static int N, numCards;

    public static boolean isChulsooWin(int [] cards){
        int cWin = 0, sWin = 0;

        for(int i = 0; i < numCards; i++){
            if ((i + 1) % 2 == 1 && cards[i] == 1) {
                cWin++;
            }
            if ((i + 1) % 2 == 0 && cards[i] == 1) {
                sWin++;
            }
        }

        return cWin > sWin;
    }

    public static int [] tazza(int [] cards, int pae){
        if(pae == 0){
            return cards;
        } else {
            int [] newCards = Arrays.copyOf(cards, cards.length);

            int mitZzang = newCards[pae];
            for(int i = 1; i <= pae; i++){
                newCards[i] = cards[i - 1];
            }
            newCards[0] = mitZzang;

            return newCards;
        }
    }

    public static int bfs(int [] cards){

        Queue<int []> q = new LinkedList<>();
        int [] nowCards, newCards;

        q.offer(cards);

        while(!q.isEmpty()){
            nowCards = q.poll();

            for(int i = 1; i < numCards; i++){
                newCards = tazza(nowCards, i);

                if(isChulsooWin(newCards)){
                    return newCards[numCards];
                } else {
                    newCards[numCards]++;
                    q.offer(newCards);
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        numCards = N * 2;
        int [] cards = new int [numCards + 1];

        char[] next;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N * 2; i++){
            next = st.nextToken().toCharArray();

            if(next[0] == 'O') {
                cards[i] = 1;
            } else {
                cards[i] = 0;
            }
        }
        cards[numCards] = 1;

        bw.write(isChulsooWin(cards) ? "0" : "" + bfs(cards));
        bw.newLine();

        bw.flush();
        bw.close();
    }
}
