#include "common.h"
#include "Duck.h"
int main(int argc, char* argv[])
{
	Duck duck;
	duck.display();
	duck.performFly();
	duck.performQuack();

	return 0;
}