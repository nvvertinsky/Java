public class Main {
    public static void main(String[] args) {
        int[] list = new int[]{1,2,3,4,5,6,7,8,9,10};
        System.out.println(binarySearch(list, 10));
    }


    public static int binarySearch(int[] list, int item) {
        int lowIndex = 0;
        int highIndex = list.length - 1;

        while (lowIndex <= highIndex) {
            int midIndex = (highIndex + lowIndex) / 2;
            int val = list[midIndex];

            if (item == val)
                return val;

            if (item < val)
                highIndex = midIndex - 1;

            if (item > val)
                lowIndex = midIndex + 1;

        }

        return -1;
    }
}