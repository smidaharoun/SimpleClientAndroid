package smida.haroun.samplemvp.model;

import java.util.Date;

/**
 * Created by Haroun Smida on 29/07/17.
 * smida.haroun@gmail.com
 */

public class Challenge extends BaseModel {

    private Integer challengeId;
    private String description;
    private String challengeDocument;
    private Date startDate;
    private Date endDate;
    private Integer winnerNumber;

    public Integer getChallengeId() {
        return challengeId;
    }

    public String getDescription() {
        return description;
    }

    public String getChallengeDocument() {
        return challengeDocument;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Integer getWinnerNumber() {
        return winnerNumber;
    }
}
