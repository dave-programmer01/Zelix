package com.heraim.zelix;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 20)
    private String username;

    private String displayName;

    @Column(unique = true, nullable = false)
    private String email;

    private String phoneNumber;

    private String hashedPassword;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String bio;

    private boolean verified;

    private String profilePictureUrl;

    private String coverPictureUrl;

    private int soldAccounts;

    private Double rating;

    private int followers;

    private int following;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private Status status;

    public User() {}

    public User(String username, String displayName, String email,
                String phoneNumber, String hashedPassword, String bio,
                boolean verified, String profilePictureUrl,
                String coverPictureUrl, int soldAccounts,
                Double rating, int followers, int following) {

        this.username = username;
        this.displayName = displayName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hashedPassword = hashedPassword;
        this.bio = bio;
        this.verified = verified;
        this.profilePictureUrl = profilePictureUrl;
        this.coverPictureUrl = coverPictureUrl;
        this.soldAccounts = soldAccounts;
        this.rating = rating;
        this.followers = followers;
        this.following = following;
    }

    // ===== Getters & Setters =====

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getHashedPassword() { return hashedPassword; }
    public void setHashedPassword(String hashedPassword) { this.hashedPassword = hashedPassword; }

    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }

    public boolean isVerified() { return verified; }
    public void setVerified(boolean verified) { this.verified = verified; }

    public String getProfilePictureUrl() { return profilePictureUrl; }
    public void setProfilePictureUrl(String profilePictureUrl) { this.profilePictureUrl = profilePictureUrl; }

    public String getCoverPictureUrl() { return coverPictureUrl; }
    public void setCoverPictureUrl(String coverPictureUrl) { this.coverPictureUrl = coverPictureUrl; }

    public int getSoldAccounts() { return soldAccounts; }
    public void setSoldAccounts(int soldAccounts) { this.soldAccounts = soldAccounts; }

    public Double getRating() { return rating; }
    public void setRating(Double rating) { this.rating = rating; }

    public int getFollowers() { return followers; }
    public void setFollowers(int followers) { this.followers = followers; }

    public int getFollowing() { return following; }
    public void setFollowing(int following) { this.following = following; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public enum Role {
        USER,
        ADMIN,
        VENDOR,
        SUPERADMIN
    }

    public enum Status {
        ACTIVE,
        INACTIVE,
        DELETED
    }

    @PrePersist
    protected void onCreate() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }
}
