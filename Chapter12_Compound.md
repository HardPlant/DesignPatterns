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

##### View

DJ 뷰는 BPMObserver, BeatObserver의 정보를 보여줌

BPM을 변경할 수 있음

뷰에 대해 아무런 가정을 하지 않고, 옵저버 패턴을 이용해 만들어짐


##### Controller

전략 패턴의 전략 부분임
뷰에 인터페이스가 저장되고, 인터페이스 구현의 구체적인 부분임

##### 실행

모델 인터페이스로 비트모델을 생성해서, 모델으로 컨트롤러를 만듬

### 전략 패턴과 어댑터 패턴

하트비트를 출력하도록 하는 클래스

HeartModel{getHeartRate(), registerBeatObserver(). registerBPMObserver(), /*...*/}

##### HeartModelInterface

BeatModelInterface를 어댑트해서 만들기로함

##### HeartController

모델을 컨트롤하는 컨트롤러

### MVC와 웹

##### MVC

1. View -> Controller

2. Controller -> Model

3. Controller가 뷰 변경

4. Model이 View에게 변경됨을 알림 (notifyObservers)

5. View가 변경된 정보를 Model에게 요청함 (update)

##### MVC2

browser/server 모델에 맞는 MVC를 만들어냄
MVC2, Model 2로 명명하고 서블릿, JSP와 사용함

1. Client -> Controller(/Servlet)

클라이언트가 요청(폼 입력값 등)을 받으면 컨트롤러가 받음

2. Controller -> Bean 인스턴스화

서블릿이 컨트롤러로서 요청을 처리하고, 요청 처리 결과는 JavaBean 형태로 번들됨
인스턴스화된 Bean은 데이터베이스에 요청하는 등의 일을 함

3. Controller -> JSP/View

뷰는 JSP로 나타내지고, JSP는 모델에 따라 페이지를 만듬

4. JSP <-> View

다음 활동을 위한 컨트롤을 만듬

5. JSP를 HTTP 응답으로 보냄

페이지가 브라우저에게 리턴되어 뷰로 표시됨
사용자는 다른 요청을 보내는 등 일을 함

##### 의의

웹을 만드는 사람은 Model 2 스타일 JSP, HTML을 처리하고 서블릿을 아는 개발자들은 느슨하게 연결되어 자바를 처리하게 만듬

### Model 2

* 모델 고치기

* 서블릿 컨테이너 만들기

* HTML 뷰 만들기

##### 디자인 패턴과 Model 2

MVC2는 MVC 패턴의 웹 버전임
뷰는 JSP로 만들어졌고, 더 이상 모델의 리스너가 아님
컨트롤러는 HTTP 요청을 받는 서블릿임

교과서적인 MVC는 아니지만, 여전히 패턴이 있음

* Observer

모델이 상태 변화를 받지 않지만, 모델이 변했을 때 간접적으로 알림을 받음
컨트롤러는 뷰에게 모델의 상태를 받는 빈을 보내는 것도 가능함

브라우저 모델에서, 뷰는 HTTP 응답을 받았을 때만 상태 정보를 업데이트하면 됨

* Strategy

전략 오브젝트는 여전히 컨트롤러 서블릿임
직접적으로 뷰와 구성되어 있지는 않지만, 다른 행동을 원할 때 뷰에 다른 컨트롤러를 끼울 수 있음

* Composite

HTML은 컴포지트 패턴같은 객체 시스템이 있음

#####

* 컨트롤러는 애플리케이션 로직을 구현하나

컨트롤러는 뷰의 행동을 구현하고, 모델의 행동을 뷰의 행동으로 번역할 수 있을 정도로 똑똑함

모델이 애플리케이션 로직을 정함.
컨트롤러는 모델의 어떤 메서드 콜을 할 것인지 정하지만, 애플리케이션 로직을 정하지는 않음