package com.example.demo.model.DTO;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

@Data
public class ResponseDto {

    private StringBuilder answer;
}
