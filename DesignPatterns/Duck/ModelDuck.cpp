#include "ModelDuck.h"



ModelDuck::ModelDuck()
{
	quackBehavior = new Quack();
	flyBehavior = new FlyNoWay();
}


ModelDuck::~ModelDuck()
{
}


void ModelDuck::display()
{
	std::cout << "Model Duck!" << std::endl;
}
