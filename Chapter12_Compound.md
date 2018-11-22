# 컴파운드 패턴

패턴의 패턴

MVC 패턴은 컴파운드 패턴 중 하나임

### 오리 시뮬레이터

* Quackable 인터페이스 만들기

* Duck 만들기

* DuckSimulator 만들기

##### 거위 추가하기

GooseAdapter 추가

##### Duck 클래스 바꾸지 않고 Quack에 카운트 기능 추가하기

static int count를 추가하는 데코레이터

##### 이미 데코레이트된 객체 반환하기

팩토리로 관리

##### 오리 무리 관리

컴포지트 패턴

### 안전 대 투명성

컴포지트 패턴은 컴포지트와 리프 노드를 정확히 같은 메서드 셋을 갖게 하는ㄷ데, MenuItem()에 add()를 하는 것 같은 말이 안 되는 것도 가능함.
컴포지트와 리프의 간격이 투명한 것이 이점임

하지만 여기서 우리는 Duck()에게 add() 메서드를 주지 않아서 더 안전하지만, 덜 투명함. 클라이언트는 Flock()에 Quackable을 넣는 것을 암

### 오리 상태 관리

옵저버 패턴

### 회고

* Quackable로 시작

* goose가 Quackable로 행동하고 싶어서 GooseAdapter를 만듬

* Quackologist가 quack을 세고 싶어서 CountingDecotrator를 만듬

* CountingDecorator를 추가해주는 AbstractDuckFactory를 만듬

* 오리, 거위, Quackables를 추적하기 위해 컴포지트 패턴을 사용함

* Quackables가 Quack()했을 때 알림받음

### MVC

##### 전략

* View : 모델을 표현함

* Controller : 사용자 입력을 받고 무엇을 의미하는지 모델에게 집력함

* Model : 데이터, 상태, 애플리케이션 로직을 가짐

* 컨트롤러는 모델의 옵저버가 됨, 몇몇 설계는 컨트롤러에 모델을 등록하고 변경을 받음

* 컨트롤러는 입력을 해석하고 모델을 입력 기반으로 조작할 채깅ㅁ이 있음

* 뷰에 코드를 작성하면 뷰 코드가 복잡해지고 두 가지 책임을 갖게 만들고(UI 관리, 모델 조작 로직), 뷰와 모델이 강하게 결합됨

##### 옵저버

* Model은 옵저버블하고, 다른 View, Controller는 옵저버임

* Model이 notifyObservers()하면 다른 뷰, 컨트롤러들은 그것을 받음

##### 전략

View는 컨트롤러에게 행동을 위임해서 입력값을 넘기면 맞는 컨트롤러가 찾음

##### 컴포지트

View의 앞 부분 paint()는 모든 창에 있음

### DJ Java

##### BeatModelInterface 구현

Beat, BPM 옵저버가 볼 수 있는 주제임

##### DJ Java View



