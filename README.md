# 사전 작업

### 1. EC2 docker 설치
    1. sudo apt update
    2. sudo apt install apt-transport-https ca-certificates curl software-properties-common
    3. curl -fsSL https://download.docker/com/linux/ubuntu/gpg | sudo apt-key add -
    4. sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu bionic stable"

* [Ec2 docker 설치 참고 사이트](https://insight.infograb.net/docs/aws/installing-docker-on-aws-ec2/)

### 2. Docker rabbit mq 실행
    1. sudo docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 --restart=unless-stopped -e RABBITMQ_DEFAULT_USER=ddori -e RABBITMQ_DEFAULT_PASS=[패스워드] rabbitmq:management


# Getting

### rabbit MQ 아래 항목들을 Test 한다.
* producer -> send -> [ exchange -> route -> queue ] -> receive -> consummer 에 대한 이해를 돕기 위한 Test 소스
* exchange는 제일 활용도가 높은 topic을 구현한다
