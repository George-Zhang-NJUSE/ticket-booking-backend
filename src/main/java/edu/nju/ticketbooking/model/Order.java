package edu.nju.ticketbooking.model;

import edu.nju.ticketbooking.constant.OrderState;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "oid", updatable = false)
    private int id;

    @Column(name = "eid")
    private int eventId;

    @Column(name = "uid")
    private int userId;

    @Column(name = "state")
    @Enumerated(value = EnumType.STRING)
    private OrderState state = OrderState.UNPAID;

    @Column(name = "oprice")
    private double totalPrice;

    @Column(name = "cid")
    private int couponId;

    @Column(name = "create_time")
    private Timestamp createTime;

    @Column(name = "is_canceled")
    private boolean isCanceled = false;

    @OneToMany
    private List<Ticket> tickets = new ArrayList<>();

    public Order() {

    }

    public Order(int eventId, int userId, OrderState state, double totalPrice, int couponId, Timestamp createTime) {
        this.eventId = eventId;
        this.userId = userId;
        this.state = state;
        this.totalPrice = totalPrice;
        this.couponId = couponId;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public boolean getIsCanceled() {
        return isCanceled;
    }

    public void setCanceled(boolean canceled) {
        isCanceled = canceled;
    }
}