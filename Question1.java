/* Find the maximum and minimum element in an array */
public class Question1 {
    public static void main(String[] args) {
        int arr[]= {10,15,45,9,56};
        int max=arr[0];
        int min=arr[0];

        for(int i=0;i<arr.length;i++){
            if(max<arr[i]){
                max=arr[i];
            }

            if(min>arr[i]){
                min=arr[i];
            }
        }
        System.out.println("Maximum element is:" + max);
        System.out.println("Minimum element is:" +min);
    }
}
