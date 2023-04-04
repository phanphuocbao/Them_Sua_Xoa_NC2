package longh.dev.mvppattern.persenter;

import android.app.Activity;
import android.widget.Adapter;

import longh.dev.mvppattern.SignupConstract;
import longh.dev.mvppattern.data.Database;
import longh.dev.mvppattern.data.DatabaseDao;
import longh.dev.mvppattern.data.adapter.AdapterUser;
import longh.dev.mvppattern.data.dao.UserDao;
import longh.dev.mvppattern.data.model.User;

public class PresenterSignup implements SignupConstract.IPresenter {
    private SignupConstract.IView mView;

    public PresenterSignup(SignupConstract.IView View) {
        this.mView = View;
        DatabaseDao.init(new Database((Activity) mView));
    }

    @Override
    public void doSignup(String email, String pass) {
        UserDao userDao = DatabaseDao.getInstance().getUserDao();
        if(userDao.insert(new User(email,pass)) == true){
            mView.showSignupSuccess();
        }else{
            mView.showSignupFailed();
        }
    }

    @Override
    public Adapter list() {
        UserDao userDao = DatabaseDao.getInstance().getUserDao();
        AdapterUser adapter = new AdapterUser((Activity)mView, userDao.findAll());
        return adapter;

    }
}
