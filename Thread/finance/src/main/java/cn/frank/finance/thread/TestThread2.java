package cn.frank.finance.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;

/**
 * @author 87507
 */
public class TestThread2 extends Thread {

    private String name;
    private String url;

    public TestThread2(String url, String name) {

        this.url = url;
        this.name = name;
    }
    @Override
    public void run() {

        WebDownloader webDownloader = new WebDownloader();
        webDownloader.download(url, name);
        System.out.println("下载了文件名为" + name);

    }
}

class WebDownloader {

    public void download(String url, String name) {

        try {

            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
