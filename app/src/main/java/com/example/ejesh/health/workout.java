package com.example.ejesh.health;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class workout extends AppCompatActivity {

    YouTubePlayerView youTubePlayerView;
    Button button;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    String age;

    WebView webView;

    HealthilyPreference healthilyPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga);

        healthilyPreference = new HealthilyPreference(this);
        webView = findViewById(R.id.webView);

        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);


        age = healthilyPreference.getAccountAge();
        if (Integer.valueOf(age) > 13 && Integer.valueOf(age) <= 19) {

            webView.loadUrl("https://www.youtube.com/results?search_query=workout+for+teenager+at+home");
            webView.setWebViewClient(new WebViewClient() {
                @Override
                public void onPageFinished(WebView view, String url)
                {
                    webView.loadUrl("javascript:(function() { " +
                            "var head = document.getElementsByTagName('header')[0];"
                            + "head.parentNode.removeChild(head);" +
                            "})()");
                }
            });

        } else if (Integer.valueOf(age) > 20 && Integer.valueOf (age)<=50) {
            webView.loadUrl("https://www.youtube.com/results?search_query=workout+for+20-50+at+home");

            webView.setWebViewClient(new WebViewClient() {
                @Override
                public void onPageFinished(WebView view, String url)
                {
                    webView.loadUrl("javascript:(function() { " +
                            "var head = document.getElementsByTagName('header')[0];"
                            + "head.parentNode.removeChild(head);" +
                            "})()");
                }
            });


        }else if(Integer.valueOf (age)>51&& Integer.valueOf (age)<=90){
            webView.loadUrl("https://www.youtube.com/results?search_query=workout+for+older+age+at+home");

            webView.setWebViewClient(new WebViewClient() {
                @Override
                public void onPageFinished(WebView view, String url)
                {
                    webView.loadUrl("javascript:(function() { " +
                            "var head = document.getElementsByTagName('header')[0];"
                            + "head.parentNode.removeChild(head);" +
                            "})()");
                }
            });

        }


    }
}
