package main;

public class Station {
	
	
	public Station(String name, int dist) {
	}
	
	public String getCityName() {
		
	}
	public void setCityName(String cityName) {
		
	}
	public int getDistance() {
		
	}
	public void setDistance(int distance) {
		
	}

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
	@Override
	public String toString() {
		return "(" + this.getCityName() + ", " + this.getDistance() + ")";
	}

}
