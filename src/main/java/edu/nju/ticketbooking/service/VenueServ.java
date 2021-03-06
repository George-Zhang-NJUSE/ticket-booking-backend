package edu.nju.ticketbooking.service;

import edu.nju.ticketbooking.model.Venue;

import java.util.List;

public interface VenueServ {

    Venue applyForNewVenue(Venue newVenue);

    void setVenueApplicationApproved(int venueId, boolean isApproved);

    Venue getVenue(int venueId);

    /**
     * 不提供给客户端使用，客户端通过VenueChange的新增和批准来修改信息
     */
    Venue modifyVenue(Venue modifiedVenue);

    List<Venue> getApplyingVenueList();
}
