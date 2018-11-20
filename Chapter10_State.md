# 스테이트 패턴

원래 전략 패턴과 상태 패턴은 날 때 분리된 쌍둥이임

### 자바 껌 기계

CPU를 껌 기계에 넣어서 재고를 감시하고 소비자의 만족도를 더 정확히 측정하려고 함

다음 상태가 있음

Has Quarterㄱ --Gumball Sold -->out of Gumball
ㄴNo Quarter    ㄴ

### 상태 머신 그리기

##### 상태 정의
No Quarter
Gumball Solid
Out of Gumball
No Quarter

##### 인스턴스 변수 만들기

```java
final static int SOLD_OUT = 0;
final static int NO_QUARTER = 1;
final static int HAS_QUARTER = 2;
final static int SOLD = 3;
int state = SOLD_OUT;
```

##### 행동 정의

inserts quarter
turns crank
eject quarter
dispense

##### 상태기계 클래스 작성

```java
public void insertQuarter(){
    if (state == HAS_QUARTER){
        System.out.println("You can't insert another quarter");
    } else if (state == SOLD_OUT){
        System.out.println("You can't inser a quarter, the machine is sold out");
    } else if (state == SOLD){
        System.out.println("Please wait, we're already giving you a gumball");
    } else if (state == NO_QUARTER){
        state= HAS_QUARTER;
        System.out.println("You inserted a quarter");
    }
}
```

확시ㄹ히 이 정의는 객체지향적이지도 않고, 변하는 것을 캡슐화하지 않고, OCP를 위반함

### 새 디자인

* State 인터페이스를 정의해서 Gumball 클래스의 모든 액션 메서드를 담음

* 기계 상태를 구현하는 모든 state를 State 클래스로 구현함

* 모든 조건절을 없애고 State 클래스에게 일을 하도록 시킴

```
State
    ..>SoldState
    ..>SoldOutState
    ..>NoQuarterState
    ..>HasQuarterState
```