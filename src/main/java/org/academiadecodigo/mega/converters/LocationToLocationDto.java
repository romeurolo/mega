package org.academiadecodigo.mega.converters;

import org.academiadecodigo.mega.command.LocationDto;
import org.academiadecodigo.mega.persistence.model.Location;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LocationToLocationDto implements Converter<Location, LocationDto> {
    @Override
    public LocationDto convert(Location location) {
        LocationDto locationDto = new LocationDto();

        locationDto.setId(location.getId());
        locationDto.setName(location.getName());
        locationDto.setCity(location.getCity());
        locationDto.setPostalCode(location.getPostalCode());
        locationDto.setAddress(location.getAddress());
        locationDto.setPhone(location.getPhone());
        locationDto.setStamps(location.getStamps());
        locationDto.setLat(location.getLat());
        locationDto.setLongi(location.getLongi());

        return locationDto;
    }

}
