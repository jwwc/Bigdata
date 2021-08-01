package com.chaochao.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import java.io.IOException;


class Demo{
    static HBaseHelper helper;
    static Configuration conf;
    static {
        conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum","jikehadoop01:2181");
        try {
            helper = HBaseHelper.getHBaseHelper(conf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
        String input[][] = new String[][]{{"Jerry","info","student_id","20210000000002"},{"Jack","info","student_id","20210000000003"},{"Rose","info","student_id","20210000000004"},
                {"Tom","info","class","1"},{"Jerry","info","class","1"},{"Jack","info","class","2"},{"Jack","info","class","2"},{"Tom","score","understanding","75"},{"Jerry","score","understanding","85"},
                {"Jack","score","understanding","80"},{"Rose","score","understanding","60"},{"Tom","score","programming","82"},{"Jerry","score","programming","67"},
                {"Jack","score","programming","80"},{"Rose","score","programming","61"}, {"chaochaowu","info","student_id","G20210735010301"},
                {"chaochaowu","info","class","2"},{"chaochaowu","score","understanding","100"},{"chaochaowu","score","programming","100"}};
        for(String []node : input){
                helper.put(TableName.valueOf("chaochaowu:student"),node[0],node[1],node[2],node[3]);
        }
    }
}
