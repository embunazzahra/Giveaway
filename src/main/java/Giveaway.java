import java.util.*;
import java.lang.System;

public class Giveaway {
    public static void main(String[] args) {
        int target, n, i, j, s, count = 0, total = 0;
        String num;
        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);
        target = input1.nextInt(); //target = jumlah barang yang ingin dibagikan
        num = input.nextLine();
        String[] strArr = num.split(" ");
        int[] arr = new int[strArr.length];
        for(i=0;i<strArr.length;i++){
            arr[i] = Integer.parseInt(strArr[i]);
            count+=arr[i];
        }
        n = arr.length; // n = jumlah orang yang ingin dibagi
        input.close(); input1.close();
        Arrays.sort(arr);
        s = target - count;
        if (s==0){
            System.out.println("1");
            System.exit(0);
        }
        ArrayList<Integer> all = new ArrayList<>();
        for(i=1;i<=s;i++){
            all.add(i);
        }
        List<List<Integer>> res = new ArrayList<>();
        res = combinationSumAnother(all, s);
        for(i=0;i<res.size();i++){
            if(res.get(i).size()>n){
                continue;
            }
            Collections.sort(res.get(i));
            int same = 1, sum = factorial(n)/factorial(n-res.get(i).size());
            for(j=0;j<res.get(i).size()-1;j++){
                if(!Objects.equals(res.get(i).get(j), res.get(i).get(j+1))){
                    sum = sum/factorial(same);
                    same = 1;
                }else{
                    same++;
                    if (j == res.get(i).size()-2){
                        sum = sum/factorial(same);
                    }
                }
            }
            total+= sum;            
        }
        total %= 1000000007;
        System.out.println(total);
    }
    
    /*function to search for combination number where the candidates number equals to target number.
    This function is from https://gist.github.com/wayetan/8215995*/
   
    public static List<List<Integer>> combinationSumAnother(ArrayList<Integer> all, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(true==all.isEmpty()) return res;
        //Collections.sort(all);
        helper(all, 0, target, new ArrayList<>(), res);
        return res;
    }
    public static void helper(ArrayList<Integer> all, int start, int target, List<Integer> path, List<List<Integer>> res) {
        if(target < 0) return;
        else if(target == 0) {
            // found one! 
            res.add(path);
        } else {
            // go on the recursion
            for(int i = start; i < all.size(); i++) {
                // ignore the duplicate one.
                if( i > start && Objects.equals(all.get(i), all.get(i-1))) continue;
                int curr = all.get(i);
                if(target - curr >= 0) {
                    List<Integer> temp = new ArrayList<>(path);
                    temp.add(curr);
                    helper(all, i, target - curr, temp, res);
                }
            }
        }
    }
    static int factorial(int n) {
      int fact = 1;
      int i = 1;
      while(i <= n) {
         fact *= i;
         i++;
      }
      return fact;
   }
}
