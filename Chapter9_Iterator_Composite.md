# 이터레이터, 컴포지트 패턴

Array, Stack, List, Hashtable 같은 컬렉션에 객체를 넣는 방법은 다양하다. 각자 장점과 트레이드오프가 있지만, 클라이언트는 이 객체들을 순환하고 싶어한다. 클라이언트는 어떻게 그것을 저장하는지 알지 않고도 순환할 수 있게 할 것이다. 그리고 어떻게 슈퍼컬렉션을 만들어서 한 경계점의 데이터 구조들을 넘나들을 수 있게 하고, 객체 책임에 대해 하나나 두개 정도 배울 수 있다.

### Array를 사용하는 한 클래스, ArrayList를 사용하는 다른 클래스

두 객체를 사용하는 Waitress

```java
public void printMenu(){
    PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
    ArrayList breakfaseItems = pancakeHouseMenu.getMenuItems();

    DinerMenu dineMenu = new DinerMenu();
    MenuItem[] lunchItems = dinerMenu.getMenuItems();

    for(int i=0;i<breakfastItems.size();i++){
        Menuitem menuItem = (MenuItem)breakfastItems.get(i);
        //...print getName(), getPrice(), getDesc()
    }
    for(int i=0;i<lunchItems.length;i++){
        Menuitem menuItem = (MenuItem)lunchItems.get(i);
        //...print getName(), getPrice(), getDesc()
    }
}
printBreakfastMenu()
printLunchMenu()
printVegetraianMenu()
isItemVegetarian()
```

이런 식으로 루프가 매우 증가함
변하는 것을 캡슐화해야 하므로, 루프를 캡슐화하는 것이 좋음

여기서 .get(), .size()와 \[i\], .length는 비슷한 것임

Iterator를 만들고, 이와 비슷하게 할 수 있음

```java
Iterator iterator = breakfastMenu.createIterator();
while(iterator.hasNext()){
    MenuItem menuItem = (MenuItem)iterator.next();
}

Iterator iterator = lunchMenu.createIterator();
while(iterator.hasNext()){
    MenuItem menuItem = (MenuItem)iterator.next();
}
```

### 이터레이터 패턴

Iterator{hasNext(), next()} 인터페이스를 구현해놓고, 객체 컬렉션에 구현할 수 있음

##### 정의

이터레이터 패턴은 집합 객체의 요소에 연속적으로 접근할 수 있게 해주며, 이는 집합 객체의 기반 표현을 노출시키지 않음

Menu의 두 가지 구현이 있지만, 그것에 상관하지 않고 통합적으로 접근할 수 있었음, 어떤 집합이라도 다형성적인 코드를 쓸 수 있음
이터레이터 패턴이 집합 객체에서 요소를 이동하는 책임을 가져감
클래스 다이어그램은 꽤나 팩토리 패턴과 닮음

* 다른 구현이 있음
first(), next(), isDone()으로 된 이터레이터가 있음

* 지금 구현한 것은 외부 이터레이터임
클라이언트가 이터레이터를 조종해서, next()를 호출하고 다음 요소를 얻음
내부 이터레이터는 이터레이터가 자체를 조종해서, 이터레이터에게 무엇을 할 것인지 알려줘야 함
내부 이터레이터는 덜 유연하지만, 사용할 연산을 이터레이터에 넘겨주므로 사용하기 쉬움

* ListIterator를 사용하면 previous()를 제공해서 뒤로 가는 이터레이터를 사용할 수 있음, List를 구현하는 집합 객체에 사용

* Hasttable같은 unordered 이터레이터는 안에서도 내재적으로 unordered임

순서가 있는지는 컬렉션의 속성과 구현에 따라 다름

* 다형성적인 코드는 컬렉션이 어떻게 구현되있는지는 몰라도 코드를 다형성적으로 순환할 수 있음

* 자신이 구현한 Iterator를 사용하고 있고, 이미 빌트인 Iterator를 사용 중일 때에는 자신의 Iterator에 util.Iterator를 확장해 줘야 함
### 디자인 원칙

클래스는 하나의 변경 이유만 있어야 함
클래스의 모든 책임은 잠재적인 변경의 영역이기도 함
클래스의 책임이 하나 이상 있으면 변경할 곳이 하나 이상 있다는 뜻임

##### 단일 책임

집합에 내부 컬랙션과 관련된 연산, 이터레이션 메서드를 같이 구현하면 어떻게 될까?
그렇게 되면 컬랙션이 변경되거나, 이터레이션 하는 방법이 변경되는 두 가지 변경이 일어날 수 있음

바뀔 곳이 두 가지 있으면 클래스가 바뀔 확률이 증가하고, 설계의 두 가지 측면에 영향을 끼칠 것임

클래스는 오직 하나의 책임을 져야 함

책임 분리는 가장 어려운 것이고, 설계를 부지런히 해서 시스템이 커질 떄 클래스가 두 개 이상의 방법으로 변경할 수 있는 신호를 감지해야 함

##### 응집도

클래스나 모듈이 단일 목적이나 책임을 가지고 있는지를 측정해줌

높은 응집도를 가지면 관련된 함수 집합에 대해 설계된 것을 뜻하고, 낮은 응집도를 가지면 관련 없는 함수들이 모여 있다는 뜻임

응집도는 단일 책임 원칙보다 더 일반적인 개념이지만, 밀접하게 관련되어 있음

### 자바 컬렉션 프레임워크

이 프레임워크는 클래스와 인터페이스 집합임 (ArrayList,Vector, LinkedList, Stack, PriorityQueue)
이 클래스는 java.util.Collection 인터페이스를 구현함

Collection(){
    add(), addAll(),clear(), contains(), containsAll(), equals(), hashCode(), isEmpty(), iterator(), remove(), removeAll(), retainAll(), size(), toArray()
}

해시테이블은 간접적으로 이터레이터를 지원함
key,value의 두 객체 세트를 사용하므로, 해시테이블에서 key()나 value() 하나를 받아 iterator()를 받을 수 있음

##### for in

Java 5부터 쓸 수 있음, 명시적 이터레이터 생성 없이 배열, 컬렉션을 이터레이트할 수 있음

```java
for(Object obj:colletion){

}
```

ArrayList를 사용하려면

```java
ArrayList items = new ArrayList();
items.add(new MenuItem("",""));
items.add(new MenuItem("",""));
for (MenuItem item:items){
    System.out.println(".."+items);
}
```

* for/in 타입 안전을 보장하려면 제네릭을 사용해야 함
