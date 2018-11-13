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

