package kr.bb.notification.domain.notification.infrastructure.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OutOfStockNotification {
    private Long storeId;
}