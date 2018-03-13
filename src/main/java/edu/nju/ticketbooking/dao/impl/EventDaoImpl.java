package edu.nju.ticketbooking.dao.impl;

import edu.nju.ticketbooking.constant.EventFilterType;
import edu.nju.ticketbooking.constant.EventType;
import edu.nju.ticketbooking.dao.EventDao;
import edu.nju.ticketbooking.model.Event;
import edu.nju.ticketbooking.model.Page;
import edu.nju.ticketbooking.util.HibernateUtil;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class EventDaoImpl implements EventDao {

    @Override
    public Event addEvent(Event newEvent) {
        return (Event) HibernateUtil.addNew(newEvent, Event.class);
    }

    @Override
    public Event modifyEvent(Event modifiedEvent) {
        return (Event) HibernateUtil.saveModified(modifiedEvent);
    }

    @Override
    public Event getEvent(int eventId) {
        return (Event) HibernateUtil.getById(eventId, Event.class);
    }

    @Override
    public List<Event> getEventList(EventFilterType filter, Object condition, int pageSize, int pageNum, Timestamp fromTime, Timestamp toTime) {
        String queryTemplate = "FROM Event WHERE %s = ? AND hostTime >= ? AND hostTime <= ? ORDER BY hostTime ASC";
        String mainCondition = null;
        switch (filter) {
            case TYPE:
                mainCondition = "eventType";
                condition = EventType.valueOf((String) condition);    // 手动cast，避免hibernate报错
                break;
            case VENUE:
                mainCondition = "venueId";
                break;
        }
        String query = String.format(queryTemplate, mainCondition);
        return HibernateUtil.getPageByQuery(query, new Object[]{condition, fromTime, toTime}, new Page(pageSize, pageNum));
    }

}
