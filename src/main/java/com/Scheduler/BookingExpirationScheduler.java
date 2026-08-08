package com.Scheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.DAO.ExpireBookingDAO;
import com.DAO.Impl.ExpireBookingDaoImpl;

public class BookingExpirationScheduler {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final ExpireBookingDAO expireBookingDAO = new ExpireBookingDaoImpl();

    public void start() {

        scheduler.scheduleAtFixedRate(() -> {

            System.out.println("Checking expired bookings...");
            expireBookingDAO.expireRoomBookings();
            expireBookingDAO.expirePartyHallBookings();
            expireBookingDAO.expireMeetingHallBookings();

        }, 0, 1, TimeUnit.MINUTES);
    }
}
