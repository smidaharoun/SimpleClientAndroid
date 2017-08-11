package smida.haroun.samplemvp.model;

import java.util.List;

/**
 * Created by Haroun Smida on 29/07/17.
 * smida.haroun@gmail.com
 */

public class Project extends BaseModel {

    private Integer projectId;
    private String title;
    private String description;
    private String duration;
    private Enterprise enterprise;
    private List<Challenge> challenges;
    private List<Skill> skills;

    public Integer getProjectId() {
        return projectId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDuration() {
        return duration;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public List<Challenge> getChallenges() {
        return challenges;
    }

    public List<Skill> getSkills() {
        return skills;
    }
}
