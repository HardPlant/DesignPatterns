#pragma once
#include "common.h"
class FlyNoWay :
	public flyBehavior
{
public:
	virtual void fly() {
		std::cout << "Fly unavailable!" << std::endl;
	}

};

