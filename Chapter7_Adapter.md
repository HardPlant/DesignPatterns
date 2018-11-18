# 어댑터 패턴

인터페이스를 받아서 다른 클라이언트에게 맞추는 인터페이스

기존 시스템과 납품자 시스템 사이에서 중간자 역할을 함
두 코드를 바꾸지 않을 수 있음

```java
public class TurkeyAdapter implements Duck{
    Turkey turkey;

    public TurkeyAdapter(Turkey turkey){
        this.turkey = turkey;
    }
    @Override
    public void quack() {
        turkey.qubble();
    }
    @Override
    public void fly() {
        for(int i=0;i<5;i++){
            turkey.fly();
        }
    }
}
```

```java

        WildTurkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey);
        
```

### 순서

* 클라이언트가 요청을 보냄

* 어댑터가 요청을 어댑티에 맞게 번역함

* 어댑티는 요청을 전달해 결과를 보냄, 이 과정에서 클라이언트는 요청이 어떻게 처리됬는지 모름

##### 큰 인터페이스를 어댑트하려면 많은것을 구현해야 하지 않나?

인터페이스를 받는 클라이언트 코드를 재작업하는 것보다는 낫고, 클래스의 변경을 캡슐화하는 한 개의 클래스만 만들 수 있음

#### 어댑터는 오직 하나의 클래스만 래핑하나?

한 인터페이스를 다른 것으로 바꾸는 게 어댑터 패턴의 역할임
Facade 패턴에서 두 개 이상의 어댑티들을 감싸는 것을 할 것임

#### 오래된 코드의 인터페이스와 새로운 코드 인터페이스를 어떻게 맞ㅊ는가?

두 인터페이스를 지원하는 2-Way 어댑터를 만들면 됨
두 인터페이스를 구현해놓고 오래된 인터페이스와 새 인터페이스처럼 사용하면 됨

### 정의

클래스의 한 인터페이스를 클라이언트가 예상하는 다른 인터페이스로 전환하는 패턴
어댑터는 서로 인터페이스를 지원하지 않는 클래스를 함께 동작하게 만듬

클라이언트를 구현된 인터페이스와 분리시킴

### 객체와 클래스 어댑터

두 종류의 어댑터가 있음, 위에서 설명한 것은 객체 어댑터임
클래스 어댑터는 다중 상속을 사용해야 하므로, 자바에서는 못 씀
(어댑터가 타겟과 어댑티를 상속하는 모양새)

### 실세계 어댑터

* 예전의 Enumerator

Vector, Stack, Hashtable같은 것들은 elements()를 구현하는데, 이 메서드의 반환값은 Enumeration임
Enumeration은 컬렉션의 종류을 알 필요 없이 반환 가능

* 지금의 Iterator

컬렉션이 업데이트되면서, Iterator 인터페이스를 만듬, 여기서는 iterate할 수 있고 remove()가 추가됨

지금 우리는 Enumerator를 사용하는 예전 코드를 Iterator만 사용하는 새 코드로 바꿀 것임

##### Enumeraion을 Iterator로 바꾸기

먼저 어떤 것들이 매핑되는지 알아보아야 함

|Iterator|   |Enumeration|
|--------|---|-----------|
|hasNext()|->|hasMoreElements()|
|next() |->|nextElement()|
|remove()|  |           |

##### 어댑터 디자인

타겟의 인터페이스(Iterator)를 구현해 어댑티가 사용하도록 구성함
```
EnumerationIterator implements Iterator:
    enum: Enumerator
    hasNext()
    next()
    remove()
```

##### remove() 메서드 만들기

Enumeration은 **읽기 전용** 메서드임, remove()를 완벽히 동작하게 구현할 수 없어서, 런타임 예외를 던지는 게 전부임
Iterator 인터페이스에는 `UnsupportedOperationException` 예외가 있음

##### EnumberationIterator 어댑터 작성

```java
public class EnumerationIterator implements Iterator{
    Eunumeration enum;
    public EnumerationIterator(Enumeration enum){
        this.enum = enum;
    }
    public boolean hasNext(){
        return enum.hashMoreElements();
    }
    public Object next(){
        return enum.nextElement();
    }
    public void remove(){
        throw new UnsupportedOperationException();
    }
}
```

### Decorator 패턴과 차이점

데코레이터 패턴은 책임을 추가함
어댑터는 클라이언트와 새로운 라이브러리 사이의 변환을 제공함
데코레이터는 어댑터같지만, 데코레이터는 책임을 추가하거나 행동을 추가하고 어댑터는 변환만 함

### Facade 패턴

인터페이스를 간단하게 만드는 패턴, 하나 이상의 클래스의 복잡성을 숨기기 위한 패턴임

##### 패턴의 의도

어댑터: 인터페이스 하나를 다른 것으로 바꾸기 위해
데코레이터 : 인터페이스를 변경하지 않고 책임을 추가하기 위해
페케이드 : 인터페이스를 간단하게 만들기 위해

##### 홈 시어터 시스템

Amplifier{tuner, dvdPlayer,CdPlayer;on(),off()}
Tuner{amplifier;on(),off(),..}
DvdPlayer{amplifier;on(),off()..}
CdPlayer{amplifier;on(),off()..}
Screen{up(),down()}
PopconPopper{on(),off(),pop()}
TheaterLights{on(),off(),dim()}
Projector{dvdPlayer;on(),off(),tvMode(),wideScreenMode()}

영화를 보려면..

* 팝콘기계를 켜고
* 팝콘을 튀기고
* 조명을 끄고
* 스크린을 내리고
* 프로젝터를 켜고
* 프로젝트 입력을 DVD에 넣고
* 프로젝터를 와이드스크린모드로 설정하고
* 앰프를 켜고
* 앰프를 DVD 입력으로 하고
* 앰프 서라운드 사운드를 켜고
* 앰프 볼륨을 조종하고
* DVD 플레이어를 켜고
* DVD 플레이어를 시작함

```java
popper.on();
popper.pop();
lights.dim(10);
screen.down();
projector.on();
projector.setInput(dvd);
projector.wideScreenMode();
amp.on();
amp.setDvd(dvd);
amp.setSurroundSound();
amp.setVolume(5);
dvd.on();
dvd.play(movie);
```

영화가 끝나면 꺼야 되고, CD와 라디오에도 대응 안되고, 시스템이 바뀌면 세부 내용을 조정해야 함

페케이드 패턴은 복잡한 서브시스템을 Facade 클래스를 구현해 쉽고 쓸 수 있는 인터페이스를 만듬

HomeTheaterFacade{watchMovie(),endMovie(),listenToCd(),endCd(),listenToRadio(),endRadio()}

페케이드 클래스를 만들어 이런 메서드들을 노출시키고, 홈 시어터 요소를 서브시스템으로 취급해 메서드를 구현하는데 사용함