package com.chaochao.hbase;

import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.Closeable;
import java.io.IOException;

import org.slf4j.Logger;

import org.apache.hadoop.conf.Configuration;

public class HBaseHelper implements Closeable {

    private Configuration configuration = null;
    private Connection connection = null;
    private Admin admin = null;
    public void close() throws IOException {
        admin.close();
        connection.close();
    }
    private  HBaseHelper(Configuration configuration) throws IOException{
        this.configuration = configuration;
        this.connection = ConnectionFactory.createConnection(this.configuration);
        admin = this.connection.getAdmin();
    }

    public static HBaseHelper getHBaseHelper(Configuration configuration) throws IOException {
        return new HBaseHelper(configuration);
    }
    public Connection getConnection(){
        return connection;
    }
    public Configuration getConfiguration(){
        return configuration;
    }
   public void createTable(TableName table,int maxVersions, String... colfams) throws IOException{
        TableDescriptorBuilder tableDescriptorBuilder = TableDescriptorBuilder.newBuilder(table);
        ColumnFamilyDescriptorBuilder cfDescBuilder;
        ColumnFamilyDescriptor cfDesc;
        for(String cf : colfams){
            cfDescBuilder =ColumnFamilyDescriptorBuilder.newBuilder(Bytes.toBytes(cf));
            cfDescBuilder.setMaxVersions(maxVersions);
            cfDesc = cfDescBuilder.build();
            tableDescriptorBuilder.setColumnFamily(cfDesc);
        }
        TableDescriptor tableDescriptor = tableDescriptorBuilder.build();
        admin.createTable(tableDescriptor);
    }
    public void put(TableName table, String row, String fam, String qual, String value) throws IOException {
        Table tb = connection.getTable(table);
        Put put = new Put(Bytes.toBytes(row));
        put.addColumn(Bytes.toBytes(fam), Bytes.toBytes(qual),Bytes.toBytes(value));
        tb.put(put);
        tb.close();
    }
}
