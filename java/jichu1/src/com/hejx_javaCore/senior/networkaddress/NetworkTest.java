package com.hejx_javaCore.senior.networkaddress;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Classname NetworkTest
 * @Description TODO
 * @Date 8:12 2021/1/28
 * @Created by hejx
 *
 * 一、网络编程中有两个主要的问题：
 *    1.如何准确的定位网络上一台或多台主机；定位主机上的特定的应用
 *    2.找到主机后如何可靠高效地进行数据传输
 * 二、网络编程中的两个要素：
 * 1.对应问题一：IP和端口号
 * 2.对应问题二：提供网络通信协议：TCP/IP参考模型(应用层、传输层、网络层、物理+数据链路层)
 *
 *
 *三、通信要素一：IP和端口号
 *  1.IP:唯一的标识Internet上的计算机(通信实体)
 *  2.在Java中使用InetAddress类代表IP
 *  3.IP分类：IPV4与IPV6、公有网与局域网
 *  4.域名
 *  5.本地回路地址：127.0.0.1 对应着localhost
 *  6.如何实例化 InetAddress:两个方法：getByName(String host)/getLocalHost()
 *               两个常用方法：getHostName()/getHostAddress()
 *
 *  7.端口号：标识正在计算机上运行的进程(0~65535)
 *
 *  8.端口号与IP地址的组合得出一个网络套接字：Socket
 *
 *
 *  四、网络通信协议
 *  TCP
 *  UDP
 *
 *
 */

public class NetworkTest {

    @Test
    public void test1() throws UnknownHostException {
        InetAddress byName = InetAddress.getByName("192.168.10.4");
        System.out.println(byName);

        InetAddress byName1 = InetAddress.getByName("www.hejxtom.ltd");
        System.out.println(byName1);

        InetAddress byName2 = InetAddress.getByName("localhost");
        System.out.println(byName2);

        //获取本地IP
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

        //
        System.out.println(localHost.getHostName());

        //
        System.out.println(localHost.getHostAddress());

    }


    @Test
    public void test2(){



    }





}
