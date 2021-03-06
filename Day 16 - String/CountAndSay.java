public class CountAndSay {
    public static String solve(String s){
        char ch = s.charAt(0);
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) != ch){
                sb.append(count).append(ch);
                ch = s.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }
        sb.append(count).append(ch);
        return sb.toString();
    }
    
    public static String countAndSay(int n) {
        if(n == 1) return "1";
        String ans = "1";
        for(int i = 2; i <= n; i++){
            ans = solve(ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        String ans = countAndSay(n);
        System.out.println(ans);
    }
}