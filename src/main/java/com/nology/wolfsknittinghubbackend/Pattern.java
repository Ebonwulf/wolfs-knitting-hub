package com.nology.wolfsknittinghubbackend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pattern {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patternId;
    private String patternName;
    private String patternType;
    private String patternDifficulty;
    private String woolType;
    private String needleSize;
    private String patternDescription;
    private String pattern;

    public Pattern() {

    }

    public int getPatternId() {
        return patternId;
    }

    public void setPatternId(int patternId) {
        this.patternId = patternId;
    }

    public String getPatternName() {
        return patternName;
    }

    public void setPatternName(String patternName) {
        this.patternName = patternName;
    }

    public String getPatternType() {
        return patternType;
    }

    public void setPatternType(String patternType) {
        this.patternType = patternType;
    }

    public String getPatternDifficulty() {
        return patternDifficulty;
    }

    public void setPatternDifficulty(String patternDifficulty) {
        this.patternDifficulty = patternDifficulty;
    }

    public String getWoolType() {
        return woolType;
    }

    public void setWoolType(String woolType) {
        this.woolType = woolType;
    }

    public String getNeedleSize() {
        return needleSize;
    }

    public void setNeedleSize(String needleSize) {
        this.needleSize = needleSize;
    }

    public String getPatternDescription() {
        return patternDescription;
    }

    public void setPatternDescription(String patternDescription) {
        this.patternDescription = patternDescription;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
