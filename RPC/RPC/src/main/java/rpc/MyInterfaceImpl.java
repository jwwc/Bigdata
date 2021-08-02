package rpc;

import org.apache.hadoop.ipc.ProtocolSignature;

import java.io.IOException;

public class MyInterfaceImpl implements MyInterface {

    public long getProtocolVersion(String protocol, long clientVersion) throws IOException {
        return MyInterface.versionID;
    }

    public ProtocolSignature getProtocolSignature(String protocol, long clientVersion, int clientMethodsHash) throws IOException {
        return null;
    }

    public String findName(String studentld) {
        System.out.println(studentld);
        if(studentld.equals("G20210735010301")){
            return "wuchaochao";
        }else{
            return null;
        }
    }
}
