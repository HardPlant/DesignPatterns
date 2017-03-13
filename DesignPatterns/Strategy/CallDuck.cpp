#include "CallDuck.h"



CallDuck::CallDuck()
{
	quackBehavior = new Quack();
}


CallDuck::~CallDuck()
{
}


void CallDuck::performQuack()
{
	quackBehavior->quack();
}
