package edu.oregonstate.secretgarden.controller;

import edu.oregonstate.secretgarden.model.Theme;
import edu.oregonstate.secretgarden.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Chendi Zhang
 * @date: 2019-01-30
 * @description:
 **/

@RestController
@RequestMapping("/theme")
@CrossOrigin(origins = "http://localhost:4200")
public class ThemeController {

    private final ThemeService themeService;

    @Autowired
    public ThemeController(ThemeService themeService) {
        this.themeService = themeService;
    }

    @RequestMapping
    public List<Theme> getAllTheme() {
        try {
            return themeService.getAllThemes();
        } catch (Exception e) {
            return null;
        }
    }
}
