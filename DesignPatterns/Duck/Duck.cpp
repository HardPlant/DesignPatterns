#include "Duck.h"

Duck::Duck()
{
}


Duck::~Duck()
{
}
void Duck::display()
{
	std::cout << "A Duck" << std::endl;
}
void Duck::performFly()
{
	flyBehavior.fly();
}
void Duck::performQuack()
{
	quackBehavior.quack();
}
void Duck::swim()
{
	std::cout << "All Duck floats." << std::endl;
}