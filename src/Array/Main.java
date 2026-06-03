package Array;

public class Main {
    static void main(String[] args) {
//        ArrayOperations arr = new ArrayOperations();
        ArrayOperations arr = new ArrayOperations(2, 23, 34, 345, 634, 664, 732, 843);

//        arr.insLast(34);
//        arr.insLast(45);

//        arr.insFirst(64);
//        arr.insFirst(44);
//        arr.insFirst(6);
//        arr.insFirst(24);
//        arr.insFirst(62);
//        arr.insFirst(83);
//        arr.insFirst(854);

//        arr.insSpecific(4, 999);
//        arr.insSpecific(8, 2323);

        arr.show();

        int result = arr.binarySearchRecursion(732, 0, arr.size - 1);

        if(result != -1){
            System.out.println("Target found at index: " + result);
        }
        else{
            System.out.println("Target not found!");
        }
    }
}