package com.volleygson;

import com.google.gson.annotations.Expose;

public class Phone {

    @Expose
    private String mobile;
    @Expose
    private String home;
    @Expose
    private String office;

    /**
     *
     * @return
     * The mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     *
     * @param mobile
     * The mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     *
     * @return
     * The home
     */
    public String getHome() {
        return home;
    }

    /**
     *
     * @param home
     * The home
     */
    public void setHome(String home) {
        this.home = home;
    }

    /**
     *
     * @return
     * The office
     */
    public String getOffice() {
        return office;
    }

    /**
     *
     * @param office
     * The office
     */
    public void setOffice(String office) {
        this.office = office;
    }

}