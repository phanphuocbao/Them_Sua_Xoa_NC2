package longh.dev.mvppattern;

import android.widget.Adapter;

public interface SignupConstract {
    interface IView{
        void showSignupSuccess();
        void showSignupFailed();

    }
    interface  IPresenter{
       void doSignup(String email, String pass);
       Adapter list();
    }
}
