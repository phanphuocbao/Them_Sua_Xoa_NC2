package longh.dev.mvppattern;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import longh.dev.mvppattern.persenter.Presenter;

public class MainActivity extends AppCompatActivity implements Constract.IView{

    private Constract.IPresenter iPresenter;

    private EditText edtemail,edtpass;
    private Button btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initgui();
    }
    public void initgui(){
        edtemail = findViewById(R.id.edit_email);
        edtpass = findViewById(R.id.edit_pass);
        btnlogin = findViewById(R.id.btn_dangnhap);
        iPresenter = new Presenter(this);
        btnlogin.setOnClickListener(view ->{
            String user = edtemail.getText().toString();
            String pass = edtpass.getText().toString();
            iPresenter.dologin(user , pass);
        });
    }

    @Override
    public void showloginsuccess() {
        Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showloginFailed() {
        Toast.makeText(MainActivity.this, "Login Failes", Toast.LENGTH_SHORT).show();
    }
}