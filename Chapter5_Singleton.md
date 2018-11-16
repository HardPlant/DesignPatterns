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

##### 성능 향상 기법

getInstance() synchronize는 꽤 비쌈

* getInstance()의 성능이 중요하지 않을 때

그냥 아무것도 하지 않으면 됨. getInstance()를 synchronize하는 것이 직관적인 구현임

* 항상 싱글턴 객체를 사용할 때

미리 만들어두면 됨

```java
public class Singleton{
    private static Singleton uniqueInstance = new Singleton();

    private Singleton(){}
    public static Singleton getInstance(){
        return uniqueInstance
    }
}
```

이렇게 하면 JVM이 클래스를 로드하는 즉시 싱글턴 객체를 만듬
JVM이 만드므로 어떤 스레드가 이 클래스에 접근하기 전에 생성이 완료된 상태가 됨

* 더블체크 록을 만들어 synchronization 감소

```java
public class Singleton{
    private volatile Singleton uniqueInstance;

    private Singleton(){}
    public static Singleton getInstance(){
        if(uniqueInstance == null){
            synchronized(Singleton.class){
                uniqueInstance = new Singleton();
            }
        }
        return uniqueInstance;
    }
}
```
* volatile 키워드는 쓰레드들이 싱글턴 객체를 초기화할 때 적절히 처리할 수 있도록 보장함

단, Java 1.4 이상에서 지원함

getInstance()의 성능이 중요하면 이 방법이 극적으로 오버헤드를 줄일 수 있음

* 서브클래스를 싱글턴으로 만들 때는 그것으로 얻을 수 있는 이득이 뭔지, 싱글턴 클래스가 많아진다면 디자인을 다시 생각해봐야 함
정 필요하다면 슈퍼클래스 생성자를 protected로 만들 수 있지만, 좋은 생각은 아님

* 전역 변수는 늦거나 빠른 인스턴스화를 할 수 없고, 네임스페이스를 위반할 수 있음