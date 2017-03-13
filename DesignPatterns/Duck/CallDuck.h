#pragma once
#include "common.h"
class CallDuck
{
public:
	CallDuck();
	~CallDuck();
protected:
	quackBehavior* quackBehavior;
public:
	void performQuack();
};

