# B2W-marketplace  🚀

![Logo](https://www.cidademarketing.com.br/marketing/wp-content/uploads/2019/11/b2w_lojasamericanas.png)

This project is a challenge raised at github.com/CollabCodeTech/backend-challenges for the B2W Marketplace

## Roadmap
- [Information](#information)
- [API Reference](#api-reference)
- [Query - task2](#query---task2)
- [Docker](#docker)
- [Feedback](#feedback)

## Information

* To compile use **Java 17** ▶️
* Use `mvn clean install` to run the test suite via the command line ⏭️
* Use `mvn spring-boot:run` to start the API via command line ⏭️
* Attention, you must have [Maven](https://dicasdejava.com.br/como-instalar-o-maven-no-windows/) installed and configured in an environment variable according to your OS ⚠️
* Finally I ask that for task 1 your computer is connected to wi-fi ⚠️

## API Reference

#### Get all items between dates | example:

```http
  curl "http://localhost:8080/challenge-backend/item?begindate=05-10-2016&finaldate=10-10-2016"
```

| Parameter | Type     | Description                |
| :-------- | :------- |:---------------------------|
| `begindate` | `string` | **Required**. *Start date* |
| `finaldate` | `string` | **Required**. *End date*   |

Takes two dates and returns the products registered between them

## Query - task2
For task2, open the task2 folder at the root of the project, 
there you will find a *task2.sql* file, it contains the steps to 
create the database, populate it and run the query

## Docker
To load the Docker container with the MySQL 5.7 database,
go to the dev folder at the project's root and run the
`docker-compose up` command. Then connect in MySQL
with the data below, use your preferred client.

| Host        | Port   | Database | User   | Password   |
|:------------|:-------|:---------|:-------|:-----------|
| `localhost` | `3306` | `db`     | `user` | `password` |

## Feedback
If you have any feedback, please contact me: linkedin.com/in/matheus-vidal-6267b118a/

[🔝](#b2w-marketplace)