package algorithm.com.v2;

public class FindMinMaxInRateArray {

    /**
     * 在旋转数组中找到最大最小值
     * @param data
     * @return
     */
    public static int findSmallestNum(int data[]) {

        if (data == null || data.length <= 0) return -1; //no num found

        int start = 0, end = data.length - 1;

        int mid = start + (end - start) / 2;

        while (data[start] >= data[end]) {

            if (end - start == 1) {

                mid = end;

                break;

            }

            if (data[start] < data[mid]) {

                start = mid;

            } else if (data[end] > data[mid]) {

                end = mid;

            }

        }

        return data[mid];

    }

    public static void main(String args[]) {

        int data[] = {3, 4, 5, 1, 2};

        System.out.println(data);
    }

}


