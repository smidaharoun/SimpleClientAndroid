package smida.haroun.samplemvp.model;

/**
 * Created by Haroun Smida on 29/07/17.
 * smida.haroun@gmail.com
 */

public class User extends BaseModel {

    private Integer userId;
    private String usename;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private Integer type;
    private String address;
    private Country country;
    private Region region;
    private Integer coins;

    public Integer getUserId() {
        return userId;
    }

    public String getUsename() {
        return usename;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public Integer getType() {
        return type;
    }

    public String getAddress() {
        return address;
    }

    public Country getCountry() {
        return country;
    }

    public Region getRegion() {
        return region;
    }

    public Integer getCoins() {
        return coins;
    }
}
