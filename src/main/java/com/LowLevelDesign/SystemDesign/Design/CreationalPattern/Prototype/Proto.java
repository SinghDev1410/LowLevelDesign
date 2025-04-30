package com.LowLevelDesign.SystemDesign.Design.CreationalPattern.Prototype;

// The concept is to copy an existing object rather tha creating a new instance from scratch because creating new object may be costly.
// this approach saves costly resourecs and time, especially when object creation is a heavy process.

public class Proto {
    public static void main(String[] args) throws InterruptedException {
        Network network = new Network();
        network.setIp("192.186.0.1");
        network.ImpData();

        System.out.println(network);
        
        // we want new Object of network Connection

        Network network1 = null;
        try{
            network1 = (Network) network.clone();
            System.out.println(network1);
        }
        catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
    }
}


class Network implements Cloneable{

    private String ip;
    private String data;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public  void ImpData() throws InterruptedException {
        this.data = "Very important data";
        Thread.sleep(5000);
    }


    @Override
    public String toString() {
        return "Network{" +
                "ip='" + ip + '\'' +
                ", data='" + data + '\'' +
                '}';
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}