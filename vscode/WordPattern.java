import java.util.HashMap;
import java.util.Map;

class WordPattern {

    //暴力枚举
    //pattern中字符相等 <--> s中字符串相等
    public boolean wordPattern1(String pattern, String s) {
        String[] ss = s.split(" ");
        if(pattern.length()!=ss.length){
            return false;
        }

        for(int i = 1; i<pattern.length(); i++){
            for(int j = 0; j<i; j++){
                if(pattern.charAt(i)==pattern.charAt(j)){
                    if(!ss[i].equals(ss[j])){
                        return false;
                    }
                }
                
                if(ss[i].equals(ss[j])){
                    if(pattern.charAt(i)!=pattern.charAt(j)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //两个哈希表
    public boolean wordPattern2(String pattern, String s) {

        String[] ss = s.split(" ");
        if(pattern.length()!=ss.length){
            return false;
        }

        Map<Character, String> p2s = new HashMap<>();
        Map<String, Character> s2p = new HashMap<>();
        for(int i = 0; i<pattern.length(); i++){
            if(p2s.containsKey(pattern.charAt(i))){
                if(!p2s.get(pattern.charAt(i)).equals(ss[i])){
                    return false;
                }
            }else{
                p2s.put(pattern.charAt(i), ss[i]);
            }

            if(s2p.containsKey(ss[i])){
                if(!s2p.get(ss[i]).equals(pattern.charAt(i))){
                    return false;
                }
            }else{
                s2p.put(ss[i],pattern.charAt(i));
            }
        }
        return true;
        
    }

    //一个哈希表
    //方法很巧妙
    public boolean wordPattern3(String pattern, String s) {

        String[] ss = s.split(" ");
        if (ss.length != pattern.length()) {
            return false;
        }
        Map<Object, Integer> map = new HashMap<>();
        for (Integer i = 0; i < ss.length; i++) {
            /*
                如果key不存在，插入成功，返回null；如果key存在，返回之前对应的value。

                以pattern = "abba", s = "dog cat cat dog"为例，
                第1次：map.put('a',0)返回null，map.put("dog",0)返回null，两者相等；
                第2次：map.put('b',1)返回null，map.put("cat",1)返回null，两者相等；
                第3次：map.put('b',2)返回1，map.put("cat",2)返回1，两者相等；
                第4次：map.put('a',3)返回0，map.put("dog",3)返回0，两者相等，
                结果为 true。

                以pattern = "abba", s = "dog cat cat fish"为例，
                第1次：map.put('a',0)返回null，map.put("dog",0)返回null，两者相等；
                第2次：map.put('b',1)返回null，map.put("cat",1)返回null，两者相等；
                第3次：map.put('b',2)返回1，map.put("cat",2)返回1，两者相等；
                第4次：map.put('a',3)返回0，map.put("fish",3)返回null，两者不相等，
                结果为 false。
            */
            if (map.put(pattern.charAt(i), i) != map.put(ss[i], i)) {
                return false;
            }
        }
        return true;

    }
        

    public static void main(String[] args) {
        WordPattern w = new WordPattern();
        String pattern = "abba";
        String s = "dog cat cat dog";
        boolean result = w.wordPattern3(pattern, s);
        System.out.println(result);
    }
    
}
