package cn.frank.finance.thread;

import java.util.concurrent.*;

/**
 * Callable接口
 *
 * @author zhangfan
 * @date 2022/6/7 11:23
 */
public class CallableDemo implements Callable<Boolean> {

    private String url;
    private String name;

    public CallableDemo(String url, String name) {

        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception {

        WebDownloader webDownloader = new WebDownloader();
        webDownloader.download(url, name);
        System.out.println("下载了文件名为：" + name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CallableDemo callableDemo = new CallableDemo("https://pics6.baidu.com/feed/0dd7912397dda1444d96addf9733a3a80df4864b.jpeg?token=255c2d015b6e1c65db9218b80c9a27fc", "1.jpg");

        //创建执行服务
        ExecutorService service = Executors.newFixedThreadPool(1);
        //提交执行
        Future<Boolean> result = service.submit(callableDemo);
        //获取结果
        boolean rs1 = result.get();
        //关闭服务
        System.out.println(rs1);
        service.shutdownNow();
    }

}
