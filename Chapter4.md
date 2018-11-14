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

피자스토어를 추상 클래스로 만들어 NYPizzaStore, ChicagoPizzaStore...를 만들자

##### 서브클래스가 결정하도록 허락하기

이미 PizzaStore는 잘 갖춰진 주문 시스템을 갖춰져 있고, 모든 프렌차이즈가 일관되게 보장되게 하려고 함

뉴욕 피자는 얇은 크러스트, 시카고 피자는 굵은 크러스트 등이 있음
모든 바리에이션을 createPizza()에 넣고 맞는 종류의 피자를 생성할 책임을 부여함

피자스토어의 구체적 서브클래스가 잘 튜닝된 orderPizza() 메서드를 만들도록 함

PizzaStore{createPizza(), orderPizza()}
orderPizza() 중 createPizza()가 호출됨

서브클래스 NY, Chichago에는 createPizza()가 있음
다른 말로 얘들은 분리되있음

##### 프랜차이즈 피자스토어를 만들자

if else문을 잘 만들자
각 서브클래스별로 다르게.

##### 팩토리 메서드 결정

팩토리 메서드는 객체 생성을 처리하고 서브클래스로 캡슐화함
슈퍼클래스의 클라이언트 코드와 서브클래스의 객체 생성 코드를 분리함

### 팩토리 메서드 패턴

* Creator 클래스

PizzaStore{createPizza(), orderPizza()} // orderPizza() 중 createPizza() 호출
    ->NYPizzaStore{createPizza()}
    ->ChicagoPizzaStore{createPizza()}

* Product 클래스

Pizza
    -> (NY*Pizza)
    -> (Chicago*Pizza)

* 병렬적 접근

제품 정보를 각 생성자에게 캡슐화함

팩토리 패턴은 객체 생성의 인터페이스를 정의하고, 서브클래스에게 인스턴스화할 클래스를 결정하게 함
서브클래스로 인스턴스화를 지연시킴

