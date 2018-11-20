# 프록시 패턴

객체 접근 컨트롤

프록시는 제어하고 접근을 관리하며, 인터넷을 넘어 메서드를 호출할 수 있음
위에서 제작했떤 껌 기계의 리포트를 작성해볼 것임

### 원격 프록시의 역할

원격 프록시는 원격 객체의 지역 대표 역할을 함
원격 객체는 다른 JVM의 힙에 위치한 오브젝트임
지역 대표는 원격 객체로 포워드할 수 있는 지역 메서드임

클라이언트는 원격 메서드를 호출하는 것 처럼 보이지만, 지역 프록시의 메서드를 호출함. 지역 프록시는 저레벨 네트워크 통신 세부사항을 처리함

### Remote Method Invoke

자바에서 원격 힙에 있는 메서드를 호출할 수 있음

클라이언트 헬퍼는 메서드를 서비스 헬퍼에게 보내고, 결과를 받은 서비스 헬퍼는 패킹해서 클라이언트 헬퍼로 보냄

네트워킹은 실패할 수 있고, 예외를 던질 수 있어서 클라이언트는 위험을 알아야 함

클라이언트 헬퍼 : RMI STUB
서버 헬퍼 : RMI SKELETON

### 5단계

* Remote Interface 만들기

* Remote Implementation 만들기

* rmic로 stubs, skeletons로 만들기

`rmic MyServiceImpl`

* RMI Registry 시작 (rmiregistry)

`rmiregistry`

* 원격 서비스 시작

`java MyServiceImpl`

##### Remote Interface 만들기

* java.rmi.Remote 확장

* RemoteException 처리

* 모든 매개변수가 원시형이거나 Serializable이어야 함

```java
import java.rmi.*;

public interface MyRemote extends Remote{
    public String sayHello() throws RemoteException;
}
```

##### Remote Implementation 만들기

* Remote Interface 구현

```java
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote{
    public MyRemoteImpl() throws RemoteException{

    }
    public String sayHello(){
        return "Server says, 'Hey'";
    }
}
```

* UnicastRemote 확장

생성자가 RemoteException 예외를 던짐
인스턴스화됬을 떄 상위 생성자는 무조건 호출되므로, 상위 생성자가 예외를 던진다면 하위 생성자도 예외를 던져야함

* RMI 레지스트리에 등록

리모트 서비스를 얻었으면, 인스턴스화해서 RMI registry에 넣어야 함
`rebind()` 메서드로 가능함

```java
try{
    MyRemote service = new MyRemoveImpl();
    Naming.rebind("RemoteHello", service);
}catch (Exception ex){/*...*/}
```

##### rmic를 stubs, skeletons로 만들기

Remote 인터페이스가 아닌 Remote 구현 클래스를 등록
_Stub, _Skel 네이밍 컨벤션을 가지고 있음

`rmic MyRemoteImpl`

##### rmiregistry 실행

클래스 파일이 있는 곳에서 `rmiregistry` 실행

##### 서비스 시작

`java MyRemoteImpl`

##### 서버 사이드 코드

* 인터페이스

```java
import java.rmi.*;

public interface MyRemote extends Remote{
    public String sayHello() throws RemoteException;
}
```

* 구현

```java

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote{
    public MyRemoteImpl() throws RemoteException{

    }
    public String sayHello(){
        return "Server says, 'Hey'";
    }
    oublic MyRemoteImpl() throws RemoteException{}
    public static void main(String[] args){
        try{
            MyRemote service = new MyRemoteImpl();
            Naming.rebind("RemoteHello", service);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
```

그러면 클라이언트는

```java
MyRemote service = (MyRemote)Naming.lookup("rmi://127.0.0.1/RemoteHello");
```
로 스텁 오브젝트를 받을 수 있음

##### 클라이언트 코드

```java
public class MyRemoteClient{
    public static void main(String[] args){
        new MyRemoteClient().go();
    }
    public void go(){
        try{
            MyRemote service = (MyRemote)Naming.lookup("rmi://127.0.0.1/RemoteHello");
            String s = service.sayHello();
            System.out.println(s);
        } catch(Exception e){e.printStackTrace();}
    }
}
```

여기서 클라이언트는 동적 클래스 다운로드를 실행해 클래스를 얻음

##### 주의사항

* `rmiregistry`를 실행해야 함

* 매개변수는 원시형이거나 Serializable을 구현해야 함

* 클라이언트에게 스텁 클래스를 줘야 함(`MyRemote.class`, `MyServiceImpl_Stub.class`)

* **RMI는 Deprecated됨**

어쨌든 각 객체에 대한 Remote 인터페이스를 만들어서 해당 객체를 조작함

### 프록시 패턴

대리자나 플레이스홀더를 제공해 다른 객체가 접근할 수 있도록 함

다른 객체에게 접근하는 대표 객체를 생성함. 다른 객체는 원격에 있거나 생성에 비싼 비용이 들 수 있고, 보안 필요성이 있을 수 있음

