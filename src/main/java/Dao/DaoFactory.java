package Dao;

import Dao.custom.Impl.UserDaoImpl;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory  () {
    }

    public static DaoFactory  getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DaoFactory () : daoFactory;
    }

    public enum DAOTypes {
       USER
    }

    public SuperDAO getDAO(DAOTypes types){
        switch (types) {
            case USER:
                return new UserDaoImpl();
            default:
                return null;
        }
    }
}
