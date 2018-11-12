# Chaper 1. Intro

## 상속, 인터페이스

fly(), quack() 중 일부만 사용해야 하는 문제

48개의 오리 서브클래스가 있음

상속 : 재사용을 위해 고안되었지만, 유지보수에 적합하지 않음
모든 오리에 대해 오버라이드해야 함

인터페이스 : 여전히 사용하지 않는 메서드에 대한 인터페이스를 구현해야 함
행동을 수정할 때 연관된 모든 클래스를 찾아 확인해야 할 필요가 있음

* 디자인 원칙

소프트웨어가 변하는 곳을 파악하고 변하지 않는 곳과 분리하라

변화하는 곳을 캡슐화해서 변경하거나 확장시켜라

## 변화하는 곳과 변하지 않는 곳을 분리

Duck():
    Behaviors:
        Fly()
        Quack()-quack, squeak, slilence

* 디자인 원칙

구현 말고 인터페이스를 프로그램해라

* supertype 프로그램하기

실제 객체 타입을 알지객 않고 모든 변수의 타입을 추상 메서드나 인터페이스로 프로그램
이후 슈퍼타입 변수를 가진 객체들이 구체적인 구현을 가질 수 있도록

직접 인스턴스화해 할당하는 것보다, 구체적 구현을 런타임에 할당

Animal animal = getAnimal(); // new Dog()를 하는 것 보다 더 supertype함

## 오리 행동 구현

FlyBehavior interface {fly()}
    ..> FlyWithWings
    ..> FlyNoWay

QuackBehavior interface {quack()}
    ..> Quack
    ..> Squeak
    ..> MuteQuack

## 행동 합치기

각 행동을 위임하는 것이 중요함

