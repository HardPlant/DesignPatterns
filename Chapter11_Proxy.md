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

* rmic를 stubs, skeletons로 만들기

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

public interface MyRetmoe extends Remote{
    public String sayHello() throws RemoteException;
}
```

##### Remote Implementation 만들기

* Remote Interface 구현

```java
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote{
    public String sayHello(){
        return "Server says, 'Hey'";
    }
}
```




