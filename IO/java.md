# IO


### Класс java.io.File
Описание: Работает с путями и файлами.

````
File java = new File("/usr/bin/java");
java.getName();
java.getPath();
java.length(); // Длина файла.
````



### Классы java.nio.file.*
Описание: Класс java.io.File имеет свои недостатки. Поэтому решили написать новый API для работы с файловой системой.

Работа с путями: 
````
Path java = Paths.get("/usr/bin/java");
java.isAbsolute();
java.getFileName();
````


Работа с файлами: 
````
Path java = Paths.get("/usr/bin/java");
Files.exists(java);
Files.size(java);
Files.isReadable(java);
````

### Чтение из файла и запись в файл байтов java.io.InputStream, java.io.OutputStream.
Описание: Чтение и запись двочный файлов (фото, видео, pdf)

Абстрактные класс: 
java.io.InputStream и java.io.OutputStream - абстракные классы. Они не говорят куда они пишут и откуда читают. Они лишь дают общий интерфейс.

java.io.InputStream
````
int read();                          # Возвращает один байт из входного потока
int read(byte b[]);                  # Читает в массив байтов. Здесь можно сразу несколько байтов прочитать. Чтобы по миллион раз не обращаться к диску. 
int read(byte[], int off, int len);  # Так же читаем в массив байтов. off- откуда начинаем заполнять байты. len - сколько нужно заполнить
void close;                          # Освобождает ресурсы.
````

java.io.OutputStream
````
void write(int b);                          # Записывает один байт
void write(byte b[]);                       # Записывает в массив байтов. Здесь можно сразу несколько байтов прочитать. Чтобы по миллион раз не обращаться к диску. 
void write(byte[], int off, int len);       # Так же записывает в массив байтов. off- откуда начинать писать байты. len - сколько нужно записать
void flush();                               # Когда байты накопили в памяти надо сбросить в файл на диске.
void close;                                 # Освобождает ресурсы.
````


Конкретные реализации java.io.InputStream:
````
InputStream in = new FileInputStream(new File("input.data"));   # Читает файл
InputStream in = new ByteArrayInputStream(new byte[]{1, 2 ,3}); # Читаем данные из массива байтов в памяти.
InputStream in = new DataInputStream(anotherInputStream);       # 
InputStream in = new DeflaterInputStream(anotherInputStream);   # anotherInputStream дает запакованный файл zip например. DeflaterInputStream - будет уже возвращать распакованные данные.
````

Конкретные реализации java.io.OutputStream: 
````
OutputStream in = new FileOutputStream(new File("input.data"));   # Записывает в файл
OutputStream in = new ByteArrayOutputStream();                    # Записывает данные в массив байтов в памяти.
OutputStream in = new DataOutputStream(anotherInputStream);       # 
OutputStream in = new DeflaterOutputStream(anotherInputStream);   # Запаковыывает поток байтов.
````


### Чтение из файла и запись в текстовые файлы java.io.Reader, java.io.Writter.
Описание: Чтение и запись тестовых файлов (txt)

Абстрактные класс: 
java.io.Reader и java.io.Writter - абстракные классы. Они не говорят куда они пишут и откуда читают. Они лишь дают общий интерфейс.

java.io.Reader
````
int read();                          # Возвращает один символ из входного потока
int read(char b[]);                  # Читает в массив символов. Здесь можно сразу несколько символов прочитать. Чтобы по миллион раз не обращаться к диску. 
int read(char[], int off, int len);  # Так же читаем в массив символов. off- откуда начинаем заполнять. len - сколько нужно заполнить
void close;                          # Освобождает ресурсы.
````

java.io.Writter
````
void write(int b);                          # Записывает один символ
void write(char b[]);                       # Записывает в массив символов. Здесь можно сразу несколько символов записать. Чтобы по миллион раз не обращаться к диску. 
void write(char[], int off, int len);       # Так же записывает в массив символов. off- откуда начинать писать. len - сколько нужно записать
void flush();                               # Когда символы накопили в памяти надо сбросить в файл на диске.
void close;                                 # Освобождает ресурсы.
````

Конкретные реализации java.io.Reader:
````
Reader in = new InputStreamReader(inputStream, "UTF-8");      # Читает файл. inputStream - это байтовый поток выше. 
Reader in = new CharArrayReader(new char[]{'a', 'b', 'c'});   # Читаем данные из массива символов в памяти.
Reader in = new BufferedReader(anotherReader);                # Внутри себя имеет некий буфер, в который заранее считывает несколько символов. И мы потом просто читаем из этого буфера. Чтобы по миллион раз не обращаться к диску. 
````

Конкретные реализации java.io.Writer:
````
Writter out = new OutputStreamReader(outputStream, "UTF-8");      # Записываем в файл символы. outputStream - это байтовый поток выше. 
Writter out = new CharArrayWriter();                              # Записываем данные в массив символов в памяти.
Writter out = new BufferedWriter(anotherWriter);                  # Внутри себя имеет некий буфер, в который накапливает записываемые символы. И мы потом за одну операцию I/O сбрасывает на диск.
````