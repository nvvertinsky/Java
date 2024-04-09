### Damp Heap

### Снятие дампа с помощью VisualVM
  1. Смотрим запущенные приложения JVM. Выбираем нужное и кликаем.
  2. Переходим во вкладку Monitor -> Heap
  3. Синий участок - это использованная часть кучи. А коричневая свободная память кучи.
  4. Нажимаем Heap Dump. 
  
  
### Автоматическое снятие дампа. 
Что если нужно автоматически создавать дамп кучи, когда VM выбрасывает исключение OutOfMemoryError. 
Для этого запускаем приложение с ключами:

````
-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/tmp/heapdump.hprof
```` 

Для GRADLE:
````
JAVA_TOOL_OPTIONS="-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/tmp/heapdump.hprof" \
./gradlew :heapdumpanalysis:run \
-PmainClass=com.app \
````