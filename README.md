# AdvProgProject

## Docker compose

1. docker-compose up
2. Inside mysql container :
- Enter in mysql => mysql -u root -p password
- mysql> CREATE USER 'usernameall'@'%' IDENTIFIED BY 'ThePassword';
- mysql> GRANT ALL PRIVILEGES ON *.* TO 'usernameall'@'%';
- Modify the persistence.xml by your user created
