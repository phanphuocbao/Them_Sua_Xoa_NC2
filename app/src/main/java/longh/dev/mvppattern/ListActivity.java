package longh.dev.mvppattern;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import longh.dev.mvppattern.persenter.Presenter;
import longh.dev.mvppattern.persenter.PresenterList;

public class ListActivity extends AppCompatActivity implements Constract.IView, ListConstract.IView {
    private ListView lstuser;
    private ListConstract.IPresenter iPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initgui();
    }

    private void initgui() {
        lstuser = findViewById(R.id.lstUser);
        iPresenter = new PresenterList(this);
        lstuser.setAdapter((ListAdapter) iPresenter.list());

        }

    @Override
    public void showloginsuccess() {

    }

    @Override
    public void showloginFailed() {

    }

    @Override
    public void showRegisterSuccess() {

    }

    @Override
    public void showRegisterFailed() {

    }

    @Override
    public void showDeletesuccess() {

    }

    @Override
    public void showDeletefailed() {

    }
}
