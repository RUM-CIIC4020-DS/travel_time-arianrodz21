package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import data_structures.ArrayList;
import data_structures.ArrayListStack;
import data_structures.HashSet;
import data_structures.HashTableSC;
import data_structures.SimpleHashFunction;
import interfaces.List;
import interfaces.Map;
import interfaces.Set;
import interfaces.Stack;

/**
 * The TrainStationManager class manages train stations and their connections, along with calculating travel times
 * and shortest routes between stations.
 */
public class TrainStationManager {
    private Map<String, List<Station>> trainStations = new HashTableSC<String, List<Station>>(1, new SimpleHashFunction<String>());
    private Map<String, Double> travelTimes = new HashTableSC<String, Double>(1, new SimpleHashFunction<String>());
    private Map<String, Station> shortestDistance = new HashTableSC<String, Station>(1, new SimpleHashFunction<String>());

    /**
     * Constructs a TrainStationManager object and initializes train stations.
     * @param station_file The name of the file containing station data
     */
    public TrainStationManager(String station_file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("inputFiles/" + station_file));
            String line;
            line = reader.readLine();
            while((line = reader.readLine()) != null) {
                String[] splitLine = line.split(",");
                int distance = Integer.parseInt(splitLine[2]);
                if(this.trainStations.get(splitLine[0]) == null) {
                    List<Station> distToDest = new ArrayList <Station> ();
                    this.trainStations.put(splitLine[0], distToDest);
                } 
                this.trainStations.get(splitLine[0]).add(new Station(splitLine[1], distance));
            
                if(this.trainStations.get(splitLine[1]) == null) {
                    List<Station> distToDest = new ArrayList <Station> ();
                    this.trainStations.put(splitLine[1], distToDest);
                } 
                this.trainStations.get(splitLine[1]).add(new Station(splitLine[0], distance));	
            }
            findShortestDistance();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    /**
     * Finds the shortest distance from the starting station (Westside) to every other station using Dijkstra's algorithm. 
     * I used a stack named toVisit to store the stations that need to be visited since  and the set named visited to store the 
     * stations already visited.
     */
    private void findShortestDistance() {
        Stack<Station> toVisit = new ArrayListStack<Station>();
        Set<String> visited = new HashSet<String>(1);
        
        // Initialize shortest distance to each station with maximum value, all except Westside since its the starting station and the distance is automatically 0
        for(int i = 0; i < this.trainStations.getKeys().size(); i++) {
            if(this.trainStations.getKeys().get(i).equals("Westside")) {
                this.shortestDistance.put(this.trainStations.getKeys().get(i), new Station("Westside", 0));
            }
            else {
                this.shortestDistance.put(this.trainStations.getKeys().get(i), new Station("Westside", Integer.MAX_VALUE));
            }	
        }
        toVisit.push(new Station("Westside", 0));
        
        while(!toVisit.isEmpty()) {
            Station currentStation = toVisit.pop();
            String currentCity = currentStation.getCityName();
            visited.add(currentCity);
            for(Station neighbor : this.trainStations.get(currentCity)) {
                int shortestNeighborDistance = this.shortestDistance.get(neighbor.getCityName()).getDistance();
                int neighborDistance = neighbor.getDistance();
                int shortestDistanceCurrentStation = this.shortestDistance.get(currentCity).getDistance();
                int newDistance = shortestDistanceCurrentStation + neighborDistance;
                if(newDistance < shortestNeighborDistance) {
                    shortestDistance.put(neighbor.getCityName(), new Station(currentCity, newDistance));
                }
                if(!visited.isMember(neighbor.getCityName())) {
                    sortStack(neighbor, toVisit);
                }    
            }  
        } 
    }

    /**
     * Sorts a stack of stations based on their distance from Westside (shortest distance to longest distance).
     * @param station The station to be inserted into the sorted stack
     * @param stackToSort The stack to be sorted
     */
    public void sortStack(Station station, Stack<Station> stackToSort) {
        Stack<Station> temp = new ArrayListStack<Station>();
        while(!stackToSort.isEmpty() && stackToSort.top().getDistance() < station.getDistance()) {
            temp.push(stackToSort.pop());
        }
        stackToSort.push(station);
        while(!temp.isEmpty()) {
            stackToSort.push(temp.pop());
        }
    }
    
    /**
     * Calculates and returns the travel times in minutes from Westside to each station.
     * @return Map containing travel times in minutes to each station
     */
    public Map<String, Double> getTravelTimes() {
        for(int i = 0; i < this.shortestDistance.size(); i++) {
            String currentStation = this.shortestDistance.getKeys().get(i);
            String destinationCity = this.shortestDistance.getValues().get(i).getCityName();
            
            int destinationDistance = this.shortestDistance.getValues().get(i).getDistance();
            double travelTime = destinationDistance * 2.5; // 2.5 minutes per kilometer
            
            while(!destinationCity.equals("Westside")) {
                travelTime += 15; // 15 minutes per stop
                destinationCity = this.shortestDistance.get(destinationCity).getCityName();
            }
            travelTimes.put(currentStation, travelTime);
        }		
        return this.travelTimes;
    }

    /**
     * Retrieves the map containing train stations.
     * @return Map of train stations
     */
    public Map<String, List<Station>> getStations() {
        return this.trainStations;   
    }

    /**
     * Sets the map of train stations.
     * @param cities Map of train stations
     */
    public void setStations(Map<String, List<Station>> cities) {
        this.trainStations = cities; 
    }

    /**
     * Retrieves the map containing shortest distance from Westside to each station.
     * @return Map of shortest routes to each station
     */
    public Map<String, Station> getShortestRoutes() {
        return this.shortestDistance;
    }

    /**
     * Sets the map of shortest distance from Westside to each station.
     * @param shortestRoutes Map of shortest routes to each station
     */
    public void setShortestRoutes(Map<String, Station> shortestRoutes) {
        this.shortestDistance = shortestRoutes;
    }
    
    /**
     * BONUS EXERCISE THIS IS OPTIONAL
     * Returns the path to the station given. 
     * The format is as follows: Westside->stationA->.....stationZ->stationName
     * Each station is connected by an arrow and the trace ends at the station given.
     * 
     * I used a stack to keep the order of the stations visited to get to the destination.
     * 
     * @param stationName Name of the station whose route we want to trace
     * @return String representation of the path taken to reach stationName (Westside->stationA->.....stationZ->stationName)
     */
    public String traceRoute(String stationName) {
        Stack<String> routes = new ArrayListStack<String>();
        String currentStation = this.shortestDistance.get(stationName).getCityName();
        
        routes.push(stationName);
        while(!currentStation.equals("Westside")) {
            routes.push(currentStation);
            currentStation = this.shortestDistance.get(currentStation).getCityName();
        }
        if(routes.top() == "Westside") {
            return "Westside";
        }
        routes.push("Westside");
        
        //learned a new way to manipulate strings ->https://www.geeksforgeeks.org/stringbuilder-class-in-java-with-examples/
        StringBuilder routesToString = new StringBuilder();
        while(!routes.isEmpty()) {
            routesToString.append(routes.pop());
            if(!routes.isEmpty()) {
                routesToString.append("->");
            }
        }
        return routesToString.toString();
    }
    
    
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        TrainStationManager p = new TrainStationManager("stations.csv");
    }
}
