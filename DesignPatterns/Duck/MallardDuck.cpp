#include "MallardDuck.h"



MallardDuck::MallardDuck()
{
	quackBehavior = new Quack();
	flyBehavior = new FlyWithWings();
}


MallardDuck::~MallardDuck()
{
}

void MallardDuck::display()
{
	std::cout << "Mallard Duck!" << std::endl;
}
