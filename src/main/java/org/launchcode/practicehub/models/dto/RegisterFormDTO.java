package org.launchcode.practicehub.models.dto;

public class RegisterFormDTO extends LoginFormDTO {

    private String verifyPassword;

    private String skaterName;

    public String getSkaterName() {
        return skaterName;
    }

    public void setSkaterName(String skaterName) {
        this.skaterName = skaterName;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }
}
