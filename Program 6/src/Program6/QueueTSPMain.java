/*
* INFO I-211/CSCI C-202
* QueueTSPMain.java
* Purpose: This program is designed to find the shortest distance between 
* cities. The algorithm may not actually for the best path for the shortest 
* distance between all the cities because it is a greedy algorithm that 
* only determines the shortest distance depending on the initial city 
* (or city 0) instead of traversing all the cities to find the best path. 
* This program is designed to show the importance of Dijkstra's Algorithm. 
* 
* Dr. Hettiarachchi
* Cody Main 
* November 17-December 2, 2016
*/

package Program6;


public class QueueTSPMain 
{ //class

    public static void main(String[] args) 
    { //main
        
        QueueTSP tsp;
        if (args.length > 0) 
        {
            tsp = new QueueTSP(Integer.parseInt(args[0]));
            tsp.populateMatrix(args[1]);
        } 
        else 
        {
            tsp = new QueueTSP(19);
            tsp.populateMatrix("tsp19.txt");
        }
        
        
        //measure time taken to complete TSP
        long start = System.nanoTime();
        tsp.dijkstra();
        long stop = System.nanoTime();

        System.out.println("Time to Complete: " + (double)(stop-start)/Math.pow(10,9) +" seconds.");
        
    } //main
} //class