#include "common.h"
int main(int argc, char* argv[])
{
	MallardDuck duck;
	duck.display();
	duck.performFly();
	duck.performQuack();

	ModelDuck model;
	model.display();
	model.performFly();
	model.setFlyBehavior(new FlyRocketPowered);
	model.performFly();

	CallDuck caller;
	caller.performQuack();
	return 0;
}