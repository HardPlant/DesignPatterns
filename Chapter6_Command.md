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