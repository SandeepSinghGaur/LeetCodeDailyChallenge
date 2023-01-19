package JANUARY2023;

public class Day19Jan2023 {

    public static void main(String[] args){
        int[] nums = new int []{1,2,3,4,5,3};
        int k=3;
        int res = subarraysDivByK(nums , k);
        System.out.println(res);
    }

    public static int subarraysDivByK(int[] nums, int k) {
        int prefixMod = 0, result = 0;
        int[] modGroups = new int[k];
        modGroups[0] = 1;
        for (int num: nums) {
            prefixMod = (prefixMod + num % k + k) % k;
            result += modGroups[prefixMod];
            modGroups[prefixMod]++;
        }
        return result;
    }
    
}
