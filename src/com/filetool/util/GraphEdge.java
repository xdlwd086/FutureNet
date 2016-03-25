package com.filetool.util;

/**
 * Created by hadoop on 2016/3/25.
 */
public class GraphEdge {
    public int linkID;//边的索引
    public int sourceID;//边的起始点
    public int destinationID;//边的终止点
    public int cost;//边的权重，范围：[1,20]

    public GraphEdge(){}//默认构造函数
    public GraphEdge(int linkID,int sourceID,int destinationID,int cost){
        this.linkID = linkID;
        this.sourceID = sourceID;
        this.destinationID = destinationID;
        this.cost = cost;
    }
    public String toString(){
        return this.linkID+","+this.sourceID+","+this.destinationID+","+this.cost;
    }
}

