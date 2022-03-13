package com.havells.platform.request;

public class ApplicationKey {

    private String deviceId;
    private String applicationKey;

    public ApplicationKey() {
    }

    public ApplicationKey(String deviceId, String applicationKey) {
        this.deviceId = deviceId;
        this.applicationKey = applicationKey;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getApplicationKey() {
        return applicationKey;
    }

    public void setApplicationKey(String applicationKey) {
        this.applicationKey = applicationKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApplicationKey that = (ApplicationKey) o;

        if (!deviceId.equals(that.deviceId)) return false;
        return applicationKey.equals(that.applicationKey);
    }

    @Override
    public int hashCode() {
        int result = deviceId.hashCode();
        result = 31 * result + applicationKey.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ApplicationKey{" +
                "deviceId='" + deviceId + '\'' +
                ", applicationKey='" + applicationKey + '\'' +
                '}';
    }
}
