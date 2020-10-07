CREATE DATABASE IF NOT EXISTS blogs_db;

CREATE USER blogs_user@localhost IDENTIFIED BY 'blogs';
GRANT ALL ON blogs_db.* TO blogs_user@localhost;