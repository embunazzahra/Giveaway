import java.util.*;

public class Giveaway {

    public static void main(String[] args) {
        int n, i, x;
        String num;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);
        n = input1.nextInt();
        num = input.nextLine();
        String[] strArr = num.split(" ");
        for(i=0;i<strArr.length;i++){
            x = Integer.parseInt(strArr[i]);
            arr.add(x);   
        }
        System.out.println(arr);
        input.close();
    }
    
}
