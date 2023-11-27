package com.owen.hutool;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.StreamProgress;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author wenqiang
 * @date 2023/06/15 14:24
 **/
public class Demo {

    /**
     * GET请求
     */
    @Test
    public void test() {
        // 最简单的GET请求
//        String content = HttpUtil.get("http://127.0.0.1:8097/tms/carrier/driver/linked/test");
//        System.out.println(content);

        // 当无法识别页面编码的时候，可以自定义请求页面的编码
//        String result2= HttpUtil.get("https://www.baidu.com", CharsetUtil.CHARSET_UTF_8);

        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("city", "北京");

        String result3= HttpUtil.get("http://127.0.0.1:8097/tms/carrier/driver/linked/test", paramMap);

    }

    /**
     * POST请求
     */
    @Test
    public void test01() {
        // 最简单的POST请求
        // 默认的POST请求表单数据放在"pplication/x-www-form-urlencoded"，请求头中的content-type指定值就是该值
        // 服务端不能是@RequestBody，需要和get请求一致
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("city", "北京");

        String result1 = HttpUtil.post("http://127.0.0.1:8097/tms/carrier/driver/linked/test", paramMap);

    }

    /**
     * 上传文件
     */
    @Test
    public void test02() {
        HashMap<String, Object> paramMap = new HashMap<>();
        //文件上传只需将参数中的键指定（默认file），值设为文件对象即可，对于使用者来说，文件上传与普通表单提交并无区别
        paramMap.put("file", FileUtil.file("C:\\Users\\10712\\Desktop\\QQ截图20221215144746.png"));

        String result= HttpUtil.post("https://www.baidu.com", paramMap);
    }

    /**
     * 下载文件见官方文档
     */
    @Test
    public void test03() {
        String fileUrl = "https://cdn.pixabay.com/photo/2023/05/29/19/24/peonies-8027028_1280.jpg";

        //将文件下载后保存在E盘，返回结果为下载文件大小
        long size = HttpUtil.downloadFile(fileUrl, FileUtil.file("D:/"));
        System.out.println("Download size: " + size);

        // downloadFile可以输出到流中
    }

    /**
     * 展示下载进度
     */
    @Test
    public void test04() {
//带进度显示的文件下载
        HttpUtil.downloadFile("https://cdn.pixabay.com/photo/2023/05/29/19/24/peonies-8027028_1280.jpg"
                , FileUtil.file("D:/")
                , new StreamProgress(){

            @Override
            public void start() {
                Console.log("开始下载。。。。");
            }

            @Override
            public void progress(long progressSize) {
                Console.log("已下载：{}", FileUtil.readableFileSize(progressSize));
            }

            @Override
            public void finish() {
                Console.log("下载完成！");
            }
        });

    }

    @Test
    public void test05() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("city", "北京");
        paramMap.put("city1", "上海");
        String params = HttpUtil.toParams(paramMap);
        System.out.println(params);
    }


}