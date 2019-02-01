package edu.oregonstate.secretgarden.model;

public class Theme extends BaseModelObject {
    private Integer themeId;

    private String themeName;

    private Integer postNum = 0;

    public Integer getThemeId() {
        return themeId;
    }

    public void setThemeId(Integer themeId) {
        this.themeId = themeId;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName == null ? null : themeName.trim();
    }


    public Integer getPostNum() {
        return postNum;
    }

    public void setPostNum(Integer postNum) {
        this.postNum = postNum;
    }
}