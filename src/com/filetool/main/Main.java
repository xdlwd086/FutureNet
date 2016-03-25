package com.filetool.main;

import com.filetool.util.*;
import com.routesearch.route.Route;

import java.io.File;
import java.util.ArrayList;

/**
 * 工具入口
 * 
 * @author
 * @since 2016-3-1
 * @version v1.0
 */
public class Main
{
    public static void main(String[] args) throws Exception
    {
        if (args.length != 3)
        {
            System.err.println("please input args: graphFilePath, conditionFilePath, resultFilePath");
            return;
        }//错误处理，若输入参数小于3个，返回错误信息，程序结束
        String graphFilePath = args[0];//第一个参数为图信息的文件路径
        String conditionFilePath = args[1];//第二个参数为路径信息文件路径
        String resultFilePath = args[2];//第三个参数为结果文件路径
        File fileGraphEdge = new File(graphFilePath);//图信息文件对象
        File fileRoadInformation = new File(conditionFilePath);//路径信息文件对象
        File fileResult = new File(resultFilePath);//结果路径文件对象
        ArrayList<GraphEdge> graphEdgeArrayList = new ArrayList<GraphEdge>();//图边集数组对象
        RoadInformation roadInformation = new RoadInformation();//存储路径信息的类对象

        LogUtil.printLog("Begin");//程序开始执行，记录当前时间，并打印出来

        // 读取输入文件
        //String graphContent = FileUtil.read(graphFilePath, null);
        //String conditionContent = FileUtil.read(conditionFilePath, null);
        graphEdgeArrayList = FileUtil.getGraphEdgeFromFile(fileGraphEdge);//从图信息文件中获取边集数组对象
        GraphInformation graphInformation = new GraphInformation(graphEdgeArrayList);
        graphInformation.getGraphNodeSetFromGraphEdgeSet();

        //边集数组的打印显示
        for(GraphEdge g:graphEdgeArrayList){
            System.out.println(g.toString());
        }
        for(GraphNode graphNode:graphInformation.graphNodeArrayList){
            System.out.println(graphNode.toString());
        }
        //从路劲信息文件中获取路径信息，并存入路径信息类对象中
        //roadInformation = FileUtil.getRoadInformationFromFile(fileRoadInformation);
        //System.out.println(roadInformation.toString());//路径信息的打印
        //System.out.println(Integer.MAX_VALUE);

        // 功能实现入口
        //String resultStr = Route.searchRoute(graphContent, conditionContent);

        // 写入输出文件
        //FileUtil.write(resultFilePath, resultStr, false);

        LogUtil.printLog("End");//程序执行结束，记录当前时间和程序运行的时间，并打印出来
    }

}
