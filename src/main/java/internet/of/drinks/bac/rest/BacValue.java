package internet.of.drinks.bac.rest;

import java.util.Date;

/**
 * Created by Martin on 05.11.2016.
 */

public class BacValue {
    private String userid;
    private Double baclevel;
    private Date date;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Double getBaclevel() {
        return baclevel;
    }

    public void setBaclevel(Double baclevel) {
        this.baclevel = baclevel;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "BacValue{" +
                "userid='" + userid + '\'' +
                ", baclevel=" + baclevel +
                ", date=" + date +
                '}';
    }
}
