package longh.dev.mvppattern.data;

import longh.dev.mvppattern.data.dao.UserDao;
import longh.dev.mvppattern.data.impl.UserDaoImpl;

public class Database extends DatabaseDao{
    @Override
    UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
