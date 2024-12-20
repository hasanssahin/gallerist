package com.hasansahin.gallerist.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "refresh_token")
public class RefreshToken extends BaseEntity{
    private String refreshToken;
    private Date expiredDate;
    @ManyToOne
    private User user;

    public RefreshToken() {
    }

    public RefreshToken(String refreshToken, Date expiredDate, User user) {
        this.refreshToken = refreshToken;
        this.expiredDate = expiredDate;
        this.user = user;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
