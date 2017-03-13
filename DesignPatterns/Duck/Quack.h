#pragma once
#include "quackBehavior.h"
class Quack :
	public quackBehavior
{
public:
	virtual void quack()
	{
		std::cout << "Quack" << std::endl;
	}

};

