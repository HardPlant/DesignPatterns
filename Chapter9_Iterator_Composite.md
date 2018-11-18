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
