package smida.haroun.samplemvp.model;

/**
 * Created by Haroun Smida on 29/07/17.
 * smida.haroun@gmail.com
 */

public class Enterprise extends BaseModel {

    private Integer enterpriseId;
    private String enterpriseName;
    private String logo;

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public String getLogo() {
        return logo;
    }
}
