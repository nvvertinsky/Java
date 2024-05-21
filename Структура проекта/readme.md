src
  main
    ru.vertinsky.spring 
      config:  Конфигурация
      controllers: Контроллер
      dao: Слой DAO
      models: Модели
      services: бизнес логика
      repository: Для простых запросов, а DAO для специфических запросов. 
      util: Validator чтобы ошибки отображались нормально
      dto: Транспортные объекты
webapp
  web-inf
    views: Представления для Spring MVC
resources
  database.properties Данные для входа в БД. Не публикуем на GitHub. Чтобы импортировать его в конфиге аннотация PropertySource