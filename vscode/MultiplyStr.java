

class MultiplyStr {
    public String multiply(String num1, String num2) {

        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }


        String ans = "0";
        for(int i = num1.length()-1; i>=0; i--){
            StringBuilder curr = new StringBuilder();
            int carry = 0;
            for(int j = num1.length()-1; j>i; j--){
                curr.append(0);
            }

            for(int j = num2.length()-1; j>=0; j--){
                int pro = (num1.charAt(i)-'0') * (num2.charAt(j)-'0') + carry;
                curr.append(pro%10);
                carry = pro / 10;
            }
            if(carry!=0){
                curr.append(carry);
            }

            ans = addStr(ans, curr.reverse().toString());

        }
        return ans;
    }

    public String addStr(String num1, String num2){
        
        int carry = 0;
        StringBuilder ans = new StringBuilder();
        int i = num1.length()-1;
        int j = num2.length()-1;
        while(i>=0 || j >=0){
            int x1 = i>=0? num1.charAt(i) - '0' : 0;
            int x2 = j>=0? num2.charAt(j) - '0' : 0;
            int sum = x1 + x2 + carry;
            ans.append(sum % 10);
            carry = sum/10;
            i--;
            j--;
        }
        if(carry!=0){
            ans.append(carry);
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        
        MultiplyStr m = new MultiplyStr();
        String num1 = "9133";
        String num2 = "0";
        String result = m.multiply(num1,num2);
        System.out.println(result);
        
    }
}