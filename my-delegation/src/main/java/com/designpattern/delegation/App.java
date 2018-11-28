package com.designpattern.delegation;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DelegationObject job = new DelegationObject();
        DelegatorObject delegator = new DelegatorObject(job);

        delegator.delegate();
    }
}
