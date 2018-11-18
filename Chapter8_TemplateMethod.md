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

##### 주의사항

서브클래스는 모든 추상 메서드를 구현해야 함
추상 메서드의 수는 가능한 줄이는 게 좋음, 덜 세분화될 수록 유연성은 떨어짐
필수적이지 않은 단계는 훅으로 만드는게 서브클래스에 짐이 덜 됨

### 디자인 패턴

* 할리우드 원칙

우리를 부르지 말고, 우리가 널 부른다.

의존성 부패를 방지하기 위함임
고레벨 요소가 저레벨 요소에 의존하고, 저레벨 요소는 고레벨 요소에 의존하고, 고레벨 요소는 부가요소에 의존하고, 부가요소는 저레벨 요소에 의존하는 등이 있음
부패가 들어가면 누구도 시스템이 어떻게 설계되있는지 모름
저레벨 컴포넌트들은 고레벨 컴포넌트의 메서드를 호출하면 안됨


* 의존성 역전 원칙과 어떻게 연관되어 있는가?

의존성 역전 법칙은 가능한 한 구체적 클래스의 사용을 피하고 추상을 사용하라고 했고, 할리우드 원칙은 저수준의 컴포넌트가 연산을 후킹할 수 있는 프레임워크나 컴포넌트를 만들 때 사용하고, 거기서 의존성을 만들지 않을 수 있음.
모두 분리하는 목적을 가지고 있지만,  의존성 역전 원칙은 더 강력하고 일반적인 선언을 만듬.
할리우드 원칙은 저레벨 구조가 다른 클래스들이 너무 의존적이지 않게 상호운용할 수 있도록 설계할 수 있음

* 저레벨 객체가 고수준 객체의 메서드를 부르는 것을 허용하지 않는가?

저수준 객체는 종종 상속된 메서드를 부르는 일이 있지만, 저수준과 고수준 요소간 명시적인 순환 의존성을 만드는 것을 피할 수 있음

### 소트 예시

자바 Arrays 클래스에는 정렬 메서드가 있음

```java
public static void sort(Object[] a){
    Object aux[] = (Object[])a.clone();
    mergeSort(aux, a, 0, a.length, 0);
}
private static void mergeSort(Object src[], Object dest[], int low, int high, int off){
    for(int i=low; i<high; i++){
        for(int j=i; j>low &&
        ((Comparable)dest[j-1]).compareTo((Comparable)dest[j])>0; j--){
            swap(dest, j, j-1);
        }
    }
    return;
}
```

여기서 compareTo()는 Comparable 인터페이스의 메서드인데, 이 메서드를 구현함으로서 템플릿 메서드 패턴으로 만들어진 mergeSort()가 완성됨

##### compareTo()

이 메서드는 두 객체를 비교해서 하나가 적거나, 크거나, 같은지 반환함

```java
public class Duck implements Comparable{
    int weight;
    //...
    public int compareTo(Object object){
        Duck otherDuck = (Duck)object;
        if(this.weight < otherDuck.weight){
            return -1;
        } else if(this.weight == otherDuck.weight){
            return 0;
        } else {
            return 1;
        }
    }
}
```

* 인터페이스를 썼지만, 템플릿 메서드랑 하는 짓은 비슷함

위에 있는 템플릿 메서드는 아니지만, 여전히 의도는 같고, 알고리즘을 사용하는 데 `Arrays`를 서브클래싱하지 않아도 되므로 더 유연하고 사용하기 좋게 만든 것임

* 전략 패턴에 가깝지 않나?

구성을 사용하는 것 때문에 전략 패턴에 가깝지만, 전략 패턴은 알고리즘 전체를 구현하고, Arrays는 알고리즘 일부를 미완성으로 남겨놓고 compareTo()를 구현한 객체가 필요함

### 후킹 예제

JFrame이나 다른 Swing 컨테이너는 paint() 메서드를 상속받음, 이 메서드는 아무 일도 하지 않는 훅임
JFrame의 알고리즘에 그래픽 출력을 넣을 수 있음

```java
public class MyFrame extends JFrame{
    public MyFrame(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(300,300);
        this.setVisible(true);
    }
    public void paint(Graphics graphics){
        super.paint(graphics);
        String msg = "I rule!";
        graphics.drawString(msg, 100, 100);
    }
    public static void main(String[] args){
        MyFrame myFrame = new MyFrame("HeadFirst");
    }
}
```