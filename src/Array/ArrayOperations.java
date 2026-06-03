package Array;

import java.util.Arrays;

public class ArrayOperations {
    int size;
    int[] arr = new int[10];

    ArrayOperations(int... values){
        for(int i = 0; i < values.length; i++){
            arr[i] = values[i];
        }
        size = values.length;
    }

    ArrayOperations(){}


    public void show(){
//        for(int i = 0; i < size; i++){
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();
        System.out.println(Arrays.toString(arr));
    }

    //insert
    public void insLast(int value){
        if(size >= arr.length){
            System.out.println("OverFlow condition!");
        }
        else{
            arr[size++] = value;
        }
    }

    public void insFirst(int value){
        if(size >= arr.length){
            System.out.println("OverFlow condition!");
        }
        else{
            for(int i = size; i > 0; i--){
                arr[i] = arr[i - 1];
            }
            arr[0] = value;
            size++;
        }
    }

    public void insSpecific(int pos, int value){
        if(size >= arr.length){
            System.out.println("OverFlow condition!");
            return;
        }
        if(pos < 0 || pos > size + 1){
            System.out.println("Can't insert!");
            return;
        }

        for(int i = size; i >= pos; i--){
            arr[i] = arr[i - 1];
        }
        arr[pos - 1] = value;
        size++;
    }

    //delete
    public void delLast(){
        if(size <= 0){
            System.out.println("UnderFlow condition!");
            return;
        }

        arr[size - 1] = 0;
        size--;
    }

    public void delFirst(){
        if(size <= 0){
            System.out.println("UnderFlow condition!");
            return;
        }

        for(int i = 0; i < size; i++){
            arr[i] = arr[i + 1];
        }
        arr[size--] = 0;
    }

    public void delSpecific(int pos){
        if(size <= 0){
            System.out.println("UnderFlow condition!");
            return;
        }

        for(int i = pos - 1; i < size; i++){
            arr[i] = arr[i + 1];
        }

    }

    //search
    public int linearSearch(int target){
        for(int i = 0; i < size; i++){
            if(arr[i] == target){
                return i;
//                System.out.println("target found at index: " + i);
            }
        }
        return -1;
    }

    public int binarySearch(int target){
        int left = 0;
        int right = size - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return -1;
    }

    public int binarySearchRecursion(int target, int left, int right){
        if(left > right){
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return  binarySearchRecursion(target, mid + 1, right);
        } else {
            return binarySearchRecursion(target, left, mid - 1);
        }
    }
}