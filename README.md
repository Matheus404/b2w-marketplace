# B2W-marketplace

![Logo](https://www.cidademarketing.com.br/marketing/wp-content/uploads/2019/11/b2w_lojasamericanas.png)

This project is a challenge raised at github.com/CollabCodeTech/backend-challenges for the B2W Marketplace

## Roadmap
- API Reference
- Query - task2
- Docker
- Feedback

## API Reference

#### Get all items between dates | example:

```http
  GET http://localhost:8080/challenge-backend/item?begindate=05-10-2016&finaldate=10-10-2016
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
**docker-compose up** command. Then connect in MySQL
with the data below, use your preferred client.

| Host        | Port   | Database | User   | Password   |
|:------------|:-------|:---------|:-------|:-----------|
| `localhost` | `3306` | `db`     | `user` | `password` |

## Feedback
If you have any feedback, please contact me: linkedin.com/in/matheus-vidal-6267b118a/