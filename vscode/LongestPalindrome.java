
class LongestPalindrome {
    public String longestPalindrome1(String s) {

        int len = s.length();
        if(len <2){
            return s;
        }

        boolean[][] dp = new boolean[len][len];
        int l = 0, r = 1;

        for(int i = 0; i<len;i++){
            dp[i][i] = true;
        }

        for(int L = 2; L<=len; L++){
            for(int i = 0; i < len; i++){
                int j = L+i-1;

                if(j>=len){
                    break;
                }

                if(s.charAt(i)!= s.charAt(j)){
                    dp[i][j] = false;
                } else{
                    if (L<=3){
                        dp[i][j] = true;
                        l=i;
                        r=j+1;

                    }else{
                        dp[i][j] = dp[i+1][j-1];
                        if(dp[i][j] == true){
                            l = i;
                            r = j+1;
                        }
                    }
                }
                
            }
        }
        return s.substring(l,r);

    }
    public static void main(String[] args) {
        LongestPalindrome longest = new LongestPalindrome();
        String s = "babad";

        String result = longest.longestPalindrome1(s);
        System.out.println(result);
    }
}