package kr.bb.notification.domain.notification.entity;

import bloomingblooms.domain.notification.QuestionRegisterNotification;
import bloomingblooms.domain.resale.ResaleNotificationList;
import java.util.List;
import java.util.stream.Collectors;
import kr.bb.notification.domain.notification.infrastructure.dto.NewOrderNotification;

public class MemberNotificationCommand {

  public static List<MemberNotification> toEntityList(ResaleNotificationList whoToNotify) {
    return whoToNotify.getResaleNotificationData().stream()
        .map(item -> MemberNotification.builder().userId(item.getUserId()).build())
        .collect(Collectors.toList());
  }

  public static MemberNotification toEntity(QuestionRegisterNotification whoToNotify) {
    return MemberNotification.builder().userId(whoToNotify.getUserId()).build();
  }

  public static MemberNotification toEntityForStoreManager(NewOrderNotification whoToNotify) {
    return MemberNotification.builder().userId(whoToNotify.getStoreId()).build();
  }
}