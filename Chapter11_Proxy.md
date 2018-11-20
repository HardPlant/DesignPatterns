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