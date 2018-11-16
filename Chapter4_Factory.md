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

* 하나의 구체적 생성자만 있어도, 구현을 분리시키므로 유용함

* 생성자는 항상 abstract가 아니어도 됨

* 피자 타입을 넘겨받은 거에는 String type 대신enum을 쓰도록 해라

* 간단 팩토리와 팩토리 메서드 패턴은 다름, 간단 팩토리는 임시방편이지만 팩토리 메서드 패턴은 프레임워크임

* 팩토리 메서드 패턴은 객체의 의존성을 분산시킴

기존의 if else는 모든 피자를 스토어에 묶었다면, 팩토리 메서드는 스토어를 나눠 피자를 해당 스토어에 의존시킴

* 설계 원칙 (의존성 역전 원칙)

추상에 의존성을 부여하고 구체적 클래스에 의존성을 부여하지 말라.
Dependency Inversion은 상위레벨 컴포넌트가 하위레벨 컴포넌트에 의존하지 않도록 함, 모두 추상에 의존하고 있음
PizzaStore는 상위레벨 컴포넌트고 구체 클래스였으므로, 하위레벨 컴포넌트 Pizza와 의존적이어서는 안됨

* 의존성 *역전*인 이유

일반적으로 생각하는 객체지향 디자인을 반전하므로 (상위레벨 피자스토어가 하위레벨 피자에 의존하던 것 -> 하위레벨 피자들이 상위레벨 피자스토어에 의존하는 것)

* 의존성 역전 원칙을 어기지 않는 객체지향 디자인

변수들은 구체적인 클래스에 대한 참조를 가지면 안 됨, new 대신 팩토리를 쓸 것

클래스는 구체 클래스로부터 도출되면 안됨, 어기면 구체 클래스에 의존성이 생기는 것
추상 클래스나 인터페이스에서 도출하도록

기반 클래스의 어떤 구현된 메서드도 오버라이드하면 안됨
구현된 메서드를 오버라이드하면 기반 클래스를 추상이라고 볼 수 없게 됨

이걸 언제나 모두 지키면 프로그래밍을 못하므로,
언제 이 규칙을 어길 지 아는 것이 중요함
자주 변하지 않는 것은 (String 인스턴스화, 거의 변하지 않는 클래스의 구체적 인스턴스화)

자주 변하는 클래스는 팩토리 메서드 패턴으로 변화를 감싸는 것이 좋음

### 추상 팩토리 패턴

관련되거나 의존적인 객체들의 집합을 생성하는 인터페이스를 구체 클래스 지정 없이 제공 가능

실제로 제공되는 구체적인 제품을 알 필요 없이 추상적인 인터페이스를 제공함
클라이언트는 어떤 구체적인 제품으로 분리됨

### 정리

* 팩토리 메서드

객체를 생성하는데 클래스를 사용함(상속으로)
클래스를 확장하고 팩토리 메서드를 오버라이드함
인터페이스는 필요하지 않고 메서드 하나가 있으면 됨
인스턴스화할 객체를 클라이언트와 분리할 때, 클래스를 확장해서 팩토리 메서드를 구현

* 추상 팩토리

객체를 생성하는데 객체를 사용함(구성으로)
구성을 사용하므로 클라이언트는 여전히 구체적인 타입과 분리되어 있음
새 제품이 추가되면 인터페이스를 바꿔야 함

생성할 제품들의 묶음이 있을떄, 클ㄹ라이언트가 같이 있을 제품을 생성할 때