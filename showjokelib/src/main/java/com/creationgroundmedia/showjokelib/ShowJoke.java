package com.creationgroundmedia.showjokelib;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class ShowJoke extends AppCompatActivity {
    public static String JOKETEXT = "Joke Text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View view = inflater.inflate( R.layout.activity_show_joke, null );
        setContentView(view);

        TextView jokeView = (TextView) view.findViewById(R.id.joke_view);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            String jokeText = extras.getString(JOKETEXT);
            if (jokeText != null) {
                jokeView.setText(jokeText);
            }
        }
    }
}
