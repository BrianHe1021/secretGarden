package edu.oregonstate.secretgarden.service;

import edu.oregonstate.secretgarden.model.Theme;

import java.util.List;

public interface ThemeService extends BaseService<Theme, Integer> {

    List<Theme> getAllThemes();
}
