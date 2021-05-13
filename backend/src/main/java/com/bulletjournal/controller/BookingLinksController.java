package com.bulletjournal.controller;

import com.bulletjournal.clients.UserClient;
import com.bulletjournal.controller.models.BookingLink;
import com.bulletjournal.controller.models.params.CreateBookingLinkParams;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
public class BookingLinksController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookingLinksController.class);
    public static final String BOOKING_LINKS_ROUTE = "/api/bookingLinks";
    public static final String PUBLIC_BOOKING_LINKS_ROUTE_PREFIX = "/api/public/bookingLinks/";
    public static final String PUBLIC_BOOKING_LINK_ROUTE = PUBLIC_BOOKING_LINKS_ROUTE_PREFIX + "{itemId}";


    @PostMapping(BOOKING_LINKS_ROUTE)
    @ResponseStatus(HttpStatus.CREATED)
    public BookingLink createBookingLink(@Valid @RequestBody CreateBookingLinkParams createBookingLinkParams){

        String uuid = RandomStringUtils.randomAlphabetic(8);
        String username = MDC.get(UserClient.USER_NAME_KEY);

//        ZonedDateTime startTime = ZonedDateTimeHelper.getStartTime(createBookingLinkParams.getStartDate(), null, createBookingLinkParams.getTimezone());
//        ZonedDateTime endTime = ZonedDateTimeHelper.getEndTime(createBookingLinkParams.getEndDate(), null, createBookingLinkParams.getTimezone());

        return getBookingLink(uuid);
    }

    @GetMapping(PUBLIC_BOOKING_LINK_ROUTE)
    public BookingLink getBookingLink(@NotNull @PathVariable String uuid){
        LOGGER.info("Create a new Empty Booking Links");
        return new BookingLink();
    }

}
