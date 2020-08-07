package org.academiadecodigo.mega.controller.web;

import org.academiadecodigo.mega.command.LocationDto;
import org.academiadecodigo.mega.command.ReviewDto;
import org.academiadecodigo.mega.converters.LocationDtoToLocation;
import org.academiadecodigo.mega.converters.LocationToLocationDto;
import org.academiadecodigo.mega.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class MainController {

    private LocationService locationService;
    private LocationToLocationDto locationToLocationDto;
    private LocationDtoToLocation locationDtoToLocation;
    private LocationDto locationDto;

    @Autowired
    public void setLocationService(LocationService locationService) {
        this.locationService = locationService;
    }

    @Autowired
    public void setLocationToLocationDto(LocationToLocationDto locationToLocationDto) {
        this.locationToLocationDto = locationToLocationDto;
    }

    @Autowired
    public void setLocationDtoToLocation(LocationDtoToLocation locationDtoToLocation) {
        this.locationDtoToLocation = locationDtoToLocation;
    }

    @Autowired
    public void setLocationDto(LocationDto locationDto) {
        this.locationDto = locationDto;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public String mainView() {

        return "/index";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/add")
    public String addLocationView(Model model) {
            model.addAttribute("review", new ReviewDto());

        return "/add";
    }


    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public String LocationView(@PathVariable Integer id, Model model) {
        model.addAttribute("id",id);
        return "/location";
    }
}
