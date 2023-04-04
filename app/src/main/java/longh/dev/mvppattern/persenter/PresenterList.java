package longh.dev.mvppattern.persenter;

import android.app.Activity;
import android.content.Context;
import android.widget.Adapter;

import longh.dev.mvppattern.ListConstract;
import longh.dev.mvppattern.data.Database;
import longh.dev.mvppattern.data.DatabaseDao;
import longh.dev.mvppattern.data.adapter.AdapterUser;
import longh.dev.mvppattern.data.dao.UserDao;

public class PresenterList implements ListConstract.IPresenter {
    private ListConstract.IView lView;
    public PresenterList(ListConstract.IView View){
        lView = View;
        DatabaseDao.init(new Database((Context) lView));
    }

    @Override
    public void delete(int id) {
        UserDao userDao = DatabaseDao.getInstance().getUserDao();
        if(userDao.delete(id) == true){
            lView.showDeletesuccess();
        }else{
            lView.showDeletefailed();
        }
    }

    @Override
    public Adapter list() {
        UserDao userDao = DatabaseDao.getInstance().getUserDao();
        AdapterUser adapter = new AdapterUser((Activity) lView, userDao.findAll());
        return adapter;
    }
}
