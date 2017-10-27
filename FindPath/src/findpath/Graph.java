/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findpath;

import java.util.ArrayList;

/**
 *
 * @author jim.stewart
 */
public class Graph {
    private ArrayList<Station> stations;
    
    public ArrayList<Station> getStations() {
        return stations;
    }
    
    //add a constructor without parameter and another
    //with an int[][] array
    
    /**
     * add a station next in index with no 
     * connected stations
     */
    public void addStation(){
        int index = stations.size();
        stations.add(new Station(index));
    }

    /**
     * Add a station next in index with list of
     * connected stations
     * @param connectedStationNumbers the stations it's connected to
     * @return  the new station
     */
    public Station addStation(int[] connectedStationNumbers){
        int index = stations.size();
        Station rtrn = new Station(index);
        for(int i:connectedStationNumbers){
            Station nextStation = getStationOrFill(i);
            connectStations(rtrn, nextStation);
        }
        return rtrn;
    }

    /**
     * Add a station next in index with a single connected station
     * @param connectedStationNumber the station it's connected to
     * @return  the new station
     */
    public Station addStation(int connectedStationNumber){
        int index = stations.size();
        Station rtrn = new Station(index);
        Station nextStation = getStationOrFill(connectedStationNumber);
        connectStations(rtrn, nextStation);
        return nextStation;
    }
    
    /**
     * add or connect two stations by number and fill in the missing stations between
     * in between
     * @param firstStationNumber
     * @param secondStationNumber
     * @return the connected stations
     */
    public Station[] addOrConnectStations(int firstStationNumber, int secondStationNumber){
        int[] numberPair = {firstStationNumber, secondStationNumber};
        Station[] stationPair = new Station[2];
        for(int i=0;i<numberPair.length;i++){
            stationPair[i]=getStationOrFill(numberPair[i]);
        }
        connectStations(stationPair[0], stationPair[1]);
        return stationPair;
    }
    
    /**
     * Connect two existing stations
     * @param first first station
     * @param second second station
     */
    public void connectStations(Station first, Station second){
        first.addConnectedStation(second);
        second.addConnectedStation(first);
    }
    
    /**
     * Get station by index without filling missing stations
     * @param index
     * @return station by index or null if it doesn't exist
     */
    public Station getStation(int index){
        if(stations.size()<index)
            return stations.get(index);
        else
            return null;
    }
    
    /**
     * get station by index and if it doesn't exist fill in missing
     * stations until it does
     * @param index
     * @return the existing or new station
     */
    public Station getStationOrFill(int index){
        Station rtrn = getStation(index);
        if (rtrn==null)
            rtrn = fillStationsToNumber(index);
        return rtrn;
    }
    
    /**
     * fill in stations up to index
     * if the station does exist it'll just return the station
     * @param num
     * @return 
     */
    private Station fillStationsToNumber(int num){
        Station nextStation = getStation(num);
         
        while(stations.size()<=num){
            nextStation = new Station(stations.size());
            stations.add(nextStation);
        }
        return nextStation;
    }
}
