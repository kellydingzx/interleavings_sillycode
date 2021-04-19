import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Permu {
    static {

    }

    public static ArrayList<String> permutation(int x) {
        ArrayList<String> strings = new ArrayList<>();
        for(int i=0; i< Math.pow(2,x); i++){
            String str = Integer.toBinaryString(i);
            int count = 0;
            for(int j=0; j< str.length(); j++){
                if(str.charAt(j) == '1'){
                    count++;
                }
            }
            if(count == 3){
                strings.add(str);
            }
        }
        return strings;
    }

    public static void main(String[] args) {
        String[] t1 = {"1","2a","2b"};
        String[] t2 = {"3","4a","4b"};
        ArrayList<String>  cobs = permutation(6);
        System.out.println(cobs.size());
        ArrayList<String> res = new ArrayList<>();
        for(int i=0; i<cobs.size(); i++){
            String curr = cobs.get(i);
            StringBuilder sbd = new StringBuilder();
            int t1_count = 0;
            int t2_count = 0;
            if(curr.length()<6){
                int zeros = 6-curr.length();
                for(int k =0; k< zeros; k++){
                    sbd.append(t1[t1_count]);
                    sbd.append(", ");
                    t1_count++;
                }
            }
            for(int m=0; m<curr.length(); m++){
                char curr_char = curr.charAt(m);
                if(curr_char == '1'){
                    sbd.append(t2[t2_count]);
                    sbd.append(", ");
                    t2_count++;
                }
                if(curr_char == '0'){
                    sbd.append(t1[t1_count]);
                    sbd.append(", ");
                    t1_count++;
                }
            }
            res.add(sbd.subSequence(0, sbd.length()-2).toString());
        }
        getResult(res);

    }

    public static void getResult(ArrayList<String> strs){
        HashMap<String, Integer> ans = new HashMap<>();
        int a_4 = 0;
        int a_2 = 0;
        for(int k=0; k< strs.size(); k++) {
            int score = 0;
            ArrayList<String> parts =
                    new ArrayList<>(Arrays.asList(strs.get(k).split(", ")));
            for (int i = 0; i < parts.size(); i++) {
                if(parts.get(i).equals("1")){
                    score = 100;
                }else if(parts.get(i).equals("3")){
                    score = 200;
                }else if(parts.get(i).equals("2b")){
                    score = a_2 + 10;
                }else if(parts.get(i).equals("4b")){
                    score = a_4 - 20;
                }else if(parts.get(i).equals("4a")) {
                    a_4 = score;
                }else if(parts.get(i).equals("2a")) {
                    a_2 = score;
                }
            }
            ans.put(strs.get(k), score);
        }
        for(Map.Entry entry : ans.entrySet())
            System.out.println(entry);
    }
}
