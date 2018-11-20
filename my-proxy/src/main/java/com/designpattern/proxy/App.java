package com.designpattern.proxy;

import com.designpattern.state.GumballMachine;

/**
 * Hello world!
 *
 */
public class App 
{
 //   ImageComponent imageComponent;
    public static void main( String[] args ) throws Exception
    {
    }
    public ImageProxyTestDrive() throws Exception{
        Icon icom = new ImageProxy(initialURL);
//        imageComponent = new ImageComponent(icon);
//        frame.getContentPane().add(imageComponent);
    }
    public void proxyDrive(){
        PersonBean joe;
        PersonBean ownerProxy = getOwnerProxy(joe);
        System.out.println("Name is" + ownerProxy.getName());
    }

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
}
