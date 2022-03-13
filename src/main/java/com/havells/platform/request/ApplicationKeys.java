package com.havells.platform.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class ApplicationKeys {

    private List<ApplicationKey> applicationKeyList;

    public ApplicationKeys() {
    }

    public ApplicationKeys(List<ApplicationKey> applicationKeyList) {
        this.applicationKeyList = applicationKeyList;
    }

    public List<ApplicationKey> getApplicationKeyList() {
        return applicationKeyList;
    }

    public void setApplicationKeyList(List<ApplicationKey> applicationKeyList) {
        this.applicationKeyList = applicationKeyList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApplicationKeys that = (ApplicationKeys) o;

        return applicationKeyList.equals(that.applicationKeyList);
    }

    @Override
    public int hashCode() {
        return applicationKeyList.hashCode();
    }

    @Override
    public String toString() {
        return "ApplicationKeys{" +
                "applicationKeyList=" + applicationKeyList +
                '}';
    }
}
