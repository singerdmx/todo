package com.bulletjournal.controller.models.params;

import com.bulletjournal.controller.models.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

public class CreateBookingLinkParams {

    private String startDate;

    private String endDate;

    private String timezone;

    private int slotSpan;

    private int bufferInMin;

    private boolean includeTaskWithoutDuration;

    private boolean expireOnBooking;


    public CreateBookingLinkParams() {

    }

    public CreateBookingLinkParams(@NotBlank String startDate, @NotBlank String endDate, boolean includeTaskWithoutDuration, boolean expireOnBooking) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.includeTaskWithoutDuration = includeTaskWithoutDuration;
        this.expireOnBooking = expireOnBooking;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getBufferInMin() {
        return bufferInMin;
    }

    public void setBufferInMin(int bufferInMin) {
        this.bufferInMin = bufferInMin;
    }

    public int getSlotSpan() {
        return slotSpan;
    }

    public void setSlotSpan(int slotSpan) {
        this.slotSpan = slotSpan;
    }


    public void setExpireOnBooking(boolean expireOnBooking) {
        this.expireOnBooking = expireOnBooking;
    }

    public boolean getExpireOnBooking(){
        return expireOnBooking;
    }

    public boolean getIncludeTaskWithoutDuration(){
        return includeTaskWithoutDuration;
    }

    public void setIncludeTaskWithoutDuration(boolean includeTaskWithoutDuration) {
        this.includeTaskWithoutDuration = includeTaskWithoutDuration;
    }
}
