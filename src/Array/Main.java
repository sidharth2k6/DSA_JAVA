package Array;

public class Main {
    static void main(String[] args) {
//        ArrayOperations arr = new ArrayOperations();
        ArrayOperations arr = new ArrayOperations(2, 9, 4, 5, 7, 3, 1, 6);

        System.out.println("Before sorting");
        arr.show();

        System.out.println("Steps: " + arr.selectionSort());

        System.out.println("After sorting");
        arr.show();

//        int result = arr.binarySearchRecursion(732, 0, arr.size - 1);
//
//        if(result != -1){
//            System.out.println("Target found at index: " + result);
//        }
//        else{
//            System.out.println("Target not found!");
//        }
    }
}