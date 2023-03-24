package longh.dev.mvppattern.persenter;

import longh.dev.mvppattern.Constract;
import longh.dev.mvppattern.MainActivity;
import longh.dev.mvppattern.data.Database;
import longh.dev.mvppattern.data.DatabaseDao;
import longh.dev.mvppattern.data.dao.UserDao;
import longh.dev.mvppattern.data.impl.UserDaoImpl;
import longh.dev.mvppattern.data.model.User;

public class Presenter implements Constract.IPresenter {
    private Constract.IView mView;
    public Presenter(Constract.IView view){
        mView = view;
        DatabaseDao.init(new Database());
    }
    @Override
    public void dologin(String email, String pass) {
        UserDao userDao = DatabaseDao.getInstance().getUserDao();
        User user = userDao.find(email, pass);
        if(user == null){
            mView.showloginFailed();
        }else{
            mView.showloginsuccess();
        }
    }

    @Override
    public void forgotpass() {

    }
}
