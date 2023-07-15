import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(5, 3, 6, 2, 10));
        System.out.println(sort(arr));
    }

    public static int min(List<Integer> arr) {
        int minInx = 0;
        int min = arr.get(minInx);

        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < min) {
                min = arr.get(i);
                minInx = i;
            }
        }

        return minInx;
    }

    public static List<Integer> sort(List<Integer> arr) {
        List<Integer> newArr = new ArrayList<>(arr.size());
        int minInd = 0;
        int size = arr.size();

        for (int i = 0; i < size; i++) {
            minInd = min(arr);
            newArr.add(arr.get(minInd));

            arr.remove(minInd);
        }
        return newArr;
    }

}