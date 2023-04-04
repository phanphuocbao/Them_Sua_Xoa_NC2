package longh.dev.mvppattern;

import android.widget.Adapter;

public interface ListConstract {
    interface IView{
        void showDeletesuccess();
        void showDeletefailed();
    }
    interface IPresenter{
        void delete(int id);
        Adapter list();
    }
}
