import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

class DecodeString {
    public String decodeString(String s) {
        if(s==null || s.length() == 0){
            return null;
        }

        Stack<String> stack = new Stack<>();
        int n = s.length();
        int i = 0;
        while(i<n){
            if(s.charAt(i) == '['){ //左括号,直接入栈
                stack.push(String.valueOf(s.charAt(i)));
                i++;
            }
            else if(s.charAt(i) == ']'){ //右括号, 开始出栈
                Stack<String> sub = new Stack<>();
                while(!stack.peek().equals("[") ){
                    sub.push(stack.pop());
                }
                Collections.reverse(sub);
                //String s1 = sub.toString();
                String s1 = getString(sub);//不能用toString

                stack.pop();
                String res1 = "";
                int repeat = Integer.parseInt(stack.pop());//得到sub的重复次数
                for(int j =0; j < repeat; j++){ //将一层[]内的字符拼接成一个字符串
                    res1+=s1;
                }
                stack.push(res1);
                i++;
            }
            else if(Character.isDigit(s.charAt(i))){ //数字, 解析后入栈
                StringBuffer num = new StringBuffer();
                while(i<n && Character.isDigit(s.charAt(i))){ //解析数字
                    num.append(s.charAt(i));
                    i++;
                }
                stack.push(num.toString());
            }
            else{            //字母, 直接入栈
                stack.push(String.valueOf(s.charAt(i)));
                i++;
            }
        }
        StringBuffer res = new StringBuffer();
        for(String sub: stack){
            res.append(sub);
        }
        return res.toString();

    }


    public String decodeString2(String s) {
        if(s==null || s.length() == 0){
            return null;
        }
        int n = s.length();
        LinkedList<Integer> numList = new LinkedList<>();
        LinkedList<StringBuffer> strList = new LinkedList<>();
        StringBuffer sub = new StringBuffer();
        int i = 0;
        int num = 0;
        while(i<n){
            if(Character.isDigit(s.charAt(i))){
                num = num*10 + s.charAt(i)-'0';
            }
            else if(s.charAt(i) == '['){
                numList.push(num);
                num = 0;
                strList.push(sub); //以前的sub入栈
                sub = new StringBuffer(); //重建一个新的sub
            }
            else if(Character.isAlphabetic(s.charAt(i))){
                sub.append(s.charAt(i));
            }
            else{
                StringBuffer ansTem = strList.pop();
                int repeat = numList.pop();
                for(int j = 0; j<repeat; j++){
                    ansTem.append(sub);
                }
                sub = ansTem;
            }
            i++;
        }
        return sub.toString();

    }

    public String getString(Stack<String> stack) {
        StringBuffer stackToString = new StringBuffer();
        for(String str : stack){
            stackToString.append(str);
        }
        return stackToString.toString();
        
    }

    public static void main(String[] args) {
        DecodeString d = new DecodeString();
        String s = "1[a2[cd]]";
        System.out.println(d.decodeString2(s)); 
    }
}