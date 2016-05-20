package task1;

/**
 * Created by Сергей on 20.05.2016.
 */
public class Weather {
    /**
     * wind direction
     */
    private WindDirection windDirection;
    /**
     * speed of wind, meter per second
     */
    private double windSpeed;
    /**
     * temperature of environment, Celsius degree
     */
    private double temperature;
    /**
     * cloudiness of environment, percent
     */
    private double cloudiness;
    /**
     * precipitation, mm
     */
    private int precipitation;

    /**
     * Weather constrictor
     */
    public Weather(WindDirection windDirection, double windSpeed,
                   double temperature, double cloudiness, int precipitation) {
        setWindDirection(windDirection);
        setWindSpeed(windSpeed);
        setTemperature(temperature);
        setCloudiness(cloudiness);
        setPrecipitation(precipitation);
    }

    /**
     * Weather constructor with default values of cloudiness and precipitation
     */
    public Weather(WindDirection windDirection, double windSpeed, double temperature) {
        this(windDirection, windSpeed, temperature, 0, 0);
    }

    /**
     * transfers Celsius degree to Fahrenheit
     * @return Fahrenheit degree
     */
    public double transfereFahrenheit() {
        return (temperature - 32)*5./9;
    }

    /**
     * measurement of weather
     * @return wind-cold index
     */
    public double calculateWindColdIndex() {
        return 33 + (0.478 + 0.237 * Math.sqrt(windSpeed)
                - 0.0124 * windSpeed) * (temperature - 33);
    }

    public WindDirection getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(WindDirection windDirection) {
        this.windDirection = windDirection;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = (windSpeed < 0) ? 0 : windSpeed;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getCloudiness() {
        return cloudiness;
    }

    public void setCloudiness(double cloudiness) {
        this.cloudiness = (cloudiness < 0 || cloudiness > 100) ?
                0 : cloudiness;
    }

    public int getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(int precipitation) {
        this.precipitation = (precipitation < 0) ? 0 : precipitation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Weather weather = (Weather) o;

        if (Double.compare(weather.windSpeed, windSpeed) != 0) return false;
        if (Double.compare(weather.temperature, temperature) != 0) return false;
        if (Double.compare(weather.cloudiness, cloudiness) != 0) return false;
        if (precipitation != weather.precipitation) return false;
        return windDirection == weather.windDirection;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = windDirection.hashCode();
        temp = Double.doubleToLongBits(windSpeed);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(temperature);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(cloudiness);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + precipitation;
        return result;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "windDirection = " + windDirection +
                ", windSpeed = " + windSpeed +
                ", temperature = " + temperature +
                ", cloudiness = " + cloudiness +
                ", precipitation = " + precipitation +
                ", weathers general rigidity(Rc > 0 is OK)" + calculateWindColdIndex() +
                '}';
    }
}
