import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
/*
返回一个字符串内所有字符能构成的最长回文字符串长度
*/
class LongestPalindrome2 {
    //贪心
    //计数, 出现若一个字母出现偶数次N, 长度+N; 若出现奇数次M, 长度+(M-1), 如果有出现奇数次的字母, 最后结果再+1
    public int longestPalindrome1(String s) {

        int result = 0;
  
        int oddFlag = 0;
        //哈希表计数
        Map<Character, Integer> count = new HashMap<>();

        for(int i = 0; i<s.length(); i++){
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0)+1);
        }
    
        //Collection<Integer> values = count.values();
        //System.out.println(values.getClass().toString()); //class java.util.HashMap$Values
        for(Integer value : count.values()){
        //for(Integer value : values){
            result += value/2*2; //偶数次不变, 奇数次减一
            if(value%2==1 && result%2==0){ //首次出现奇数时, 加一(单个字符作为回文中心)
                result++;
            }
        }
        return result+oddFlag;
    }

    //逆向思考
    //统计出现奇数次的字母, 在字符串总长度的基础上减去奇数字母数, 如果存在出现奇数次的字母, 最后结果+1
    public int longestPalindrome2(String s) {
        int[] count = new int[128];
        int countOdd = 0;

        //这样写更快
        for(char c : s.toCharArray()) {
            count[c]++;
        }
    /*
        for(int i = 0; i<s.length(); i++){
            count[s.charAt(i)]++;
        }
    */
        for(int i = 0; i<128; i++){
            countOdd += count[i]%2;
        }

        return countOdd==0? s.length() : s.length()-countOdd +1;
    }


    public static void main(String[] args) {
        LongestPalindrome2 l = new LongestPalindrome2();
        String s = "abccccdd";
        System.out.println(l.longestPalindrome1(s));

    }
    
}
