package rpc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;

public class Server {
    public static void main(String [] args) throws IOException {
        RPC.Server server = new RPC.Builder(new Configuration())
        .setBindAddress("127.0.0.1")
        .setPort(12345)
        .setProtocol(MyInterface.class)
        .setInstance(new MyInterfaceImpl()).build();
        server.start();

    }
}
