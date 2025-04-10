# Сервис проверки компании по ИНН в базе ФНС

[![Java](https://img.shields.io/badge/Java-17%2B-blue)](https://www.java.com/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.5-brightgreen)](https://spring.io/projects/spring-boot)
[![License](https://img.shields.io/badge/License-MIT-green)](LICENSE)

Проект представляет собой REST-API приложение для проверки компаний по ИНН в базе ФНС (https://api-fns.ru/api/).

## 📌 Основные возможности

- **Проверка компаний по ИНН** через API ФНС
- **Интеграция с биллинг-системой** для проверки разрешений
- **Получение полной информации** о компании:
    - Основные реквизиты (ИНН, ОГРН)
    - Статус компании
    - Юридический адрес
    - Основной вид деятельности
- **Мониторинг лимитов** подписки ФНС
- **Гибкая система доступа** через API ключи

### 🛠 Технологии
- **Java 21**
- **Spring Boot 3.1.5**
- **Spring Web MVC**
- **Lombok** - для сокращения boilerplate кода
- **Jackson** - работа с JSON
- **Apache HttpClient** - HTTP запросы
- **Maven** - управление зависимостями

## 🚀 Быстрый старт

### Предварительные требования

- **Java 21 или новее**
- **Maven 3.8+**
- **MySQL 8.0+ (или другая поддерживаемая СУБД)**

### Установка и запуск

1. Клонируйте репозиторий:
   ```bash
   git clone https://github.com/DanilPV/apiFnsBilling.git
   cd search-engine

2. Настройте сервис данных в application.properties:

   ````
    # Настройки приложения
    spring.application.name=apiFnsBilling
    server.port=4002

    # Безопасность
    accept.key=your-service-access-key
    
    # Настройки ФНС API
    fns.key=your-fns-api-key
    fns.url=https://api-fns.ru/api/
    
    # Интеграция с биллинг-системой
    billing.url=http://billing-service:4001/api/main/checkFnsInn
    billing.keyApi=your-billing-service-key

3. Соберите проект
   ```
   mvn clean install
   ```  

4. Запустите приложение:

    ````
    java -jar .\apiFnsBilling.jar spring.config.location=/config
     
    ````

## /config путь к папке с фалом **`application.properties`**

#### Сервис ожидает запрос по адресу:
`http://localhost:4002/api/fns/checkInn?key=ваш ключ данного сервиса из конфигурации&inn=0000000`

Сервис при запросе обращается к сопутствующему сервису для разрешения запроса и ожидает ответ вида:

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    {
     "status": "ОК", 
     "message": "Поиск разрешен!", 
     "code": 0 
    }
 -------------------------------------------
{
    "status": "Сбой",
    "message": "Запрос был выполнен ранее",
    "code": 1
}
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
После положительного ответа от сервиса идет обращение в ФНС и Возвращает результат.

## Формат вывода
```
{
"inn": "4205258720",
"ogrn": "1134205001941",
"fullName": "ОБЩЕСТВО С ОГРАНИЧЕННОЙ ОТВЕТСТВЕННОСТЬЮ \"СИСТЕМЫ ТЕЛЕКОМ\"",
"ogrnDate": "2013-01-29",
"status": "Действующее",
"fullAddress": "обл. Кемеровская, г. Кемерово, пр-кт Шахтеров, д.68, к.А, пом.199",
"mainActivity": "Деятельность в области связи на базе беспроводных технологий",
"foundIn": "ИНН",
"terminationDate": null,
"countCheck": "14"
}
```

## 📌 API Endpoints

### Работа сервиса

- GET /api/fns/checkInn?key={access_key}&inn={inn_number} - Запрос информации о компании
- GET /api/fns/stat?key={access_key} - Запрос информации о подписки ФНС
 
### 📂 Структура проекта

````
apiFnsBilling/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── ru.company.apiBilling.FNS/
│   │   │       ├── classesError/         # Классы для вывода ошибок
│   │   │       ├── controllers/          # API контроллеры
│   │   │       ├── dto/                  # Data Transfer Objects
│   │   │       ├── jsonSerializeObject/  # Сущности JSON
│   │   │       ├── responseBilling/      # Сущность сопутствующего сервиса м HTTP клиент
│   │   │       └── services/             # Бизнес-логика
│   │   └── resources/
│   └──     └── application.yaml          # Конфигурация
├── pom.xml                               # Maven конфигурация
└── README.md                             # Этот файл
````

### 👨‍💻 Автор:

- Данил Примеров

   - Email: pdv_90@mail.ru

   - GitHub: DanilPV

### 📜 Лицензия
Этот проект распространяется под лицензией MIT. Подробнее см. в файле LICENSE.

## Этот README содержит:
- **1. Бейджи для визуального выделения ключевой информации**
- **2. Четкое описание возможностей**
- **3. Инструкции по установке**
- **4. Документацию API**
- **5. Описание технологического стека**
- **6. Структуру проекта**

 