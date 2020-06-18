package com.xiaxin.ch06.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockTest {
    public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
        RandomAccessFile raf = new RandomAccessFile("d:/abc.txt", "rw");
        FileChannel fileChannel = raf.getChannel();
        /*
            将abc.txt中position=2，size=4的内容加锁（即只对文件的部分内容加了锁）。
            lock()第三个布尔参数的含义如下：
                true:共享锁。实际上是指“读共享”：某一线程将资源锁住之后，其他线程既只能读、
不能写该资源。
                false:独占锁。某一线程将资源锁住之后，其他线程既不能读、也不能写该资源。
         */
        //①
        FileLock fileLock = fileChannel.lock(2, 4, true);
        System.out.println("main线程将abc.txt锁10秒...");
        //noinspection AlibabaAvoidManuallyCreateThread
        new Thread(
                () -> {
                    try {
                        byte[] bs = new byte[8];
//                        //②新线程对abc.txt进行读操作
                        raf.read(bs, 0, 8);
                        System.out.println(new String(bs,0,bs.length));
                        //③新线程对abc.txt进行写操作
                        raf.write("cuixiaqing".getBytes(), 0, 8);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }).start();
        //模拟main线程将abc.txt锁3秒的操作
        Thread.sleep(10000);
        System.out.println("10秒结束，main释放锁");
        fileLock.release();
    }
}