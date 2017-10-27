/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findpath;

import java.util.Random;

/**
 *
 * @author jim.stewart
 */
public class GraphGenerator {
    public Graph generateGraph(int graphSize){
        Random rnd = new Random();
        Graph gr = new Graph();
        int[][] stationArray = new int[graphSize][2];
        for(int i=0;i<graphSize; i++){
            Station newStation = gr.getStationOrFill(i);
            int numberOfConnectedStations = rnd.nextInt(5);
            generateConnectedStations(gr, i, numberOfConnectedStations, rnd, graphSize);
        }
        //TODO: look for unconnected stations and connect them to something
        return gr;
    }
    
    private void generateConnectedStations(Graph gr, int firstStationNumber, int numberOfConnectedStations, Random rnd, int graphSize){
                for(int j=0;j<numberOfConnectedStations;j++){
                int cs = rnd.nextInt(graphSize);
                    gr.addOrConnectStations(firstStationNumber, j);
                }

    }
}