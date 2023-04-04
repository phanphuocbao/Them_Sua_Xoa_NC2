package longh.dev.mvppattern;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import longh.dev.mvppattern.persenter.PresenterSignup;

public class SignupActivity extends AppCompatActivity implements SignupConstract.IView{
    private SignupConstract.IPresenter SUPresenter;
    private EditText edtEmailSignup, edtPassSignup;
    Button btnSignup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        initGUI();
    }

    private void initGUI() {
        edtEmailSignup = findViewById(R.id.edit_emailSignup);
        edtPassSignup = findViewById(R.id.edit_passSignup);
        btnSignup = findViewById(R.id.btn_dangkySignup);
        SUPresenter = new PresenterSignup(this);
        btnSignup.setOnClickListener(view -> {
            String user = edtEmailSignup.getText().toString();
            String pass = edtPassSignup.getText().toString();
            SUPresenter.doSignup(user,pass);

        });

    }

    @Override
    public void showSignupSuccess() {
        Toast.makeText(this, "Register Success", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(SignupActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void showSignupFailed() {
        Toast.makeText(this, "Register Failed", Toast.LENGTH_SHORT).show();

    }
}