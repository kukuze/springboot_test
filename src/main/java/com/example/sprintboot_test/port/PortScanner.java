package com.example.sprintboot_test.port;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PortScanner {

    public static void main(String[] args) {
        String ipAddress = "128.128.1.139";  // 要扫描的 IP 地址
        int startPort = 1;               // 起始端口
        int endPort = 65535;             // 结束端口
        int numThreads = 1000;            // 线程数
        List<Integer> res=new CopyOnWriteArrayList();
        System.out.println("Scanning ports on " + ipAddress + "...");

        // 创建固定大小的线程池
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        for (int port = startPort; port <= endPort; port++) {
            final int currentPort = port;
            int finalPort = port;
            executor.execute(() -> {
                try {
                    System.out.println(finalPort);
                    Socket socket = new Socket(ipAddress, currentPort);
                    res.add(currentPort);
                    socket.close();
                } catch (IOException e) {
                    // 如果连接失败，则认为端口关闭
                }
            });
        }

        // 关闭线程池
        executor.shutdown();

        // 等待所有任务完成
        while (!executor.isTerminated()) {
            // 空循环
        }

        System.out.println("Port scanning finished."+res);
    }
}
