#pragma once
#include "FlyWithWings.h"
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
	FlyWithWings flyBehavior;
};

