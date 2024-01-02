# WALAB_Project2
## 프로젝트 개요
- WALAB_Project2는 CRUD (Create, Read, Update, Delete) 기능과 파일 I/O를 통해 데이터를 관리하는 Java 프로젝트. <br>이 프로젝트는 기존의 Project 1을 확장하여 파일 기반 데이터 관리 기능을 추가하였음.

## 사용된 클래스 & 라이브러리
### 클래스
- main
  - Main: 프로그램의 시작점
- domain
  - User: 사용자 정보를 저장
  - Menu: 메뉴 정보를 저장
  - Order: 주문 정보를 저장
- service
  - UserService: 사용자 정보(주문 정보)를 관리
  - MenuService: 메뉴 정보를 관리
- view
    - UserView: 사용자 정보를 출력
    - MenuView: 메뉴 정보를 출력

### 라이브러리
- Lombok: Java 클래스의 보일러플레이트 코드를 줄이기 위해 사용(getter, setter, builder)
- javax.persistence: Java Persistence API를 사용
- json-simple: JSON 데이터 포맷을 사용하여 데이터를 읽고 쓰는 기능을 구현하는 데 사용

### 데이터 저장 포맷
이 프로젝트에서는 JSON (JavaScript Object Notation) 포맷을 사용하여 사용자 데이터와 메뉴 정보 등을 파일에 저장하고 관리
- readData(menuData.json) 미리 저장하여 읽기 위한 메뉴 데이터

  <img width="349" alt="스크린샷 2024-01-02 오후 9 41 19" src="https://github.com/Park21700305/WALAB_Project2/assets/93187535/c02a4e19-4bfa-44ae-9a7a-fcb0cdfdcee8">
- writeData(userInfoData.json) 기능7번 -> 회원가입한 유저정보를 저장

  <img width="428" alt="스크린샷 2024-01-02 오후 9 39 59" src="https://github.com/Park21700305/WALAB_Project2/assets/93187535/42adcc77-408e-4a3a-94a7-9d0b24b1da18">

  
## 스크린샷
<img width="722" alt="스크린샷 2024-01-02 오후 9 29 05" src="https://github.com/Park21700305/WALAB_Project2/assets/93187535/4be0b51f-24b3-4670-9e48-63c1f12bca88">
<img width="551" alt="스크린샷 2024-01-02 오후 9 29 18" src="https://github.com/Park21700305/WALAB_Project2/assets/93187535/e86b6b48-55b7-4b3e-b060-0791be667013">
<img width="513" alt="스크린샷 2024-01-02 오후 9 29 30" src="https://github.com/Park21700305/WALAB_Project2/assets/93187535/6b77638c-83e8-4e44-b37e-a8959ea2e233">
<img width="528" alt="스크린샷 2024-01-02 오후 9 29 39" src="https://github.com/Park21700305/WALAB_Project2/assets/93187535/ca22fcc9-4646-49d0-beee-aa33c1e783b4">
<img width="526" alt="스크린샷 2024-01-02 오후 9 29 50" src="https://github.com/Park21700305/WALAB_Project2/assets/93187535/51efad1c-9339-46bd-a3c6-4a72a4691e4d">
<img width="580" alt="스크린샷 2024-01-02 오후 9 29 57" src="https://github.com/Park21700305/WALAB_Project2/assets/93187535/b543f7f8-4745-4ebe-b88f-8c664cc23645">


*Lombok, javax.persistence, json-simple 의존성 라이브러리를 포함하여 프로젝트를 빌드해야함*
