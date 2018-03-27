#criando imagem do postgreSQL
sudo docker build -t mdb-banco ./postgres
sudo docker run -p 5433:5432 -d --name banco mdb-banco

#criando a imagem do modulo global
sudo docker build -t mdb-atividade .
sudo docker run -p 8082:8080 -d --name mdb-atividade --link banco:host-banco mdb-atividade
