package com.joker.model;

/**
 * @author Joker
 * @since 2020/08/03
 */
public class Destination {


    /**
     * isFragment : true
     * asStarter : false
     * needLogin : false
     * pageUrl : main/tabs/dash
     * className : com.joker.ui.dashboard.DashboardFragment
     * id : 1012777560
     */

    private boolean isFragment;
    private boolean asStarter;
    private boolean needLogin;
    private String pageUrl;
    private String className;
    private int id;

    public boolean isFragment() {
        return isFragment;
    }

    public void setIsFragment(boolean isFragment) {
        this.isFragment = isFragment;
    }

    public boolean isAsStarter() {
        return asStarter;
    }

    public void setAsStarter(boolean asStarter) {
        this.asStarter = asStarter;
    }

    public boolean isNeedLogin() {
        return needLogin;
    }

    public void setNeedLogin(boolean needLogin) {
        this.needLogin = needLogin;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
