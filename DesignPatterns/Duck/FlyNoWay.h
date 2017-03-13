#pragma once
#include "ifFlyBehavior.h"
class FlyNoWay :
	public ifFlyBehavior
{
public:
	FlyNoWay();
	void fly();
	~FlyNoWay();
};

