package com.example.hw54.dto;

import lombok.Data;

@Data
public class ResponseDTO {

    private String subsId;
    private String responseMessage;

    public ResponseDTO(String subsId, String responseMessage) {
        this.subsId = subsId;
        this.responseMessage = responseMessage;
    }

    public ResponseDTO() {
    }

    public String getSubsId() {
        return subsId;
    }

    public void setSubsId(String subsId) {
        this.subsId = subsId;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
