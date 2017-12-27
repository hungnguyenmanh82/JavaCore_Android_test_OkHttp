package com.hung.okhttptest;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 *  guide all here:
 *  https://github.com/square/okhttp/wiki/Recipes
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        System.out.println("Start Test");
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test_OkHttp_Get_Synchronous() throws Exception {

        // avoid creating several instances, should be singleon
        OkHttpClient client = new OkHttpClient();

        // url is
        Request request = new Request.Builder()
                .url("http://www.vogella.com/index.html")
                .build();


        System.out.println("====================== request header ====================");
        System.out.println(request.toString());  //show url here
        System.out.println(request.headers().toString()); //error: not show all header for example: url in header here

        //start send request here.
        Response response = client.newCall(request).execute();

        // synchronous receive response here
        // https://en.wikipedia.org/wiki/List_of_HTTP_status_codes
        System.out.println("====================== response code ================== " );
        System.out.println("response code = " + response.code());
        if( response.code() == 200){ //200 = 0k
            //do something here
        }

        if( response.isSuccessful() == true){ //response code = 200 to 300
            //do something here
        }

        if( response.isRedirect()){ //response code = 3xx
            //do something here
        }

        //================================ response header =================
        Headers headers = response.headers();
        Map<String, List<String>> map = headers.toMultimap();
        System.out.println("====================== response header ====================");
        System.out.print(headers.toString());

        assertEquals(4, 2 + 2);
    }

    @Test
    public void test_OkHttp_Syn_GET_Timeout() throws Exception {

        // avoid creating several instances, should be singleon
        OkHttpClient  client = new OkHttpClient();

        //=========================== TimeOut ===================================
        // throw Timeout exception
        client.setConnectTimeout(10, TimeUnit.SECONDS);
        client.setWriteTimeout(10, TimeUnit.SECONDS);
        client.setReadTimeout(30, TimeUnit.SECONDS);

        // url is
        Request request = new Request.Builder()
                .url("http://www.vogella.com/index.html")

                .build();


        System.out.println("====================== request header ====================");
        System.out.println(request.toString());  //show url here
        System.out.println(request.headers().toString()); //error: not show all header for example: url in header here

        //start send request here.
        Response response = client.newCall(request).execute();

        // synchronous receive response here
        // https://en.wikipedia.org/wiki/List_of_HTTP_status_codes
        System.out.println("====================== response code ================== " );
        System.out.println("response code = " + response.code());
        if( response.code() == 200){ //200 = 0k
            //do something here
        }

        if( response.isSuccessful() == true){ //response code = 200 to 300
            //do something here
        }

        if( response.isRedirect()){ //response code = 3xx
            //do something here
        }

        //================================ response header =================
        Headers headers = response.headers();
        Map<String, List<String>> map = headers.toMultimap();
        System.out.println("====================== response header ====================");
        System.out.print(headers.toString());

        assertEquals(4, 2 + 2);
    }


    @Test
    public void test_OkHttp_Sync_Get_requestHeader() throws Exception {

        // avoid creating several instances, should be singleon
        OkHttpClient client = new OkHttpClient();

        // url is
        Request request = new Request.Builder()
                .url("http://www.vogella.com/index.html")
                .addHeader("content-type","application/xhtml+xml")
                .addHeader("testName","valueName")             //an example:  user definition (not http standard parameter)
                .header("Authorization", "your token")         //an example: authorization (user definition)
                .build();


        System.out.println("====================== request header ====================");
        System.out.println(request.toString());  //show url here
        System.out.println(request.headers().toString()); //error: not show all header for example: url in header here

        //start send request here.
        Response response = client.newCall(request).execute();

        // synchronous receive response here
        // https://en.wikipedia.org/wiki/List_of_HTTP_status_codes
        System.out.println("====================== response code ================== " );
        System.out.println("response code = " + response.code());
        if( response.code() == 200){ //200 = 0k
            //do something here
        }

        if( response.isSuccessful() == true){ //response code = 200 to 300
            //do something here
        }

        if( response.isRedirect()){ //response code = 3xx
            //do something here
        }

        //================================ response header =================
        Headers headers = response.headers();
        Map<String, List<String>> map = headers.toMultimap();
        System.out.println("====================== response header ====================");
        System.out.print(headers.toString());

        assertEquals(4, 2 + 2);
    }

    @Test
    public void test_OkHttp_Syn_Get_parameters() throws Exception {

        // avoid creating several instances, should be singleon
        OkHttpClient client = new OkHttpClient();

        //==================================== build URL of http GET =================
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.github.help").newBuilder();
        urlBuilder.addQueryParameter("v", "1.0");
        urlBuilder.addQueryParameter("user", "vogella");
        String url = urlBuilder.build().toString();
        // =============================

        Request request = new Request.Builder()
                .url(url)
                .build();

        System.out.println("====================== request header ====================");
        System.out.println(request.toString());  //show url here
        System.out.println(request.headers().toString()); //error: not show all header for example: url in header here

        //start send request here.
        Response response = client.newCall(request).execute();

        // synchronous receive response here
        // https://en.wikipedia.org/wiki/List_of_HTTP_status_codes
        System.out.println("====================== response code ================== " );
        System.out.println("response code = " + response.code());

        //================================ response header =================
        Headers responseHeaders = response.headers();
        Map<String, List<String>> map = responseHeaders.toMultimap();

        //header of response
        //System.out.print(headers.toString());

        //body of response
        String body = response.body().string();
        System.out.print(body);

        assertEquals(4, 2 + 2);
    }

    @Test
    public void test_OkHttp_Syn_Get_responseHeader() throws Exception {

        // avoid creating several instances, should be singleon
        OkHttpClient client = new OkHttpClient();

        //==================================== build URL of http GET =================
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.github.help").newBuilder();
        urlBuilder.addQueryParameter("v", "1.0");
        urlBuilder.addQueryParameter("user", "vogella");
        String url = urlBuilder.build().toString();
        // =============================

        Request request = new Request.Builder()
                .url(url)
                .build();

        //start send request here.
        Response response = client.newCall(request).execute();

        //================================ response header =================
        Headers responseHeaders = response.headers();
        Map<String, List<String>> map = responseHeaders.toMultimap();

        //header of response
        //System.out.print(headers.toString());

        //body of response
        String body = response.body().string();
        System.out.print(body);

        assertEquals(4, 2 + 2);
    }

    /**
     * use Okhttp asynchronouse with callback function
     */
    @Test
    public void test_OkHttp_Asynchronous_Get() throws Exception {

        // avoid creating several instances, should be singleon
        OkHttpClient client = new OkHttpClient();

        // url is
        Request request = new Request.Builder()
                .url("http://www.vogella.com/index.html")
                .build();


        System.out.println("====================== request header ====================");
        System.out.println(request.toString());  //show url here
        System.out.println(request.headers().toString()); //error: not show all header for example: url in header here

        //start send request here.
        client.newCall(request).enqueue( new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                //e.printStackTrace();
                System.out.println("Error: request Failure ========================");
            }

            @Override
            public void onResponse(Response response) throws IOException {
                // synchronous receive response here
                // https://en.wikipedia.org/wiki/List_of_HTTP_status_codes
                System.out.println("====================== response code ================== " );
                System.out.println("response code = " + response.code());

                //================================ response header =================
                Headers responseHeaders = response.headers();
                Map<String, List<String>> map = responseHeaders.toMultimap();

                //header of response
                //System.out.print(headers.toString());

                //body of response
                String body = response.body().string();
                System.out.print(body);

            }
        });

        Thread.sleep(5000); //waiting for Asynchrous worker thread end
        assertEquals(4, 2 + 2);
    }


    @Test
    public void test_OkHttp_Sync_Post_requestHeader() throws Exception {

        // avoid creating several instances, should be singleon
        OkHttpClient client = new OkHttpClient();

        //============================== code POST body ================================
        //phần này chèn vào header request, ko phải ở body của request
        // text/x-markdown chính là content-type ở header giống như json thôi, ko có gì
        MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown; charset=utf-8");

        //phần này làm khó hiểu về http protocol (stupid): jump vào code sẽ rõ
        RequestBody requestBody = RequestBody.create(MEDIA_TYPE_MARKDOWN,"ko co vieec gi kho");
        //================================= end code Post body ==========================


        // url is
        Request request = new Request.Builder()
                .url("http://www.vogella.com/index.html")
                .addHeader("content-type","application/xhtml+xml")
                .addHeader("testName","valueName")             //an example:  user definition (not http standard parameter)
                .header("Authorization", "your token")         //an example: authorization (user definition)
                .post(requestBody)
                .build();


        System.out.println("====================== request header ====================");
        System.out.println(request.toString());  //show url here
        System.out.println(request.headers().toString()); //error: not show all header for example: url in header here

        //start send request here.
        Response response = client.newCall(request).execute();

        // synchronous receive response here
        // https://en.wikipedia.org/wiki/List_of_HTTP_status_codes
        System.out.println("====================== response code ================== " );
        System.out.println("response code = " + response.code());
        if( response.code() == 200){ //200 = 0k
            //do something here
        }

        if( response.isSuccessful() == true){ //response code = 200 to 300
            //do something here
        }

        if( response.isRedirect()){ //response code = 3xx
            //do something here
        }

        //================================ response header =================
        Headers headers = response.headers();
        Map<String, List<String>> map = headers.toMultimap();
        System.out.println("====================== response header ====================");
        System.out.print(headers.toString());

        assertEquals(4, 2 + 2);
    }
}