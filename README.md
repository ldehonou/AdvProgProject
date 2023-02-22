# AdvProgProject

## Docker compose

1. docker-compose up
2. Inside mysql container :
          1. Enter in mysql => mysql -u root -p password
          2. mysql> CREATE USER 'usernameall'@'%' IDENTIFIED BY 'ThePassword';
          3. mysql> grant all on *.* to 'usernameall'@'%';
