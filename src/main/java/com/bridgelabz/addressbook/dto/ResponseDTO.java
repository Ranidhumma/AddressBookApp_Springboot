package com.bridgelabz.addressbook.dto;
import lombok.Data;
public @Data class ResponseDTO {
    public String message;
    public Object data;

    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }

}
