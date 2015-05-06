package vin.com.helloworld;

import android.app.ActionBar;
import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity implements View.OnClickListener, TextWatcher {

    TextView mainTextView;
    Button mainButton;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainTextView = (TextView) findViewById(R.id.main_textview);
        mainTextView.setText("Set in Main Activity");

        mainButton = (Button) findViewById(R.id.main_button);
        mainButton.setOnClickListener(this);

        editText = (EditText)findViewById(R.id.main_edittext);
        editText.addTextChangedListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public void onClick(View view) {
        mainTextView.setText("updated on click");
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        System.out.println("before text changes");
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        System.out.println("on text change");
    }

    @Override
    public void afterTextChanged(Editable editable) {
        System.out.println("after text change");
        mainTextView.setText(editText.getText().toString());

    }
}
