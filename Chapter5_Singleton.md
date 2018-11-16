# 싱글턴 패턴

스레드풀, 캐시, 대화상자, 설정과 레지스트리 처리 객체, 로그 처리 객체, 디바이스 드라이버로 작동하는 객체같은 것들은 오직 하나만 존재해야 함

스태틱 변수, 전역 변수로 생성하는 것과는 다르며, 하나의 컨벤션임
단점 없이 전역 변수같은 전역 접속지점을 만들 수 있음

```java
public MyClass{
    private static MyClass uniqueInstance;

    private MyClass(){}
    public static MyClass getInstance(){
        if(uniqueInstance==null){
            uniqueInstance = new MyClass();
        }
        return uniqueInstance
    }
}
```

구현에 공개된 생성자가 없고, getInstance()로 받는 것이 핵심임

### 정의

클래스가 하나의 인스턴스만 가지고 있고, 전역 접근지점을 제공하는 것

### 쓰레딩을 할 때

이 정의는 쓰레드 안전하지 않음
한 쓰레드가 null 체크를 하고 있을 때, 다른 쓰레드가 객체를 생성하고, null 체크를 완료한 쓰레드가 객체를 다시 생성해 스태틱 변수에 할당하면 객체는 두개가 됨

```java
public MyClass{
    private static MyClass uniqueInstance;

    private MyClass(){}
    public static synchronized MyClass getInstance(){
        if(uniqueInstance==null){
            uniqueInstance = new MyClass();
        }
        return uniqueInstance
    }
}
```
getInstance()는 동기화를 해줄 필요가 있음