package edu.oregonstate.secretgarden.model;

public class Theme extends BaseModelObject {
    private Integer themeid;

    private String themename;

    private Integer postnum = 0;

    public Integer getThemeid() {
        return themeid;
    }

    public void setThemeid(Integer themeid) {
        this.themeid = themeid;
    }

    public String getThemename() {
        return themename;
    }

    public void setThemename(String themename) {
        this.themename = themename == null ? null : themename.trim();
    }


    public Integer getPostnum() {
        return postnum;
    }

    public void setPostnum(Integer postnum) {
        this.postnum = postnum;
    }
}