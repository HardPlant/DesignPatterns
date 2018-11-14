# Decorator Pattern

* 상속의 디자인적 면

클래스를 객체 구성으로 데코레이트하는 법
기저 클래스의 코드를 바꾸지 않고 새 책임을 부여하는 법

### 스타버즈

Beverage{getDescription(), cost{}}
    ->HouseBlend{cost()}
    ->Decaf{cost()}
    ->Espresso{cost()}

커피 수가 매우 많으면?

### 개방/폐쇄 원칙

* 변경에는 닫혀 있고 확장에는 열려 있음

코드를 변경하지 않고 행동을 변경시킬 수 있어야 함

코드가 확장될 수 있는 부분을 고를 수 있는 게 중요함
모든 곳에 OCP를 적용하는 것은 낭비고 필요하지도 않고 복잡하며 이해하기 어려운 코드를 만들 수 있음

### 데코레이터 패턴

* 음료 가격 시스템 -> 클래스가 폭발하고 설계는 경직되며 기반 클래스의 확장이 일부 서브클래스에 적절하지 않음

음료로 시작해서 *런타임*에 첨가물을 데코레이트함
다크 로스트에 모카, 휘핑을 넣으면

* DarkRoast 객체를 가져다가

* Mocha 객체를 데코레이트하고

* Whip 객체를 데코레이트하고

* cost() 메서드를 불러서 첨가물 가격함수들에게 위임함

이는 곧..

* 데코레이터는 데코레이트하는 객체와 같은 슈퍼타입을 가짐

* 한개 이상의 데코레이터로 객체를 감쌀 수 있음

* 데코레이터는 대상 객체와 같은 슈퍼타입을 가지고 있어, 데코레이트된 객체를 원래 객체의 위치에 가져다놓을 수 있음

* 데코레이터는 객체의 행동의 전이나 후에 자신의 행동을 놓고 데코레이트되는 객체에 나머지 일을 하도록 위임함

* 객체는 언제나 데코레이트될 수 있으므로, 동적으로 많은 데코레이터를 데코레이트할 수 있음

##### 정의

객체에 동적으로 추가적인 책임을 부여함
데코레이터는 기능을 확장하는 데 서브클래스보다 유연한 대체제를 제공함

Component{methodA(), methodB()}
    -> ConcreteComponent{methodA(), methodB()}
    -> Decorator{methodA(), methodB()}
        -> ConcreteDecorator{wrappedObj:Component, methodA(), methodB(), newBehavior()}
        -> ConcreteDecorator{wrappedObj:Component,newState:Object, methodA(), methodB()}

각 컴포넌트는 데코레이터에 감싸질 수 있음
데코레이터는 HAS-A 컴포넌트임, 데코레이터는 컴포넌트를 참조하는 인스턴스 변수를 가지고 있음

##### 음료를 데코레이트하면..

Beverage
    -> HouseBlend
    -> DarkRoast
    -> CondimentDecorator
        -> Milk{beverage: Beverage, cost()}
        -> Mocha{beverage: Beverage, cost()}

##### 주의사항

* 데코레이터는 구체적인 컴포넌트 타입에 사용할 수 없음

* 구체적인 컴포넌트로 코드를 한다면 앱 디자인과 데코레이터 사용을 다시 생각해봐야 함

* 데코레이터는 통상적으로 팩토리, 빌더 패턴과 같이 쓰이며 데코레이터가 잘 캡슐화된 구체적인 컴포넌트를 생성하는 게 가능함

* 데코레이터가 중첩되도, 마지막에 PrettyPrint하는 데코레이터를 추가해 "Mocha, Some, Mocha"를 "2 Mocha, Some"으로 반환하는 행동이 가능함

### 실세계 데코레이터

자바 I/O에서 사용된 예로
```
LineNumberInputStream(  // 구체적 데코레이터, 라인 넘버를 읽는 능력 추가
    BuffferedInputStream(   // 구체적 데코레이터, 입력을 버퍼해서 성능 향상, readLine() 메서드를 추가해서 인터페이스 보강
        FileInputStream(File))) // 데코레이트되는 컴포넌트
```

실제 구조는

InputStream: (abstract component)
    -> FileInputStream
    -> StringBufferInputStream
    -> ByteArrayInputStream : 구체적 데코레이터
    -> FilterInputStream : 추상 데코레이터
        -> PushbackInputStream
        -> BufferedInputStream
        -> DataInputStream
        -> LineNumberInputStream : 모두 구체적 데코레이터