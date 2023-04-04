package longh.dev.mvppattern;

import android.widget.Adapter;

public interface Constract {
    interface IView{
        void showloginsuccess();
        void showloginFailed();
        void showRegisterSuccess();
        void showRegisterFailed();
    }
    interface IPresenter{
        void dologin(String emailL, String passL);
        void forgotpass();
        Adapter list();
    }
}
