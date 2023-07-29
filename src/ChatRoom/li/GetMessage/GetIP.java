package ChatRoom.li.GetMessage;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
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
                            System.out.println(ipAddress);
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
}

