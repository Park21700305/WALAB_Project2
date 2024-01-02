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

## 스크린샷

화면 캡처는 프로젝트의 주요 기능을 보여줍니다. 이 이미지는 사용자 인터페이스 및 주요 기능을 시각적으로 보여주는 데 도움을 줍니다.

*Lombok, javax.persistence, json-simple 의존성 라이브러리를 포함하여 프로젝트를 빌드해야함*