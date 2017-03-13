#pragma once
#include "common.h"
class Squeak :
	public quackBehavior
{
public:
	virtual void quack()
	{
		std::cout << "Squeack" << std::endl;
	}

};

