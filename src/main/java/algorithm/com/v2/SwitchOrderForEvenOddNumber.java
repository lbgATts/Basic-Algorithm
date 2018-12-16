package algorithm.com.v2;

public class SwitchOrderForEvenOddNumber {

    static void switchOrder(int a[], int start, int end) {

    }


    static int partition(int data[],int start,int end) {

        int tmp = data[start];

        while(start < end) {

            while(start < end && data[end] >= tmp) end--;

            data[start] = data[end];

            while(start < end && data[start] <= tmp) start++;

            data[end] = data[start];
        }
        data[start] = tmp;
        return start;
    }


    static void quickSort(int data[],int start,int end) {

        if (data == null || data.length <=0) return;

        if (start < end) {

            int pos = partition(data,start,end);

            quickSort(data,start,pos-1);

            quickSort(data,pos+1,end);
        }
    }

    static void printArray(int arr[]) {

        for (int i=0;i<arr.length;i++) {

            if (i+1>=arr.length) {

                System.out.println(arr[i]);

            } else {

                System.out.print(arr[i] + ",");

            }

        }

    }


    public static void main(String args[]) {

        int a[] = {1,3,5,2,4,6,-1};

        quickSort(a,0,6);

        printArray(a);

    }

}
