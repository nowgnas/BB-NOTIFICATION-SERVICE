package kr.bb.notification.domain.notification.facade;

import kr.bb.notification.domain.notification.application.NotificationQueryService;
import kr.bb.notification.domain.notification.entity.NotificationCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationQueryFacadeHandler {
  private final NotificationQueryService notificationQueryService;

  public NotificationCommand.NotificationList getNotifications(Long userId) {
    return notificationQueryService.getNotifications(userId);
  }

  public NotificationCommand.UnreadNotificationCount getUnreadNotification(Long userId) {
    return NotificationCommand.UnreadNotificationCount.getData(
        notificationQueryService.getUnreadNotificationCount(userId));
  }
}