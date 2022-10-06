package hello.advanced.trace;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class TraceStatus {
	
	private final TraceId traceId;
	private final Long startTimeMs;
	private final String message;

}
