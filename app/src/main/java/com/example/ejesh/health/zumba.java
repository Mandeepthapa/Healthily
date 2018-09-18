package com.example.ejesh.health;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class zumba extends YouTubeBaseActivity {

    YouTubePlayerView youTubePlayerView;
    Button button;
    YouTubePlayer.OnInitializedListener onInitializedListener;
    String age;
    HealthilyPreference healthilyPreference;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_yoga);
        healthilyPreference = new HealthilyPreference (this);
        webView = findViewById (R.id.webView);

        webView.setWebViewClient (new WebViewClient ( ));
        webView.getSettings ( ).setJavaScriptEnabled (true);


        age = healthilyPreference.getAccountAge ( );
        if (Integer.valueOf (age) > 13 && Integer.valueOf (age) <= 19) {

            webView.loadUrl ("https://www.youtube.com/results?search_query=zumba+for+teenagers");
            webView.setWebViewClient (new WebViewClient ( ) {
                @Override
                public void onPageFinished(WebView view, String url) {
                    webView.loadUrl ("javascript:(function() { " +
                            "var head = document.getElementsByTagName('header')[0];"
                            + "head.parentNode.removeChild(head);" +
                            "})()");
                }
            });

        } else if (Integer.valueOf (age) > 20 && Integer.valueOf (age) <= 50) {
            webView.loadUrl ("https://www.youtube.com/results?search_query=zumba+");

            webView.setWebViewClient (new WebViewClient ( ) {
                @Override
                public void onPageFinished(WebView view, String url) {
                    webView.loadUrl ("javascript:(function() { " +
                            "var head = document.getElementsByTagName('header')[0];"
                            + "head.parentNode.removeChild(head);" +
                            "})()");
                }
            });


        } else if (Integer.valueOf (age) > 51 && Integer.valueOf (age) <= 90) {
            webView.loadUrl ("https://www.youtube.com/results?search_query=zumba+for+old+age++");

            webView.setWebViewClient (new WebViewClient ( ) {
                @Override
                public void onPageFinished(WebView view, String url) {
                    webView.loadUrl ("javascript:(function() { " +
                            "var head = document.getElementsByTagName('header')[0];"
                            + "head.parentNode.removeChild(head);" +
                            "})()");
                }
            });

        }

    }
}
