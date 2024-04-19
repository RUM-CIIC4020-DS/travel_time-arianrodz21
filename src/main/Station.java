package main;

/**
 * The Station class represents a station.
 * Each station has a city name and a distance.
 */
public class Station {
    private String cityName; // The name of the city 
    private int distance;    // The distance of the station
    
    /**
     * Constructs a new Station object with the specified name and distance.
     * 
     * @param name The name of the city.
     * @param dist The distance of the station.
     */
    public Station(String name, int dist) {
        this.cityName = name;
        this.distance = dist;
    }
    
    /**
     * Returns the name of the city.
     * 
     * @return The name of the city.
     */
    public String getCityName() {
        return this.cityName;
    }
    
    /**
     * Sets the name of the city.
     * 
     * @param cityName The name of the city.
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    
    /**
     * Returns the distance of the station.
     * 
     * @return The distance of the station.
     */
    public int getDistance() {
        return this.distance;
    }
    
    /**
     * Sets the distance of the station.
     * 
     * @param distance The distance of the station.
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }

    /**
     * Checks if this Station is equal to another object.
     * Two stations are considered equal if they have the same city name and distance.
     * 
     * @param obj The object to compare with.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Station other = (Station) obj;
        return this.getCityName().equals(other.getCityName()) && this.getDistance() == other.getDistance();
    }
    
    /**
     * Returns a string representation of the Station object.
     * 
     * @return A string representation of the Station object.
     */
    @Override
    public String toString() {
        return "(" + this.getCityName() + ", " + this.getDistance() + ")";
    }
}
