/**
 * Created by crazyacking on 16-5-10.
 */
public class ServiceImpl implements IService {
    private IDao dao;

    public IDao getDao(){
        return this.dao;
    }
    public void setDao(DaoImpl dao) {
        this.dao = dao;
    }

    public void service(String name){
        System.out.println(dao.sayHello(name));
    }


}
