package com.designpattern.delegation;

public class DelegatorObject{
    DelegationObject delegationObject;

    public DelegatorObject(){
        this.delegationObject=new DelegationObject();
    }
    public void delegate(){
        delegationObject.delegate();
    }
}