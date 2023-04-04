package com.gaguena.prodcam.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.joda.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.joda.ser.LocalDateTimeSerializer;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class ProductData {
    private String code;
    private Integer codeNumber;
    private String name;
    private String colourCode;
    private String colourName;
    private String sizeCode;
    private String sizeName;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private String createdAt;
}
