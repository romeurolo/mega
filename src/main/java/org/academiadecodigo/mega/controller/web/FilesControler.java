package org.academiadecodigo.mega.controller.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/files")
public class FilesControler {

    @RequestMapping(method = RequestMethod.GET, path = "/{str}")
    public String LocationView(@PathVariable String str, Model model) {

        return "src/main/resources/static/mystyle.css";
    }
}
