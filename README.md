
# StarWars Rest Api

StarWars Api for the needs of the Job Process

BasicAuth:
- name: admin
- password: admin


 




## API Reference

### URL: http://localhost:8040/

#### Get random questions filtered by following parameters:



```http
  GET /characters
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `characters` | `String` | returns characters from the default page 1 |


```http
  GET /characters?page=2
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `page`  | `String` | returns characters from the page 2|

```http
  GET /characters/2
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`  | `String` | returns a character of queried id|








## Actuator

Actuator health is available under adress /actuator/health


## Technologies

 - Spring boot 2.7
 - REST
 - Spring security
 - Spring cache
 - Spring actuator