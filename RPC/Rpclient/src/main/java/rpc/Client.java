package rpc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.net.InetSocketAddress;
import java.util.Scanner;

import static org.apache.hadoop.ipc.RPC.getProtocolProxy;
//"G2021073501030"
public class Client {
    public static void main(String [] args){
        try {
            MyInterface proxy = RPC.getProxy(MyInterface.class,1L,new InetSocketAddress("127.0.0.1",12345),new Configuration());
            Scanner sc = new Scanner(System.in);
            String id = sc.nextLine();
            String name = proxy.findName(id);
            System.out.println(name);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
