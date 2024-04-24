# NaeverStore
### 팀명 : 내이버 NAEVER 
### 프로젝트 명 : NAEVER STORE (내일배움캠프 스마트 스토어)
### 프로젝트 소개 : 사용자가 상점을 생성해 상품을 판매하거나 다른 상품을 구매하는 서비스 
### 프로젝트 계기 : 팀원들 모두가 가장 많이 접해본 사이트를 직접 만들어보고자 했습니다. 
---
### 기술 스택
 * 언어: <img src="https://img.shields.io/badge/kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white">
 * 프레임워크: <img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
 * 라이브러리: <img src="https://img.shields.io/badge/SpringSecurity-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white">
 * 데이터베이스: <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white">
 * 배포: <img src="https://img.shields.io/badge/Amazon Aws-232F3E?style=for-the-badge&logo=amazonaws&logoColor=white">
### ERD 
 ![image](https://github.com/NaeverStore/NaeverStore/assets/149165093/3796ff9d-515c-41c9-9d4b-b9c788091659)

---
### 와이어프레임 
![image](https://github.com/NaeverStore/NaeverStore/assets/149165093/464f6409-79af-472c-a9ed-e2187797a9b5)

---

### 프로젝트 기능
 * 사용자 인증 기능 
 * 프로필 관리 
 * 주문 CRUD 기능 
 * 리뷰 CRUD 기능 
 * 백오피스 기능(주문 관리)
 * AWS 를 이용한 서비스의 배포
 * 장바구니 기능
 * 상점, 상품 기능
---

### 내 담당 파트
 * 장바구니 기능
 * 3회 이내 비밀번호 사용 금지 기능
 * AWS를 이용한 배포
#### AWS를 이용한 배포
 * 프리 티어에서의 메모리 부족으로 인해 빌드가 느려서 거의 불가능하였다.
##### 빌드 파일을 EC2 내로 전송
 * CI/CD의 번거로움 증가
##### 스왑 메모리 활용
 * 디스크의 일부를 RAM처럼 사용하여 빌드 성공
#### Enverse의 활용!


 * 처음엔 3회 이내에 사용한 비밀번호 사용 금지를 위한 비밀번호 기록 엔티티 사용했었다.
 * 그런데, 비밀번호 기록 엔티티 관리가 번거로워서 개선이 필요하다고 느꼈다.
 * 업데이트 내역을 자동으로 기록하는 Enverse를 활용해서 이를 개선하였다.
![revision](https://github.com/tlsgkdns/NaeverStore/assets/24753709/fe62f020-873d-40b0-b58b-c7b4bfaf7d1e)
> RevisionRepository를 상속받아서

![3회](https://github.com/tlsgkdns/NaeverStore/assets/24753709/0fe62144-f07f-4e8d-ba22-3a300d114d85)
> 비밀번호 이력을 자동적으로 기록한다. 
