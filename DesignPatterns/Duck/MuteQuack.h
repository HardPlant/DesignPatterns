#pragma once
#include "common.h"
class MuteQuack :
	public quackBehavior
{
public:
	virtual void quack()
	{
		std::cout << "*Slience*" << std::endl;
	}

};

