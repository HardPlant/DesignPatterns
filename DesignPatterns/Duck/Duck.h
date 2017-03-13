#pragma once
#include "common.h"
class Duck
{
public:
	virtual ~Duck()
	{
	}
	virtual void display() = 0;
	virtual void performFly()
	{
		flyBehavior->fly();
	}

	virtual void performQuack()
	{
		quackBehavior->quack();
	}
	virtual void setFlyBehavior(flyBehavior* fb){
		flyBehavior = fb;
	}
	virtual void setFlyBehavior(quackBehavior* qb) {
		quackBehavior = qb;
	}
	void swim()
	{
		std::cout << "Duck floats." << std::endl;
	}

protected:
	Duck() : flyBehavior(0), quackBehavior(0)
	{
	}
	flyBehavior* flyBehavior;
	quackBehavior* quackBehavior;
};