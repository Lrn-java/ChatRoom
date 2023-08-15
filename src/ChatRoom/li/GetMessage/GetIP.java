package ChatRoom.li.GetMessage;

import javax.swing.*;
import java.io.IOException;
import java.net.*;
import java.util.Enumeration;


import static java.lang.System.out;

/**
 * 这个接口是用来获取用户IP地址
 *
 * @author Lrn
 */
public interface GetIP {

    /**
     * 获取IPv4地址
     */
    default String getIPv4() {
        StringBuilder resultBuilder = new StringBuilder();

        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            int count = 0;
            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();
                if (networkInterface.isUp() && !networkInterface.isLoopback()) {
                    Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
                    while (addresses.hasMoreElements()) {
                        InetAddress address = addresses.nextElement();
                        if (address.getHostAddress().contains(":")) {
                            continue; // Skip IPv6 addresses
                        }
                        String ipAddress = address.getHostAddress();
                        count++;
                        if (count == 2) {
                            resultBuilder.append(ipAddress);
                            break;
                        }
                    }
                }
                if (count == 2) {
                    break;
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }

        return resultBuilder.toString();
    }

    /**
     * 预留的不用管
     * 获取IPv6地址
     */
    default void getIPv6(){
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            int count = 0;
            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();
                if (networkInterface.isUp() && !networkInterface.isLoopback()) {
                    Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
                    while (addresses.hasMoreElements()) {
                        InetAddress address = addresses.nextElement();
                        if (!address.getHostAddress().contains(":")) {
                            continue;
                        }
                        String ipAddress = address.getHostAddress();
                        count++;
                        if (count == 2) {
                            out.println(ipAddress);
                            break;
                        }
                    }
                }
                if (count == 2) {
                    break;
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析网络，判断用户网络连接情况
     * @return 返回解析网址后的结果
     */
    default boolean isNetworkAvailable() {
        try {
            // 检查是否能够连接到互联网
            URL url = new URL("https://www.baidu.com/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();
            connection.disconnect();
            return responseCode == 200;
        } catch (IOException e) {
            // 出现异常，网络不可用
        }
        return false;
    }
}