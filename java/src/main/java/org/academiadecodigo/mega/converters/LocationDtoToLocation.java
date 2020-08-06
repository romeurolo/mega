package org.academiadecodigo.mega.converters;

import org.academiadecodigo.mega.command.LocationDto;
import org.academiadecodigo.mega.persistence.model.Location;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LocationDtoToLocation implements Converter<LocationDto,Location> {
    @Override
    public Location convert(LocationDto locationDto) {
        Location location = new Location();

        location.setId(locationDto.getId());
        location.setName(locationDto.getName());
        location.setCity(locationDto.getCity());
        location.setPostalCode(locationDto.getPostalCode());
        location.setAddress(locationDto.getAddress());
        location.setStamps(locationDto.getStamps());
        location.setPhone(locationDto.getPhone());
        location.setLat(locationDto.getLat());
        location.setLongi(locationDto.getLongi());

        return location;
    }
}
