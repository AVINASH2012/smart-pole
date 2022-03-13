package com.havells.platform.model;

import com.havells.platform.utils.AbstractTimestampEntity;

import javax.persistence.*;

@Entity
@Table(name = "APPLICATIONKEY")
public class ApplicationKeyModel extends AbstractTimestampEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    // TODO Make composite keys
    private String applicationKey;

    private String deviceId;

    public ApplicationKeyModel() {
    }

    public ApplicationKeyModel(long id, String applicationKey, String deviceId) {
        this.id = id;
        this.applicationKey = applicationKey;
        this.deviceId = deviceId;
    }

    @Override
    public String toString() {
        return "ApplicationKey{" +
                "id=" + id +
                ", applicationKey='" + applicationKey + '\'' +
                ", deviceId='" + deviceId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApplicationKeyModel that = (ApplicationKeyModel) o;

        if (id != that.id) return false;
        if (!applicationKey.equals(that.applicationKey)) return false;
        return deviceId.equals(that.deviceId);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + applicationKey.hashCode();
        result = 31 * result + deviceId.hashCode();
        return result;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getApplicationKey() {
        return applicationKey;
    }

    public void setApplicationKey(String applicationKey) {
        this.applicationKey = applicationKey;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
