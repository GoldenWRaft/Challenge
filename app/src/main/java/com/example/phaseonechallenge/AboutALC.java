package com.example.phaseonechallenge;

import android.annotation.SuppressLint;
import android.net.http.SslError;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
public class AboutALC extends AppCompatActivity {

    private Handler uihandler;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);

        uihandler = new Handler();
        webView = findViewById(R.id.wv_about_alc);
        runWebViewOnNewThread();
    }

    public void runWebViewOnNewThread(){
        uihandler.post(new Runnable(){
            @SuppressLint("SetJavaScriptEnabled")
            @Override
            public void run(){
                webView.setWebViewClient(new WebViewClient(){
                    @Override
                    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                        handler.proceed();
                    }
                });
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl("https://andela.com/alc/");
            }
        });
    }
}
