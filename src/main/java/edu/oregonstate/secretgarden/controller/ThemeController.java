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
@CrossOrigin(origins = "*")
public class ThemeController {

    private final ThemeService themeService;

    @Autowired
    public ThemeController(ThemeService themeService) {
        this.themeService = themeService;
    }

    @RequestMapping("/getAll")
    public List<Theme> getAllThemes() {
        try {
            return themeService.getAllThemes();
        } catch (Exception e) {
            return null;
        }
    }

    @RequestMapping("/create")
    public boolean createTheme(String themeName) {
        Theme theme = new Theme();
        theme.setThemeName(themeName);
        try {
            return themeService.insert(theme) == 1;
        } catch (Exception e) {
            return false;
        }
    }

    @RequestMapping("/getThemeById")
    public Theme getThemeById(int themeId){
        return themeService.selectByPrimaryKey(themeId);

    }
}