### 가상 프록시 생성

생성에 비싼 객체를 대표하는 것
객체 생성을 필요할 때까지 미룰 수 있음

* 네트워크에서 CD 커버를 받아오는 가상 프록시 개체

```
Icon:Interface
    ->ImageIcon
    ->ImageProxy
```

ImageProxy는 먼저 이미지아이콘을 불러와서 networkURL에서 로드하기 시작함
로드되는 동안 `Loading CD Cover..`를 표시함
이미지가 로드되면 ImageProxy는 모든 메서드 호출을 이미지 아이콘에게 위임함(paintIcon(),getWidth(), getHeight()))
새 이미지를 요청하면, 새 프록시를 만듬

* 할 만한 것

메뉴로 다른 CD 커버를 로드하기
loading 메시지가 뜰 때 윈도우를 리사이즈하기, proxy는 스윙 윈도우와 관계없이 로드를 처리하고 있음
새 CD를 추가하기

### 질문

* 원격 프록시와 가상 프록시는 달라 보이는데, 패턴인가?

프록시 패턴은 메서드 호출을 가로채는 것임

* 이미지프록시는 데코레이터처럼 보임

목적이 다름, 데코레이터는 행동을 추가하고, 프록시는 접근을 제어함
프록시는 ImageIcon을 분리했고, 로드되기 전까지 접근을 제한했음

* 클라이언트가 어떻게 프록시를 쓰게 할 것인가?

팩토리를 제공하면 됨

* 이미지프록시가 예전 값들을 캐시할 수 있지 않나?

*캐시 프록시*라는 가상 프록시를 만들 수 있음

* 어댑터 패턴과는 어떻게 다른가?

어댑터 패턴은 인터페이스를 바꾸지만, 프록시는 같은 인터페이스를 구연함
*보호 프록시*라는 것도 있는데, 클라이언트의 역할에 따라 메서드 호출을 제한할 수 있음

### Java API로 보호 프록시 만들기

`java.lang.reflect`

패키지로 하나 이상의 인터페이스를 구현하고 지정한 클래스로 메서드 호출을 위임할 수 있음
프록시 클래스가 런타임에 실행되서, `동적 프록시`임

여기서 추가되는 건..
Proxy->InvocationHanler{invoke()} <-invocationHanler{}:interface

##### 문제 정의

매치메이킹 시스템을 만드려고 함
자기 자신에게 rating을 매겨서는 안 됨


##### 동적 프록시 생성 단계

* InvocationHandlers 2개를 만듬

InvocationHandlers는 프록시의 행동을 구현함
자바가 프록시, 오브젝트를 만드므로, 처리기를 제공해야 함

* 동적 프록시를 만드는 코드를 만듬

프록시를 만들고 인스턴스화함

* `PersonBean` 객체를 감싸는 적절한 프록시 생성

###### InvocationHandler 만들기

소유자를 위한 호출 핸들러, 비소유자를 위한 핸들러를 만듬
인터페이스는 invoke()만 가지고 있음

```java
proxy.setHotOrNotRating(9);
->invoke(Object proxy, Method method, Obejct[] args)
```

핸들러는 요청이 어떻게 되야 하는지 결정하고, 실제 객체에 던짐

return method.invoke(person, args);

```java
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
        try{
            if(method.getName().startsWith("get")){
                throw new IllegalAccessException();
            } else if(method.getName().equals("setHotOrNotRating")){
                return method.invoke(person, args);
            } else if(method.getName().equals("set")){
                throw new IllegalAccessException();
            }
        } catch (InvocationTargetException e){
            e.printStackTrace();
        }
        return null;
    }
```

###### Proxy 클래스 생성 및 인스턴스화

동적으로 프록시를 생성하고 인스턴스화하게 둠

```java
PersonBean getOwnerProxy(PersonBean person){
    return (PersonBean)Proxy.newProxyInstance(
        person.getClass().getClassLoader(),
        person.getClass().getInterfaces(),
        new OwnerInvocationHandler(person)
    );
}
PersonBean getNonOwnerProxy(PersonBean person){
    return (PersonBean)Proxy.newProxyInstance(
        person.getClass().getClassLoader(),// Subject 클래스로더
        person.getClass().getInterfaces(),// 구현이 필요한 인터페이스 집합
        new NonOwnerInvocationHandler(person)
    );
}
```

이후 PersonBean을 얻을 때 해당 메서드를 사용하면 됨

### 다른 프록시들

* Firewall Proxy

네트워크 자원의 접근제어

* Smart Reference Proxy

참조될 떄마다 추가 행동을 함

* Caching Proxy

비싼 연산 결과를 저장하는 임시 저장소
여러 클라이언트를 공유할 수 있음

* 동기화 프록시

다중쓰레드의 주제에 안전한 접근을 제공함

* 복잡성 숨기기 프록시

페케이드 프록시라고도 불림
프록시 접근제어도 담당함

* Copy-on-Write 프록시

객체 복사를 클라이언트가 필요할 때까지 지연시킴