package com.filetool.util;

import java.io.*;
import java.util.ArrayList;

public final class FileUtil
{
    /** 
     * 读取文件并按行输出
     * @param filePath
     * @param spec 允许解析的最大行数， spec==null时，解析所有行
     * @return
     * @author
     * @since 2016-3-1
     */
    public static String read(final String filePath, final Integer spec)
    {
        File file = new File(filePath);
        // 当文件不存在或者不可读时
        if ((!isFileExists(file)) || (!file.canRead()))
        {
            System.out.println("file [" + filePath + "] is not exist or cannot read!!!");
            return null;
        }

        BufferedReader br = null;
        FileReader fb = null;
        StringBuffer sb = new StringBuffer();
        try
        {
            fb = new FileReader(file);
            br = new BufferedReader(fb);

            String str = null;
            int index = 0;
            while (((spec == null) || index++ < spec) && (str = br.readLine()) != null)
            {
                sb.append(str + "\n");
                System.out.println(str);

            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            closeQuietly(br);
            closeQuietly(fb);
        }

        return sb.toString();
    }
    /** 
     * 写文件
     * @param filePath 输出文件路径
     * @param content 要写入的内容
     * @param append 是否追加
     * @return
     * @author s00274007
     * @since 2016-3-1
     */
    public static int write(final String filePath, final String content, final boolean append)
    {
        File file = new File(filePath);
        if (content == null)
        {
            System.out.println("file [" + filePath + "] invalid!!!");
            return 0;
        }

        // 当文件存在但不可写时
        if (isFileExists(file) && (!file.canRead()))
        {
            return 0;
        }

        FileWriter fw = null;
        BufferedWriter bw = null;
        try
        {
            if (!isFileExists(file))
            {
                file.createNewFile();
            }

            fw = new FileWriter(file, append);
            bw = new BufferedWriter(fw);

            bw.write(content);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return 0;
        }
        finally
        {
            closeQuietly(bw);
            closeQuietly(fw);
        }

        return 1;
    }

    private static void closeQuietly(Closeable closeable)
    {
        try
        {
            if (closeable != null)
            {
                closeable.close();
            }
        }
        catch (IOException e)
        {
        }
    }

    private static boolean isFileExists(final File file)
    {
        if (file.exists() && file.isFile())
        {
            return true;
        }

        return false;
    }
    /**
     * 函数功能：从原始图文件中读取边集数组信息
     * @param fileGraph 原始图文件
     * @return 返回边集数组
     * @throws Exception
     */
    public static ArrayList<GraphEdge> getGraphEdgeFromFile(File fileGraph) throws Exception{
        ArrayList<GraphEdge> graphEdgeArrayList = new ArrayList<GraphEdge>();
        if(fileGraph.exists()&&fileGraph.isFile()){
            InputStreamReader read = new InputStreamReader(new FileInputStream(fileGraph));
            BufferedReader bufferedReader = new BufferedReader(read);
            String strLine;
            String[] strLineArray;
            while((strLine = bufferedReader.readLine())!=null){
                strLineArray = strLine.split(",");
                GraphEdge g = new GraphEdge();
                g.linkID = Integer.parseInt(strLineArray[0]);
                g.sourceID = Integer.parseInt(strLineArray[1]);
                g.destinationID = Integer.parseInt(strLineArray[2]);
                g.cost = Integer.parseInt(strLineArray[3]);
                graphEdgeArrayList.add(g);
            }
            bufferedReader.close();
        }
        return graphEdgeArrayList;
    }

    /**
     * 函数功能：获取限制路径信息
     * @param fileRoad 路径信息文件
     * @return 返回存储路径信息的类对象
     * @throws Exception
     */
    public static RoadInformation getRoadInformationFromFile(File fileRoad) throws Exception{

        RoadInformation roadInformation = new RoadInformation();
        if(fileRoad.exists()&&fileRoad.isFile()){
            InputStreamReader read = new InputStreamReader(new FileInputStream(fileRoad));
            BufferedReader bufferedReader = new BufferedReader(read);
            String strLine = bufferedReader.readLine();
            String[] strLineArray = strLine.split(",");
            roadInformation.sourceID = Integer.parseInt(strLineArray[0]);
            roadInformation.destinationID = Integer.parseInt(strLineArray[1]);
            String str = strLineArray[2];
            String[] strIncludeSetArray = str.split("\\|");
            for(int i=0;i<strIncludeSetArray.length;i++) {
                int index = Integer.parseInt(strIncludeSetArray[i]);
                roadInformation.includingSet.add(index);
            }

            bufferedReader.close();
        }
        return roadInformation;
    }
}
