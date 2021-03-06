package edu.nju.ticketbooking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", updatable = false)
    private int userId;

    @Column(name = "uemail")
    private String email;

    @Column(name = "uname")
    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "upassword")
    private String password;

    @Column(name = "gender")
    private String gender;

    @Column(name = "ulevel")
    private int level = 1;

    @Column(name = "uscore")
    private double score;   // 用于兑换优惠券

    @JsonIgnore
    @Column(name = "is_deleted")
    private boolean isDeleted;

    @Column(name = "balance")
    private double balance = 2000;  // 默认值

    @JsonIgnore
    @Column(name = "is_activated")
    private boolean isActivated;

    @Column(name = "accu_score")
    private double accumulatedScore;  // 累计积分，用于用户升级，类似于经验值

    public User() {

    }

    public User(String email, String name, String password, String gender, int level, double score, boolean isDeleted, double balance, boolean isActivated) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.level = level;
        this.score = score;
        this.isDeleted = isDeleted;
        this.balance = balance;
        this.isActivated = isActivated;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int id) {
        this.userId = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("USER"));
    }

    public String getPassword() {
        return password;
    }

    /**
     * 指的是UsernamePasswordAuthentication中的"username"，即用于登陆的key
     */
    @JsonIgnore
    @Override
    public String getUsername() {
        return this.email;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    // 以get命名，防止jackson序列化时漏掉is
    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean getIsActivated() {
        return isActivated;
    }

    public void setActivated(boolean activated) {
        isActivated = activated;
    }

    public double getAccumulatedScore() {
        return accumulatedScore;
    }

    public void setAccumulatedScore(double levelScore) {
        this.accumulatedScore = levelScore;
    }

}
