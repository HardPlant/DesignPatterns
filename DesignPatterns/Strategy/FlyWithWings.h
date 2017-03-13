#pragma once
#include "common.h"
class FlyWithWings :
	public flyBehavior
{
public:
	virtual void fly()
	{
		std::cout << "Take my wing!" << std::endl;
	}

};

