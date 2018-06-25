package com.qunar.fresh2017.model;

public class ContentModel {

    private String title;
    private Integer number;
    private Integer chNumber;
    private Integer enNumber;
    private Integer puncNumber;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getChNumber() {
        return chNumber;
    }

    public void setChNumber(Integer chNumber) {
        this.chNumber = chNumber;
    }

    public Integer getEnNumber() {
        return enNumber;
    }

    public void setEnNumber(Integer enNumber) {
        this.enNumber = enNumber;
    }

    public Integer getPuncNumber() {
        return puncNumber;
    }

    public void setPuncNumber(Integer puncNumber) {
        this.puncNumber = puncNumber;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ContentModel{");
        sb.append("title='").append(title).append('\'');
        sb.append(", number=").append(number);
        sb.append(", cnNumber=").append(chNumber);
        sb.append(", enNumber=").append(enNumber);
        sb.append(", puncNumber=").append(puncNumber);
        sb.append('}');
        return sb.toString();
    }
}
