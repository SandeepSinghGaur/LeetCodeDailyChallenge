package JANUARY2023;

public class Day17Jan2023 {

    public static void main(String[] args){
        String s="010101";
        int res = minFlipsMonoIncr(s);
        System.out.println("Minimum number of flips required"+" "+res);
    }

    private static int minFlipsMonoIncr(String s) {
        int m = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                ++m;
            }
        }
        int ans = m;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                ans = Math.min(ans, --m);
            } else {
                ++m;
            }
        }
        return ans;
    }
    
}
