#pragma once
#include "quackBehavior.h"
class Squeak :
	public quackBehavior
{
public:
	virtual void quack()
	{
		std::cout << "Squeack" << std::endl;
	}

};

