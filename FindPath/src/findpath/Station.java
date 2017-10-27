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
public class Station {
   private final ArrayList<Station> connectedStations; 
   private final int index;
    
   public Station(int index){
       this.index=index;
       this.connectedStations = new ArrayList<>();
   }
       
   public int getIndex(){
       return index;
   }
   
   public ArrayList<Station> getConnectedStations(){
       return connectedStations;
   }
   
   public void addConnectedStation(Station s){
       connectedStations.add(s);
   }
}
