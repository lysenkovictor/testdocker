Docker-compose
* docker-compose.yml 

CURRENT_UID=$(id -u):$(id -g) \
docker-compose up --force-recreate --abort-on-container-exit --build

Docker CLI
* docker-cli.bash
