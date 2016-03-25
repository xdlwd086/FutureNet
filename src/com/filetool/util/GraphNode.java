package com.filetool.util;

/**
 * Created by hadoop on 2016/3/25.
 */
public class GraphNode {
    //public int nodeIndex;//图节点索引值
    public int nodeValue;//图节点编号
    public int inDegree;//图节点的入度，即有多少条边的终点是该节点
    public int outDegree;//图顶点的出度，即有多少条边的起点是该节点

    public GraphNode(){
        this.inDegree = 0;
        this.outDegree = 0;
    }//默认构造函数
    public GraphNode(int nodeValue){
        this.nodeValue = nodeValue;
        this.inDegree = 0;
        this.outDegree = 0;
    }
    public String toString(){
        return this.nodeValue+","+this.inDegree+","+this.outDegree;
    }
}
