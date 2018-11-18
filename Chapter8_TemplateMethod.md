# 템플릿 메서드 패턴

지금까지 객체 생성, 메서드 호출, 복잡한 인터페이스를 캡슐화했음
이제 알고리즘을 캡슐화할 차례임

```java
public class Coffee{
    void prepareRecipe(){
        boilWater();
        brewCoffeeGrinds();
        pourInCup();
        addSugarAndMilk();
    }
    public void boilWater(){
        System.out.println("Boiling Water");
    }
    public void brewCoffeeGrinds(){
        System.out.println("Dripping Coffee through filter");
    }
    public void pourInCup(){
        System.out.println("Pouring into cup");
    }
    public void addSugarAndMilk(){
        System.out.println("Adding Sugar and Milk");
    }
}
```

커피가 이렇고..

```java
public class Tea{
    void prepareRecipe(){
        boilWater();
        steepTeaBag();
        pourInCup();
        addLemon();
    }
    public void boilWater(){
        System.out.println("Boiling Water");
    }
    public void steepTeaBag(){
        System.out.println("Steeping the tea");
    }
    public void pourInCup(){
        System.out.println("Pouring into cup");
    }
    public void addLemon(){
        System.out.println("Adding Lemon");
    }
}
```

차가 이런데, 메서드 두 개는 전혀 바뀌지 않음
코드 중복은 디자인을 깨끗하게 만들 기회고, 비슷한 공통점을 추상화할 수 있음

```java
public abstract class CaffeineBaverage{
    final void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        addCondiements();
    }
    abstract void brew();
    abstract void addCondiments();    public void boilWater(){
        System.out.println("Boiling Water");
    }
    void pourInCup(){
        System.out.println("Pouring into cup");
    }
}
```
그리고 이를 확장한 메서드에서 brew(), addCondiments()를 추가하면 됨

템플릿 메서드 패턴은 알고리즘의 순서를 정의하고 서브클래스가 하나 이상의 단계를 구현하게 함
알고리즘의 프레임워크를 제공해주고, 알고리즘을 보호함

### 정의

알고리즘의 뼈대를 정의해놓고, 서브클래스에 몇몇 단계를 제공함

### 후킹

템플릿 메서드에 아무것도 하지 않는 hook() 메서드를 넣어놓고, 서브클래스가 **필요하면** 오버라이드할 수 있도록 함

```java
public abstract class CaffeineBaverage{
    final void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        if(customerWantsCondiments()){
            addCondiements();
        }
    }
    abstract void brew();
    abstract void addCondiments();    public void boilWater(){
        System.out.println("Boiling Water");
    }
    void pourInCup(){
        System.out.println("Pouring into cup");
    }
    boolean customerWantsCondiments(){
        return true;
    }
}
```

그리고 이 메서드를 사용하는 커피는..

```java
public class CoffeeWithHook extends CaffeineBeverage{
    //...
    public boolean customerWantsCondiments(){
        String answer = getUserInput();
        if(answer.toLowerCase().startsWith("y")){
            return true;
        } else {
            return false;
        }
    }
    private String getUserInput(){
        String answer = null;

        System.out.print("Would you like ... ");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        try{
            answer = in.readLine();
        } catch(IOException ioe){
            System.err.println("IOError");
        }
        if (answer == null) {
            return "no";
        }
        return answer;
    }
}
```