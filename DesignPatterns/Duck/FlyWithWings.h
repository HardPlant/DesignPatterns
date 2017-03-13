#pragma once
#include "ifFlyBehavior.h"
class FlyWithWings :
	public ifFlyBehavior
{
public:
	FlyWithWings();
	void fly();
	~FlyWithWings();
};

