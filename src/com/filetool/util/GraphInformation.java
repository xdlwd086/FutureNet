package com.filetool.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by hadoop on 2016/3/25.
 */
public class GraphInformation {
    public ArrayList<GraphEdge> graphEdgeArrayList;//边集数组信息
    public ArrayList<GraphNode> graphNodeArrayList;//节点集合
    public int numEdge;//边的总数
    public int numNode;//节点数量

    public GraphInformation(){
        this.graphEdgeArrayList = new ArrayList<GraphEdge>();
        this.graphNodeArrayList = new ArrayList<GraphNode>();
        this.numEdge = graphEdgeArrayList.size();
        this.numNode = graphNodeArrayList.size();
    }
    /**
     * 函数功能：构造函数，一般在知道边集数组的情况下构造GraphInformation对象
     * @param graphEdgeArrayList 边集数组对象
     */
    public GraphInformation(ArrayList<GraphEdge> graphEdgeArrayList){
        this.graphEdgeArrayList = graphEdgeArrayList;
        this.graphNodeArrayList = new ArrayList<GraphNode>();
        this.numEdge = graphEdgeArrayList.size();
        this.numNode = graphNodeArrayList.size();
    }

    /**
     * 函数功能：由边集数组求节点数组，包括每个节点的编号值，入度和出度
     */
    public void getGraphNodeSetFromGraphEdgeSet() {
        ArrayList nodeValueSet = new ArrayList();//节点编号值集合
        int[] sourceIDSet = new int[this.graphEdgeArrayList.size()];//边的起点编号集合
        int[] destinationIDSet = new int[this.graphEdgeArrayList.size()];//边的终点编号集合
        int i = 0;//索引
        //遍历边集数组，对每一条边的起点和终点进行处理
        for (GraphEdge gEdge : this.graphEdgeArrayList) {
            if (!nodeValueSet.contains(gEdge.sourceID)) {
                nodeValueSet.add(gEdge.sourceID);
            }//获取无重复的节点值
            if(!nodeValueSet.contains(gEdge.destinationID)){
                nodeValueSet.add(gEdge.destinationID);
            }//获取无重复的节点值
            sourceIDSet[i] = gEdge.sourceID;//有重复的边起始节点值
            destinationIDSet[i] = gEdge.destinationID;//有重复的边终止节点值
            i++;
        }
        Collections.sort(nodeValueSet);//对无重复节点编号集合进行排序
        Arrays.sort(sourceIDSet);//对重复边起点集合进行排序，重复的数目为点的出度
        Arrays.sort(destinationIDSet);//对重复边终点集合进行排序，重复的数目为点的入度
        int outCount = 0;//点出度的计数器
        int inCount = 0;//点入度的计数器
        //对于每个节点编号值，统计其入度和出度
        for (int a = 0; a < nodeValueSet.size(); a++) {
            GraphNode graphNode = new GraphNode();//创建一个节点对象
            graphNode.nodeValue = ((Integer) nodeValueSet.get(a)).intValue();//获得节点的编号值，并存入节点对象的nodeValue字段中
            for (int j = outCount; j < sourceIDSet.length; j++) {
                if (graphNode.nodeValue == sourceIDSet[j]) {
                    graphNode.outDegree++;
                    outCount++;
                } else if (graphNode.nodeValue != sourceIDSet[j]) {
                    break;
                }
            }//计算节点的出度
            for (int k = inCount; k < destinationIDSet.length; k++) {
                if (graphNode.nodeValue == destinationIDSet[k]) {
                    graphNode.inDegree++;
                    inCount++;
                } else if (graphNode.nodeValue != destinationIDSet[k]) {
                    break;
                }
            }//计算节点的入度
            this.graphNodeArrayList.add(graphNode);//将节点对象添加到节点对象数组中
        }
    }


}
