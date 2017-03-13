#pragma once
#include "common.h"
class Duck
{
public:
	Duck();
	virtual ~Duck();
	virtual void quack() = 0;
	virtual void fly() = 0;
};

