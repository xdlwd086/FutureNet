package com.filetool.util;

import java.util.ArrayList;

/**
 * Created by hadoop on 2016/3/25.
 */
public class RoadInformation {
    public int sourceID;//起始点
    public int destinationID;//终止点
    public ArrayList includingSet;//路径必经的点的数组，不超过50个点

    public RoadInformation(){
        this.includingSet = new ArrayList();
    }
    public RoadInformation(int sourceID,int destinationID,ArrayList includingSet){
        this.sourceID = sourceID;
        this.destinationID = destinationID;
        this.includingSet = includingSet;
    }
    public String toString(){
        //String str = null;
        //for(int i=0;i<includingSet.size()-1;i++){
        //str += includingSet.get(i) + "|";
        //}
        //str += includingSet.get(includingSet.size()-1);
        return this.sourceID+","+this.destinationID+","+includingSet.toString();
    }
}
