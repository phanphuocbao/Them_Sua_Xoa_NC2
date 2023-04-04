package longh.dev.mvppattern;

public interface RegisterConstract {
    interface IView{

        void showRegisterSuccess();
        void showRegisterFailed();
    }
    interface IPresenter{

        void doRegister(String emailR, String passR);

    }}
