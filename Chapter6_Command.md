# 커맨드 패턴 : 호출 캡슐화 

메서드 호출을 캡슐화해서 객체가 어떻게 일하는지 알지 않고도 컴퓨팅을 호출할 수 있고, 캡슐화된 메서드 호출로 로그나 되돌리기 등을 만들 수 있음

요청을 캡슐화해 원격에서 요청을 하면, 명령을 받은 객체는 그것을 실행함
원격 클라이언트는 계산이 어떻게 이루어지는지 모름

### 플로우

Client : createCommandObject()
    ->setCommand()->execute()->action1(),action2()
    ->Receiver

### 커맨드 객체 구현

모든 커맨드 객체가 구현하는 동일한 인터페이스

```java
public interface Command{
    public void execute();
}
```

이를 구현한 불 켜기 커맨드

```java
public class LightOnCommand implements Command{
    Light light;
    public LightOnCommand(Light light){
        this.light = light;
    }
    public void execute(){
        light.on();
    }
}
```

##### 커맨드 객체 사용

원격 리모콘 버튼

```java
public class SimpleRemoteControl{
    Command slot;
    public SimpleRemoteControl(){}
    public void setCommand(Command command){
        slot = command;
    }
    public void buttonWasPressed(){
        slot.execute();
    }
}
```

### 정의

커맨드 패턴은 요청을 객체로 오브젝트화해서, 다른 요청을 가진 다른 객체들을 매개변수화해서 큐, 로그하거나 되돌릴 수 있도록 함

* 커맨드 객체는 요청을 리퀘스트화해 요청을 받는 사람의 행동들을 묶음

* 리시버는 execute() 메서드를 노출시킴

* 밖에서는 execute()가 있는 것만 암

* 명령을 패러미터화해서 갈아끼울 수 있게 만듬 (lightOn -> garageOpen)

* 큐, 로그, 되돌리기를 구현하기 위해 메타 커맨드 패턴을 사용함

##### 커맨드에 슬롯 부여

* 아까 Remote에서 객체에 슬롯을 부여함

여러개 부여해놓고 거기에 커맨드를 저장하는 것도 괜찮을 것 같음
리모콘을 `invoker`로 지정하고, 버튼이 눌러질 때마다 해당하는 커맨드를 실행할 것임