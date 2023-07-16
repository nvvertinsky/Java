import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(99, 1, 0, 2, 54));
        System.out.println(qsort(arr));
    }

    public static List<Integer> qsort(List<Integer> arr) {
        List<Integer> lessArr = new ArrayList<>();
        List<Integer> GreaterArr = new ArrayList<>();

        if (arr.size() <= 1) {
            return arr; /* Базовый случай. В массиве либо нет элементов, либо 1 */
        } else { /*Рекурсивный случай. Нужно сделать шаг к базовому случаю*/
            int inx = arr.get(0);

            for (int i = 1; i <= arr.size() - 1; i++) {
                if (inx < arr.get(i)) {
                    GreaterArr.add(arr.get(i));
                }

                if (inx > arr.get(i)) {
                    lessArr.add(arr.get(i));
                }
            }

            return Stream.of(
                            qsort(lessArr).stream(),
                            Stream.of(inx),
                            qsort(GreaterArr).stream())
                    .flatMap(Function.identity()).collect(Collectors.toList());
        }
    }
}