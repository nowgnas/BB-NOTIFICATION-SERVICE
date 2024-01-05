package kr.bb.notification.domain.emitter.api;

import bloomingblooms.domain.notification.Role;
import javax.servlet.http.HttpServletResponse;
import kr.bb.notification.domain.emitter.application.SseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Slf4j
@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
public class SSERestController {
  private final SseService sseService;

  // TODO: 화면 테스트용으로 pathvariable 사용
  // TODO: log in event
  @GetMapping(value = "subscribe/manager/{userId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public SseEmitter subscribeManagerLocal(
      @PathVariable Long userId,
      @RequestHeader(value = "Last-Event-ID", required = false, defaultValue = "")
          String lastEventId,
      HttpServletResponse response) {
    response.addHeader("X-Accel-Buffering", "no");
    response.addHeader(HttpHeaders.CONNECTION, "keep-alive");
    response.addHeader(HttpHeaders.CACHE_CONTROL, "no-cache");
    log.info(userId.toString() + "manager subscribe");
    return sseService.subscribe(userId, Role.MANAGER.getRole());
  }

  @GetMapping(value = "subscribe/admin/{userId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public SseEmitter subscribeAdminLocal(
      @PathVariable Long userId,
      @RequestHeader(value = "Last-Event-ID", required = false, defaultValue = "")
          String lastEventId,
      HttpServletResponse response) {
    response.addHeader("X-Accel-Buffering", "no");
    response.addHeader(HttpHeaders.CONNECTION, "keep-alive");
    response.addHeader(HttpHeaders.CACHE_CONTROL, "no-cache");
    return sseService.subscribe(userId, Role.ADMIN.getRole());
  }

  @GetMapping(value = "subscribe/customer/{userId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public SseEmitter subscribeLocal(
      @PathVariable Long userId,
      @RequestHeader(value = "Last-Event-ID", required = false, defaultValue = "")
          String lastEventId,
      HttpServletResponse response) {
    response.addHeader("X-Accel-Buffering", "no");
    response.addHeader(HttpHeaders.CONNECTION, "keep-alive");
    response.addHeader(HttpHeaders.CACHE_CONTROL, "no-cache");
    return sseService.subscribe(userId, Role.CUSTOMER.getRole());
  }

  @GetMapping(value = "subscribe/manager", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public SseEmitter subscribeManager(
      @RequestHeader Long storeId,
      @RequestHeader(value = "Last-Event-ID", required = false, defaultValue = "")
          String lastEventId,
      HttpServletResponse response) {
    response.addHeader("X-Accel-Buffering", "no");
    response.addHeader(HttpHeaders.CONNECTION, "keep-alive");
    response.addHeader(HttpHeaders.CACHE_CONTROL, "no-cache");
    return sseService.subscribe(storeId, Role.MANAGER.getRole());
  }

  @GetMapping(value = "subscribe/admin", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public SseEmitter subscribeAdmin(
      @RequestHeader Long userId,
      @RequestHeader(value = "Last-Event-ID", required = false, defaultValue = "")
          String lastEventId,
      HttpServletResponse response) {
    response.addHeader("X-Accel-Buffering", "no");
    response.addHeader(HttpHeaders.CONNECTION, "keep-alive");
    response.addHeader(HttpHeaders.CACHE_CONTROL, "no-cache");
    return sseService.subscribe(userId, Role.ADMIN.getRole());
  }

  @GetMapping(value = "subscribe/customer", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public SseEmitter subscribe(
      @RequestHeader Long userId,
      @RequestHeader(value = "Last-Event-ID", required = false, defaultValue = "")
          String lastEventId,
      HttpServletResponse response) {
    response.addHeader("X-Accel-Buffering", "no");
    response.addHeader(HttpHeaders.CONNECTION, "keep-alive");
    response.addHeader(HttpHeaders.CACHE_CONTROL, "no-cache");
    return sseService.subscribe(userId, Role.CUSTOMER.getRole());
  }
}
