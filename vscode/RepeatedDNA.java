
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RepeatedDNA {
    public List<String> findRepeatedDnaSequences(String s) {
        
        if(s.length()<10){
            return new ArrayList<String>();
        }
        Map<Character, Integer> bit = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        List<String> result = new ArrayList<>();
        bit.put('A',0);
        bit.put('C',1);
        bit.put('G',2);
        bit.put('T',3);
        int code = 0;
        for(int i = 0; i<10; i++){
            code = code | bit.get(s.charAt(i));
            if(i!=9){
                code <<= 2;
            }
        }

        count.put(code, 1);
        for(int i = 1; i<=s.length()-10; i++){

            code<<=2;
            code |= bit.get(s.charAt(i+10-1));
            code &= 0b0011111111111111111111;

            int num = count.getOrDefault(code, 0);
            num++;
            count.put(code, num);
            if(num==2){
                result.add(s.substring(i,i+10));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RepeatedDNA r = new RepeatedDNA();
        String DNA = "GAGAGAGAGAGA";
        List<String> result = r.findRepeatedDnaSequences(DNA);
        System.out.println(result);
    }
    
}
