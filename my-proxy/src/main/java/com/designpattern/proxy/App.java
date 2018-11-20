package com.designpattern.proxy;

import com.designpattern.state.GumballMachine;

/**
 * Hello world!
 *
 */
public class App 
{
    ImageComponent imageComponent;
    public static void main( String[] args ) throws Exception
    {
    }
    public ImageProxyTestDrive() throws Exception{
        Icon icom = new ImageProxy(initialURL);
        imageComponent = new ImageComponent(icon);
        frame.getContentPane().add(imageComponent);
    }
}
