# 사전 작업

### 1. EC2 docker 설치
    1. sudo apt update
    2. sudo apt install apt-transport-https ca-certificates curl software-properties-common
    3. curl -fsSL https://download.docker/com/linux/ubuntu/gpg | sudo apt-key add -
    4. sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu bionic stable"

### 2. Docker rabbit mq 실행
    1. sudo docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 --restart=unless-stopped -e RABBITMQ_DEFAULT_USER=ddori -e RABBITMQ_DEFAULT_PASS=[패스워드] rabbitmq:management

