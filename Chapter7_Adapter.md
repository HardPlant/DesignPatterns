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