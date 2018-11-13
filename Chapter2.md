# 객체를 아는 상태로 지속하기

### WeatherCast

|WeatherData|
|-----------|
|get() x 3  |
|measurementChanged()|

값이 바뀔 때마다 measurementChanged() 호출됨, 그게 있는 것만 암

### 옵저버 패턴

* 신문 출판자가 신문을 출판함

* 특정 출판자를 구독하면 신문이 배달됨, 구독을 유지하면 계속 옴

* 구독을 해제하면 배달이 멈춤

* 다른 사람들도 그럼

객체들 간에 일대다 관계를 만듬
한 객체의 상태가 변경되면 모든 의존하는 객체에게 이를 알림

##### 구조

* Subject 클래스는 register()/subscribe()로 구독자를 받음

* 받은 구독자는 옵저버 풀에 보관됨

* 데이터를 받으면 구독자들에게 전달함

* 풀에서 remove()/unsubscribe()를 받으면 제외됨

Subject{register(), remove(), notify()}와 Observer{update()} 인터페이스를 두고, 이를 구현한 ConcreteSubject는 {notifyObserver()}를 ConcreteObserver{update()}에서 호출받음

여기서 Subject의 상태는 하나임
Subject만 데이터를 갖고 있기 때문에, 옵저버는 Subject에 의존적임
많은 객체들이 직접 같은 데이터를 제어하는 것보다 깔끔함

### 느슨한 결합

두 객체가 상호작용할 수 있지만 각자에 대해 최소한의 지식을 갖고 있음

옵저버 패턴은 주제와 옵저버가 느슨하게 결합되어 있음

* 주제가 아는 것은 옵저버가 특정 인터페이스를 구현하는 것 뿐임

옵저버가 어떤 클래스인지, 무엇인지, 어떤 것이든 알 필요 없음

* 옵저버를 어떤 때에도 추가할 수 있음

주제는 옵저버 인터페이스 리스트에만 의존함
새 옵저버를 어느 때에도 넣을 수 있음
런타임에 교체해도 되고, 제거도 됨

* 새로운 타입의 옵저버를 추가하기 위해 주제를 수정하지 않아도 됨

주제는 옵저버가 뭘 하든 옵저버 인터페이스로 노티를 배달할 뿐임

* 주제/옵저버를 각각 제사용할 수 있음

둘이 강하게 결합되어 있지 않으므로

* 변경이 주제나 옵저버에 서로 영향을 주지 않음

### 자바 빌트인 옵저버 패턴

* Observable "클래스", Observer 인터페이스

* 옵저버가 되려면 Observer 인터페이스 구현

이후 Observable 클래스의 addObserver(), removeObserver() 호출

* Observable이 알림을 보내려면

setChanged()로 변경을 확인하고
notifyObservers()나 notifyObservers(Object arg)

* Observer가 알림을 받으려면

update(Observable o, Object arg) 메서드를 구현

o는 알림을 보내는 주제고, Object arg는 DO임

데이터를 옵저버에게 push하려면 notifyObserver(arg),
옵저버가 데이터를 받으려면 .. update()에서 obs를 덕타이핑(instanceof)

* setChanged()

먼저 설정하고 notify()를 호출해야 옵저버에게 알림을 감
데이터가 너무 자주 업데이트되서 주기를 설정할 필요가 있을 떄
clearChanged(), hasChanged() 등도 있음

