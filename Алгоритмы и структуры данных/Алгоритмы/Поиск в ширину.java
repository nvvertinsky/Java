public class Main {

    public static void main(String[] args) {
        search("you"); /*Вызываем поиск в ширину*/
    }

    public static void search(String name) {
        Map<String, List<String>> graph = new HashMap<>(); /*Создаем хеш таблицу с отношением*/
        Queue<String> searchQueue = new ArrayDeque<>(graph.get(name)); /*Очередь*/
        List<String> searched = new ArrayList<>(); /*Их уже искали*/

        graph.put("you", Arrays.asList("alice", "bob", "claire")); /*Мои друзья*/
        graph.put("bob", Arrays.asList("anuj", "peggy")); /*Друзья bob*/
        graph.put("alice", Arrays.asList("peggy"));
        graph.put("claire", Arrays.asList("thom", "jonny"));
        graph.put("anuj", Collections.emptyList());
        graph.put("peggy", Collections.emptyList());
        graph.put("thom", Collections.emptyList());
        graph.put("jonny", Collections.emptyList());

        while (!searchQueue.isEmpty()) { /*Очередь не пуста*/
            String person = searchQueue.poll(); /*Берем первого из очереди*/

            if (!searched.contains(person)) { /*Его не должно быть в списке уже проверенных*/
                if (person_is_seller(person)) { /*Он продавец манго?*/
                    System.out.println(person + " is mango seller");
                } else {
                    searchQueue.addAll(graph.get(person)); /*Если нет, то добавляем всех его друзей в очередь*/
                    searched.add(person); /*А самого добавляем с список проверенных.*/
                }
            }
        }
    }

    private static boolean person_is_seller(String name) {
        return name.endsWith("m");
    }


}