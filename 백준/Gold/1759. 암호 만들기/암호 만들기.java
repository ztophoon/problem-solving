import java.io.*;
import java.util.*;

public class Main {

    public static int L, C;

    public static int jaIdx, moIdx;
    public static char [] ja, mo;
    public static int [] nowJa, nowMo;

    public static ArrayList<String> passwords = new ArrayList<>();

    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void password(){
        sb = new StringBuilder();

        for(int i = 0; i < jaIdx; i++){
            if(nowJa[i] == 1){
                sb.append(ja[i]);
            }
        }

        for(int i = 0; i < moIdx; i++){
            if(nowMo[i] == 1){
               sb.append(mo[i]);
            }
        }

        char [] pw = sb.toString().toCharArray();
        Arrays.sort(pw);

        passwords.add(String.valueOf(pw));
    }

    public static void getJa(int jaCnt, int cnt, int idx){
        if(cnt == jaCnt){
            password();
            return;
        }

        for(int i = idx + 1; i < jaIdx; i++){
            nowJa[i] = 1;
            getJa(jaCnt, cnt + 1, i);
            nowJa[i] = 0;
        }
    }

    public static void getMo(int moCnt, int cnt, int idx){
        if(cnt == moCnt){
            getJa(L - moCnt, 0, -1);
            return;
        }

        for(int i = idx + 1; i < moIdx; i++){
            nowMo[i] = 1;
            getMo(moCnt, cnt + 1, i);
            nowMo[i] = 0;
        }
    }

    public static void solution() throws IOException {
        for(int moCnt = 1; moCnt <= L - 2; moCnt++){
            getMo(moCnt, 0, -1);
        }

        Collections.sort(passwords);
        
        sb = new StringBuilder();
        for(String pw : passwords){
            sb.append(pw).append("\n");
        }

        bw.write(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        ja = new char [C];
        mo = new char [C];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++){
            String c = st.nextToken();

            if("aeiou".contains(c)){
                mo[moIdx++] = c.toCharArray()[0];
            } else {
                ja[jaIdx++] = c.toCharArray()[0];
            }
        }

        nowJa = new int[jaIdx];
        nowMo = new int[moIdx];

        solution();
        bw.close();
    }
}
