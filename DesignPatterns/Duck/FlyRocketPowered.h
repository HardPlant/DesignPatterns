#pragma once
#include "common.h"
class FlyRocketPowered :
	public flyBehavior
{
public:
	virtual void fly()
	{
		std::cout << "Rocket Powereddddd" << std::endl;
	}
};

