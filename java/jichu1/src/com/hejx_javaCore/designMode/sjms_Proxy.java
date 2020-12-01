package com.hejx_javaCore.designMode;
/**
 *代理模式
 *
 *
 *
 *
 */
public class sjms_Proxy {
   public static void main(String[] args){
       Server server=new Server();

       ProxyServer proxyServer = new ProxyServer(server);

       proxyServer.browse();


   }

}

interface Network{
    public void browse();
}

//被代理类
class Server implements Network{

    @Override
    public void browse() {
         System.out.println("真实的服务器访问网络");
    }
}

//代理类
class ProxyServer implements  Network{
    private Network network;

    public ProxyServer( Network network){
        this.network=network;
    }

    public void check(){
        System.out.println("联网之前的检查工作！");
    }

    @Override
    public void browse() {
        this.check();
        network.browse();
    }

}
