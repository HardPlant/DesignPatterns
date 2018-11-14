# 팩토리 패턴

new 연산자는 구체적인 것을 만듬

```java
Duck duck;
if(picnic){
    duck = new MallardDuck();
} else if (huning) {
    duck = new DecoyDuck();
} else if (inBathTub) {
    duck = new RubberDuck();
}
```

코드가 이렇게 되기 시작한다면 유지보수와 업데이트가 어려워지고 에러발생가능하게됨

인터페이스를 코딩하면 새로운 클래스를 만들어도 인터페이스를 통해 다형성으로 처리할 수 있음

```java
Pizza orderPizza(String type){
    Pizza pizza;
    //....
    pizza.prepare();
}
```

객체의 세부 생성을 담당하는 팩토리

orderPizza()를 클라이언트로 만듬

### 간단한 피자 팩토리

```java
public class SimplePizzaFactory{
    public Pizza createPizza(String type){
        Pizza pizza = null;
        if(type.equals("cheese"){
            pizza = new CheesePizza();
        }//...
    }
    return pizza
}
```

* 문제를 다른 객체에 옮겨놓은 것 뿐이지 않나? : 많은 클라이언트를 가질 수 있음

* 스태틱 팩토리 : 인스턴스화 없이 사용할 수 있지만 서브클래스 불가, create() 메서드의 행동 변경 불가

사실 이건 디자인 패턴이 아니라 일종의 프로그래밍 숙어임

### 프랜차이즈된 피자 스토어

지역별로 다른 피자 팩토리?
피자스토어가 피자 팩토리를 구성할 수 있게 하기

```java
NYPizzaFactory nyfactory = new NYPizzaFactory();
ChichagoPizzaFactory chichagoFactory = new ChicagoFactory();
//...
```

### 피자 스토어 프레임워크

