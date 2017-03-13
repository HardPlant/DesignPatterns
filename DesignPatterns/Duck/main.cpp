#include "common.h"
#include "MallardDuck.h"
void testDuck(Duck* duck)
{
	duck->quack();
	duck->fly();
}
int main(int argc, char* argv[])
{
	MallardDuck duck;
	testDuck(&duck);

	return 0;
}