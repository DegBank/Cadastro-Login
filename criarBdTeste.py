import mysql.connector
from mysql.connector import errorcode

print("Conectando...")
try:
      conn = mysql.connector.connect(
            host='127.0.0.1',
            user='root',
            password=''
      )
except mysql.connector.Error as err:
      if err.errno == errorcode.ER_ACCESS_DENIED_ERROR:
            print('Existe algo errado no nome de usuário ou senha')
      else:
            print(err)

cursor = conn.cursor()

cursor.execute("DROP DATABASE IF EXISTS `bancoteste`;")

cursor.execute("CREATE DATABASE `bancoteste`;")

cursor.execute("USE `bancoteste`;")

cursor.execute("create table usuario (id_usuario int AUTO_INCREMENT PRIMARY key, nome_usuario varchar(45),senha_usuario varchar(45));")


# inserindo usuarios
usuario_sql = "insert into usuario (nome_usuario, senha_usuario) values ('admin', '1234');"
cursor.execute(usuario_sql)


conn.commit()

cursor.close()
conn.close()