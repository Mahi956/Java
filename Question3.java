 //Kth MIN and MAX element in array
import java.util.*;

public class Question3 {
    public static void main(String[] args) {
        Scanner Scr = new Scanner(System.in);

        System.out.println("Enter the size of array : ");
        int n= Scr.nextInt();
        int arr[]=  new int [n];

        System.out.println("Enter elements of array : ");
        for(int i =0; i<n;i++){
            arr[i]=Scr.nextInt();
        }

        System.out.println("Enter value of k :");
        int k = Scr.nextInt();
    
        Arrays.sort(arr);
        if (k>0 && k<=n) {
            System.out.println("kth Minimum element :"+ arr[k-1]);
            System.out.println("kth Maximum element :"+ arr[n-k]);
        }
    }
    
}
