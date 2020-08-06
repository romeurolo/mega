import org.academiadecodigo.mega.persistence.dao.jpa.LocationJpaDao;
import org.academiadecodigo.mega.persistence.model.Location;

public class M {
    public static void main(String[] args) {
        Location location = new Location();
        LocationJpaDao locationJpaDao = new LocationJpaDao();
        locationJpaDao.saveOrUpdate(location);
        System.out.println(locationJpaDao.findById(1));


    }
}
