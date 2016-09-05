package no.dnb.toolbartest.model;

/**
 * Created by 778363aypp on 9/1/2016.
 */
public class NavDrawerItem {
    private boolean showNotify;
    private String title;

    public NavDrawerItem() {
    }

    public boolean isShowNotify() {
        return showNotify;
    }

    public void setShowNotify(boolean showNotify) {
        this.showNotify = showNotify;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public NavDrawerItem(boolean showNotify, String title) {
        this.showNotify = showNotify;
        this.title = title;
    }
}
