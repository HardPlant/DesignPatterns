#include "WeatherData.h"
namespace Observer {


	WeatherData::WeatherData()
	{
	}


	WeatherData::~WeatherData()
	{
	}


	float WeatherData::getTemperature()
	{

	}
	float WeatherData::getHumidity()
	{

	}
	float WeatherData::getPressure()
	{

	}
	void WeatherData::measurementsChanged()
	{
		float temp = getTemperature();
		float humidity = getHumidity();
		float pressure = getPressure();


	}
}