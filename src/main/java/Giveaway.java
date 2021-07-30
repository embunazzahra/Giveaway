import java.util.*;

public class Giveaway {

    public static void main(String[] args) {
        int n, i, x = 0;
        String num = "xy";
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Scanner input = new Scanner(System.in);
        while(num.length()>0){
            try{
                num = input.nextLine();
                String[] strArr = num.split(" ");
                for(i=0;i<strArr.length;i++){
                    x = Integer.parseInt(strArr[i]);
                    arr.add(x);   
                }
                //System.out.println(arr);
            }
            catch(NumberFormatException e){
                System.out.println("input completed!");
            }
        }
        System.out.println(arr);
        input.close();
    }
    
}
