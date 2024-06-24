package az.ministry.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PassRequest {
    Boolean aBoolean;
    Long passRequestId;
    Long visitorId;
    Long officerId;
    LocalDateTime entryTime;
    LocalDateTime exitTime;
}
