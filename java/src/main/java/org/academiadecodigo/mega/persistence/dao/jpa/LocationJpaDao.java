package org.academiadecodigo.mega.persistence.dao.jpa;

import org.springframework.stereotype.Repository;
import org.academiadecodigo.mega.persistence.dao.LocationDao;
import org.academiadecodigo.mega.persistence.model.Location;

@Repository
public class LocationJpaDao extends GenericJpaDao<Location> implements LocationDao {

    public LocationJpaDao() {
        super(Location.class);
    }
}
