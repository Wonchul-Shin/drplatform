# DR(전력중개) 관리 플랫폼 
![대체 텍스트](images/domain_info.png)

## 도메인 설명
- DR: 전기 사용자가 감축한 전기를 전력시장에 판매하면, 금전적으로 보상을 받는제도
- KT는 수요관리업자로서 DR 참여 고객을 발굴, 전력감축을 안내, KPX로부터 받은 금액을 정산하는 역할 이행
- KPX는 전력감축이 필요한 상황이오면 수요관리사업자에게 전력 감축을 요청하며 이를 DR명령이라 부름
- 수요관리사업자는 즉시 고객사에게 전력 감축 요청을 전파해야 하며, 고객사는 사전에 등록했던 용량만큼 전기 사용량을 줄여야 함
- KT는 이미 수요관리사업자로서 고객들에게 전력 감축을 안내하고 정산금을 지급하는 업무를 진행하고 있지만, 별도 관리 툴이 없어 전달과정에서 오류나 지연이 발생할 수 있었음
- 전력감축을 안내하고 전력감축 이행 여부를 확인하는 시스템을 구현하여 통합적인 관리가 이루어 진다면, 운영 과정에서 정확성과 효율성을 크게 개선할 수 있을 것으로 예상됨

## Model
www.msaez.io/#/72932922/storming/drplatform

## 서비스 시나리오
1. 관리자가 DR명령을 시작/종료할 수 있다.
2. 고객이 현재 진행중인 멸영에 대하여 이행/불이행을 선택한다.
3. 고나리자는 실행중인 명령을 종료한다.
4. 명령이 종료되었을 때 한전에 전력사용량을 확인하고 실제 감축량만큼 유저의 포인트를 늘린다.

### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- dr
- response
- kepco
- user


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- dr
```
 http :8088/drs id="id" name="name" type="type" status="status" date="date" 
```
- response
```
 http :8088/responses id="id" userId="user_id" drId="dr_id" userCapacity="user_capacity" answer="answer" 
```
- kepco
```
 http :8088/kepcos id="id" drId="dr_id" userId="user_id" responseId="response_id" responseAnswer="response_answer" adjustPoint="adjust_point" isReal="isReal" 
```
- user
```
 http :8088/users id="id" name="name" point="point" capacity="capacity" 
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

