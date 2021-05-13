package com.bulletjournal.controller.models;

import com.google.gson.annotations.Expose;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import java.util.List;
import java.util.Objects;
import java.time.ZonedDateTime;

public class BookingLink {

    private String uuid;

    @NotNull
    protected String owner;

    private String startDate;

    private String endDate;

    private List<Invitee> invitees;

    private String timezone;

    private int slotSpan;

    private boolean includeTaskWithoutDuration;

    private boolean expireOnBooking;

//    private List<BookingSlot> slots;

    private List<Integer> slotsON;
    private List<Integer> slotsOff;

    private int bufferInMin;

    public BookingLink(){

    }

    public BookingLink(String uuid,
                       @NotNull String owner,
                       String startDate,
                       String endDate, int bufferInMin, boolean expireOnBooking, boolean includeTaskWithoutDuration){
        this.uuid = uuid;
        this.owner = owner;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bufferInMin = bufferInMin;
        this.expireOnBooking = expireOnBooking;
        this.includeTaskWithoutDuration = includeTaskWithoutDuration;
    }


    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getEndTime() {
        return endDate;
    }

    public void setEndTime(String endDate) {
        this.endDate = endDate;
    }

    public String getStartTime() {
        return startDate;
    }

    public void setStartTime(String startDate) {
        this.startDate = startDate;
    }

    public List<Invitee> getInvitees() {
        return invitees;
    }

    public void setInvitees(List<Invitee> invitees) {
        this.invitees = invitees;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

//    public List<BookingSlot> getSlots() {
//        return slots;
//    }
//
//    public void setSlots(List<BookingSlot> slots) {
//        this.slots = slots;
//    }


    public List<Integer> getSlotsOff() {
        return slotsOff;
    }

    public void setSlotsOff(List<Integer> slotsOff) {
        this.slotsOff = slotsOff;
    }

    public List<Integer> getSlotsON() {
        return slotsON;
    }

    public void setSlotsON(List<Integer> slotsON) {
        this.slotsON = slotsON;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getBufferInMin() {
        return bufferInMin;
    }

    public void setBufferInMin(int bufferInMin) {
        this.bufferInMin = bufferInMin;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof BookingLink)) return false;
        BookingLink bookingLink = (BookingLink)o;
        return Objects.equals(getSlotsOff(), bookingLink.getSlotsOff()) && Objects.equals(getSlotsON(), bookingLink.getSlotsON()) &&
                java.util.Objects.equals(getUuid(), bookingLink.getUuid());
    }
}
