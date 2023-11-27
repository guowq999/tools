package com.owen.json;

import com.alibaba.fastjson.JSONObject;

/**
 * @author wenqiang
 * @date 2023/07/01 15:05
 **/
public class Demo {
    public static void main(String[] args) {
        String str = "{\"errNum\":0,\"errMsg\":\"success\",\"retData\":[{\"title\":\"\\u6536\\u5e9f\\u54c1\\u5927\\u53d4\\u521a\\u4e0a\\u53f0\\uff0c\\u5c31\\u60e8\\u906d\\u8bc4\\u59d4\\u706d\\u706f\\uff0c\\u4f46\\u63a5\\u4e0b\\u6765\\u5168\\u573a\\u90fd\\u9707\\u60ca\\u4e86\\uff01\",\"url\":\"http:\\/\\/toutiao.com\\/group\\/6263036756505920002\\/\",\"abstract\":\"\\u8ba2\\u9605\\u6211\\u83b7\\u53d6\\u66f4\\u591a\\u7cbe\\u5f69\\u5185\\u5bb9\\uff01\",\"image_url\":\"http:\\/\\/p1.pstatp.com\\/list\\/2f90009a31a7ee8bb15\"}]}";
        JSONObject jsonObject = JSONObject.parseObject(str);
        String resultCur = JSONObject.parseObject(str).toJSONString();
        System.out.println(jsonObject);
    }

}