package com.events.center.events_center.dto.ResponseDTO;

import com.events.center.events_center.dto.beans.EventBean;
import com.events.center.events_center.entity.Vendor;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VendorResponseDTO {
    private Vendor vendor;
    private String code;
    private String message;
}
