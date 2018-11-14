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