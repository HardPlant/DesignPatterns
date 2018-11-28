package com.designpattern.delegation;

public class DelegatorObject{
    DelegationObject delegationObject;

    public DelegatorObject(DelegationObject obj){
        this.delegationObject=obj;
    }
    public void delegate(){
        delegationObject.delegate();
    }
}