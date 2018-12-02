package okhttp3.indi.spider.okhttp.unit;


import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.internal.http2.Header;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import sun.awt.image.BufferedImageDevice;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class HttpURLTest {

    private final static Log log = LogFactory.getLog(HttpUrl.class);

    @Test
    public void httpURLParse() {
        String url = "https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=0&rsv_idx=1&tn=baidu&wd=zhangnala&rsv_pq=80bbd93300026c63&rsv_t=acb3G2M6OItKLj1cuQkOyz7oXcuImdoG0eSs5dupBYOyP4EQBYt%2B6JZvJHo&rqlang=cn&rsv_enter=1&rsv_sug3=22&rsv_sug1=31&rsv_sug7=101&rsv_sug2=0&inputT=5495&rsv_sug4=5496";
        HttpUrl httpUrl = HttpUrl.parse(url);
        if (log.isInfoEnabled()) {
            log.info(httpUrl);
            log.info("schema: " + httpUrl.scheme());
            log.info("fragment: " + httpUrl.fragment());
            log.info("queryNamesAndValues: ");
            httpUrl.queryParameterNames().stream().forEach(item -> {
                log.info("paramName: " + item + " : " + httpUrl.queryParameterValues(item));
            });
            httpUrl.pathSegments().stream().forEach(path -> {
                log.info("path: " + path);
            });

            log.info("query: " + httpUrl.query());

        }
    }


    @Test  public void httpHeaderTest(){
        Headers.Builder builder = new Headers.Builder();
        builder.add("username", "test");
        builder.add("content-type", "application/json");
        Headers headers = builder.build();
        if(log.isInfoEnabled()){
            log.info("headerNames: " + headers.names());
            headers.names().stream().forEach(name -> {
                log.info("name: " + name + ':' + headers.values(name));
            });
        }

        Map<String,String> map = new HashMap<>();
        map.put("content-type", "text/html");
        map.put("cookie", "sessionid=" + UUID.randomUUID().toString());

        Headers newHeaders = Headers.of(map);
        if(log.isInfoEnabled()){
            log.info("headerNames: " + newHeaders.names());
            newHeaders.names().stream().forEach(name -> {
                log.info("name: " + name + ':' + newHeaders.values(name));
            });
        }

    }

}
