# AdvProgProject

## Docker compose

1. docker-compose up
2. Inside mysql container :
- Enter in mysql => mysql -u root -p password
- mysql> CREATE USER 'usernameall'@'%' IDENTIFIED BY 'ThePassword';
- mysql> grant all on *.* to 'usernameall'@'%';
