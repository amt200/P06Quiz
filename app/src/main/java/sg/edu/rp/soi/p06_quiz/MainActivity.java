package sg.edu.rp.soi.p06_quiz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

EditText num1, num2;
TextView result, operation;
Button reset;
int firstNum = 0;
int secondNum = 0;
int value = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = findViewById(R.id.etNum1);
        num2 = findViewById(R.id.etNum2);
        operation = findViewById(R.id.tvOperation);
        result = findViewById(R.id.tvResult);
        reset = findViewById(R.id.btnReset);

        registerForContextMenu(operation);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1.setText("");
                num2.setText("");
            }
        });
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_main, menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.plus) {
            firstNum = Integer.parseInt(num1.getText().toString());
            secondNum = Integer.parseInt(num2.getText().toString());
            value = firstNum + secondNum;
            result.setText(value+"");
            return true;
        } else {
            int firstNum = Integer.parseInt(num1.getText().toString());
            int secondNum = Integer.parseInt(num2.getText().toString());
            if (firstNum > secondNum) {
                value = firstNum - secondNum;
                result.setText(value+"");
            } else {
                value = secondNum - firstNum;
                result.setText(value+"");
            }

        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }

}




