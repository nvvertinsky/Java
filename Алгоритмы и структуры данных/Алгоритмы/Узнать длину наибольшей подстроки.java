public class Main {
/*Задана строка S из малых латинских букв, требуется узнать длину наибольшей подстроки, в которой все буквы одинаковы.
Например:
1) "" -> 0
2) "a" -> 1
3) "abbc" -> 2
4) "adddaabaa" -> 3
*/
    public static int maxLengthOfSameCharactersSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int maxLength = 1;
        int currentLength = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currentLength++;
            } else {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1;
            }
        }

        // Проверяем последнюю последовательность
        maxLength = Math.max(maxLength, currentLength);

        return maxLength;
    }

    public static void main(String[] args) {
        // Тестовые примеры
        System.out.println(maxLengthOfSameCharactersSubstring(""));         // 0
        System.out.println(maxLengthOfSameCharactersSubstring("a"));        // 1
        System.out.println(maxLengthOfSameCharactersSubstring("abbc"));     // 2
        System.out.println(maxLengthOfSameCharactersSubstring("adddaabaa")); // 3
    }
}