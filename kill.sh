sudo docker stop mdb-atividade
sudo docker stop banco
sudo docker rm banco
sudo docker rm mdb-atividade
sudo docker rmi -f mdb-banco
sudo docker rmi -f mdb-atividade

