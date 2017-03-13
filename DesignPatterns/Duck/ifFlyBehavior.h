#pragma once
#include "common.h"

class ifFlyBehavior
{
public:
	ifFlyBehavior();
	virtual void fly() = 0;
	virtual ~ifFlyBehavior();
};

