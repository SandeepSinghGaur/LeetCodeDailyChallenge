package JANUARY2023;

import java.util.ArrayList;
import java.util.Arrays;

public class Day16Jan2023 {

    public static void main(String[] args) {
        int[][] interval = new int[2][2];
        interval[0][0] = 1;
        interval[0][1] = 3;
        interval[1][0] = 6;
        interval[1][1] = 9;
        int[] newInterval = new int[2];
        newInterval[0] = 2;
        newInterval[1] = 5;
        int[][] res = insert(interval, newInterval);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i][0]);
            System.out.println(res[i][1]);
        }
    }

    private static int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        boolean check = true;
        int x = newInterval[0];
        int y = newInterval[1];
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][1]<x){
                res.add(new ArrayList<>(Arrays.asList(intervals[i][0],intervals[i][1])));
            }else if(y<intervals[i][0]){
                check = false;
                res.add(new ArrayList<>(Arrays.asList(x,y)));
                for(int j=i;j<intervals.length;j++){
                     res.add(new ArrayList<>(Arrays.asList(intervals[j][0],intervals[j][1])));
                }
                break;
            }else{
                x = Math.min(x,intervals[i][0]);
                y = Math.max(y,intervals[i][1]);
            }
        }
        if(check)
        res.add(new ArrayList<>(Arrays.asList(x,y)));
        int row = res.size();
        int [][] ans = new int[row][2];
        for(int k=0;k<res.size();k++){
            ans[k][0]=res.get(k).get(0);
            ans[k][1]=res.get(k).get(1);
        }
        return ans;
    }

}
