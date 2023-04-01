# Создание архитектуры 
Правильная архитектура экономит очень много сил, времени и денег.

## Что существует на данный момент на эту тему: 
  - Шаблоны проектирования
  - Принципы проектирования SOLID
  

## Критерии хорошей архитектуры:
  - Эффективность системы. Программа должна решать поставленные задачи.
  - Гибкость системы. То есть быстро и удобно можно внести изменения в существующий функционал. Чем меньше проблем и ошибок это вызовет - тем гибче.
  - Расширяемость системы. Должна быть возможность расширить/изменить поведение системы без изменения/переписывания уже существующих частей системы. 
    - То есть чтобы изменение поведения или добавления новой функциональности достигалось бы за счет написания нового кода, и при этом не приходилось бы менять уже существующий код.
  - Масштабируемость процесса разработки. Архитектура должна позволять распараллелить процесс разработки, чтобы множество людей могли работать над программой одновременно.
  - Тестируемость. Код, который легче тестировать, будет содержать меньше ошибок и надежнее работать.
  - Возможность повторного использования. Фрагменты можно повторно использовать.
  - Хорошо структурированный, читаемый, понятный код. Сопровождаемость. Архитектура должна давать возможность легко и быстро разобраться в системе новым людям.
  
  
## Модульная архитектура. Декомпозиция как основа: 
Несмотря на разнообразие критериев, все же главной при разработке больших систем считается задача снижения сложности. А для снижения сложности ничего, кроме деления на части, пока не придумано. 

Иерархическая декомпозиция - сложная система должна строится из небольного количества более простых подсистем, каждая из которых, в свою очередь, строится из частей меньшего размера.
  - Подразумевается декомпозиция на подсистемы (функциональные модули, сервисы, слои, подпрограммы) и организация их взаимодействия друг с другом и внешним миром.
  - Чем более независимы подсистемы, тем безопаснее сосредоточиться на разработке каждой из них в отедельности.
  
Программа из хаоса превращается в конструктор, состоящий из набора модулей. Что позволяет получить преймущества хорошей архитектуры:
  - Масшабируемость. Возмозможность расширять систему за счет добавления новых модулей.
  - Ремонтопригодность. Изменения одного модуля не требует изменения других модулей. 
  - Заменимость модулей. Модуль легко заменчить на другой.
  - Возмодность тестирования.
  - Переиспользования.
  - Сопровождаемость

Разбиение сложной проблемы на простые фрагменты и заключается цель всех методик проектирования. 
Архитектура означает результат такого деления. 


## Правильная декомпозиция
  - Иерархическая.
    - Система
    - Разделение системы на подсистемы/пакеты
	- Разделение подсистем/пакетов на слои/подпакеты (от меня)
    - Разделение подпакетов на классы. 
    - Пример MVC.
  
  - Функциональная. Деление на модули/подсистемы лучше всего производить из тех задач, которые решает система. 
    - Основная задача разбирвается на составляющие ее позадачи, которые могут решаться/выполняться независимо друг от друга.
    - Каждый модуль должен отвечать за решение какой-то подзадачи. 
    - Модуль = функция + Данные, необходимые для ее выполнения.
    - Желательно чтобы модуль выполнить самостоятельно, без помощи остальных модулей. 

Модуль - это отдельная функционально осмысленная и законченная программная единица, которая обеспечивает решение некоторой задачи и в идеале может работать самостоятельно.

	
## High Cohesion + Low Coupling
  
  - High Cohesion. Высокая сопряженность внутри модуля говорит о том, модуль сфокусирован на решение одной узкой проблемы. 
  - Low Coupling. Слабая связанность. Модуль должны быть слабо связанны. Идеально - независимы друг от друга.
    - Это значит, при изменении одного модуля, не придется править другие или изменения будут минимальные.
	
Ослаблять связанность нужно на всех уровнях иерархии. То есть не только между классами, но так же и между модулями на каждом уровне.


## Как ослаблять связанность между модулями: 

### 1. Интерфейсы. Фасад. 
  - Объекты подсистемы не должны обращаться напрямую к объектам другой подсистемы.
  - Подсистемы должны взаимодействовать друг с другом лишь посредством интерфейсов. За реализацию интерфейса подсистемы может отвечать специальный объект фасад.
  - Фасад - паттерн проектирования, который уменьшает связанность между объектами подсистемами.

![alt text](Facade1.gif)
  
### 2. Dependency Inversion. Корректное создание и получение зависимостей. 
  - Последний принцип SOLID "Инвертирования зависимостей". Практические примеры решения, которые не нарушают Dependency Inversion
    - Шаблон Фабричный метод и Абстрактная фабрика
![alt text](1024.webp)
	- Шаблон Локатор сервисов
	- Внедрение зависимостей. Используется в Spring

Использование интерфейсов для описания зависимостей между модулями (Dependency Inversion) + корректное создание и внедрение этих зависимостей (прежде всего Dependency Injection) являются базовыми 
техниками для снижения связанности. Это фундамент.

Далее идут доп. приемы. Только если с фундаментом все ок. 
  
### 3. Замена прямых зависимостей на обмен сообщениями. Реализуется через шаблоны: 
    - Наблюдатель
    - Посредник
  
### 4. Замена прямых зависимостей на синхронизацию через общее ядро.
  - Закон Деметры
  - Композия вместо наследования   


### Источники: 
  - https://habr.com/ru/post/276593/
  - http://www.skipy.ru/architecture/module_design.html#principles
  