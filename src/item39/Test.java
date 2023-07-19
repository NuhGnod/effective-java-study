package item39;

import java.lang.annotation.*;

// 코드 39-1 마커(marker) 애너테이션 타입 선언 (238쪽)
import java.lang.annotation.*;

/**
 * 테스트 메서드임을 선언하는 애너테이션이다.
 * 매개변수 없는 정적 메서드 전용이다.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Test{

}