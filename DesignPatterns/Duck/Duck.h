#pragma once
#include "ifFlyBehavior.h"
#include "ifQuackBehavior.h"
#include "common.h"
class Duck
{
public:
	Duck();
	void display();
	virtual ~Duck();
	void performFly();
	void performQuack();
	void swim();
private:
	ifFlyBehavior flyBehavior;
	ifQuackBehavior quackBehavior;
};

