# 스테이트 패턴

원래 전략 패턴과 상태 패턴은 날 때 분리된 쌍둥이임

### 자바 껌 기계

CPU를 껌 기계에 넣어서 재고를 감시하고 소비자의 만족도를 더 정확히 측정하려고 함

다음 상태가 있음

Has Quarterㄱ --Gumball Sold -->out of Gumball
ㄴNo Quarter    ㄴ

### 상태 머신 그리기

No Quarter
Gumball Solid
Out of Gumball
No Quarter

```java
final static int No Quarter = 0;
final static int Gumball Solid = 1;
final static int Out of Gumball = 2;
final static int No Quarter = 3;
int state = SOLD_OUT;
```


