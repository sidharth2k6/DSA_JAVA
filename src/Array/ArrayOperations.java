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

    public int bubbleSort(){
        int temp = 0;
        int steps = 0;

        for(int i = 1; i <= size; i++){
            for(int j = 0; j < size - i; j++){
                if(arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                steps++;
            }
            steps++;
        }
        return steps;
    }

    public int selectionSort(){
        int temp = 0;
        int steps = 0;
        int minIndex = 0;

        for(int i = 0; i < size - 1; i++){
            minIndex = i;
            for(int j = i + 1; j < size; j++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
                steps++;
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return steps;
    }

    public int insertionSort(){
        int key;
        int steps = 0;

        for(int i = 1; i < size; i++){
            int j = i - 1;
            key = arr[i];

            while(j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j--;
                steps++;
            }
            arr[j + 1] = key;
        }

        return steps;
    }

    public void quickSort(int[] arr, int l, int h){
        if(l < h){
            int mid = pivotValue(arr, l, h);

            quickSort(arr, l, mid - 1);
            quickSort(arr, mid + 1, h);
        }
    }

    public int pivotValue(int[] arr, int l, int h){
        int pivot = arr[h];
        int i = l - 1;

        for(int j = l; j < h; j++){
            if(arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[h];
        arr[h] = temp;

        return i + 1;
    }
}