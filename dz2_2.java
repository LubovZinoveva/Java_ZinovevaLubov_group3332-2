public class dz2_2 {
    public static void main(String[] args) {
        int[] myArray = {5, 2, 98, 43, 11, 56, 1};
        bubbleSortArray(myArray);
        for(int item : myArray){
            System.out.print(item + " ");
        }
    }
    
    public static int[] bubbleSortArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j + 1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
