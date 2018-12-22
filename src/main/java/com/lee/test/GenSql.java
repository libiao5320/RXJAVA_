package com.lee.test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author :Lee
 * Since :2018/12/4下午2:27
 * Desc :GenSql Do What ?
 */
public class GenSql {


    private static String path = "/Users/lee/IdeaProjects/wx_service_center/src/main/java/com/royao/model";
    private static String sqlFile = "/Users/lee/wxshop.txt";



    public static void main(String[] args) {
        String tableName = null;
        String columnName = null;
        String columnComment = null;



        try {


            File directory = new File(path);

            File outfile = new File(sqlFile);

            if (directory.exists() && directory.isDirectory()) {


                File[] files = directory.listFiles();

                                                                  String createSql = "";
                for (int i = 0; i < files.length; i++) {

                    File f = files[i];
                    String _name = f.getName();
                    List columns = new ArrayList();

                    if (_name.startsWith("D") && !_name.contains("TortoiseSVN")) {





                        BufferedReader bufferedReader = new BufferedReader(new FileReader(f));

                        String _s = null;


                        while ((_s = bufferedReader.readLine()) != null) {


                            if (_s.contains("TABLE_ALIAS")) {


                                tableName = _s.substring(_s.indexOf("=")+1, _s.length());
                                tableName = tableName .replace(";","");
                                    tableName =  tableName .replace("\"","");
                                continue;


                            } else {
                                if (_s.contains("ALIAS_")) {
                                    columnName = _s.substring(_s.indexOf("ALIAS_") +6, _s.indexOf("="));
                                    columnComment = _s.substring(_s.indexOf("=")+1, _s.length());

                                    columnComment = columnComment.replace("\"","");
                                    Map m = new HashMap();
                                    m.put("columnName", columnName);
                                    m.put("columnComment", columnComment);
                                    columns.add(m);


                                } else
                                    continue;

                            }


                        }

                        bufferedReader.close();


                        if (null != tableName && !"".equals(tableName) && columns.size() > 0) {

                            if (!outfile.exists())
                                outfile.createNewFile();

                     createSql += "create table " + tableName + "(" ;
                                         createSql += "\n";
                            for (int j = 0; j < columns.size(); j++) {
                                Map _m = (Map) columns.get(j);
                                String _columnName = (String) _m.get("columnName");
                                String _columnComment = (String) _m.get("columnComment");


                                if ( j != columns.size() -1)
                                createSql += _columnName + " varchar(50) comment '" + _columnComment + "',";
                                else
                                    createSql += _columnName + " varchar(50) comment '" + _columnComment + "'";

                                createSql += "\n";
                            }
                            createSql += ");";

                            createSql += "\n";





                        }
                        //create table test1
                        //(
                        //      field_name int comment '字段的注释'
                        //)


                    } else
                        continue;



                    Writer writer = new FileWriter(outfile);
                    writer.write(createSql);
                    writer.flush();

                    writer.close();


                }


            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }


}