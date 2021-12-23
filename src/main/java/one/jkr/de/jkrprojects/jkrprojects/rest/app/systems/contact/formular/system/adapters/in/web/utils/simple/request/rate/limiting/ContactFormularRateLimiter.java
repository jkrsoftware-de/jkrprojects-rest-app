package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.contact.formular.system.adapters.in.web.utils.simple.request.rate.limiting;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
@RequiredArgsConstructor
public class ContactFormularRateLimiter {

    private final static int rateLimit = 0;

    private final AtomicInteger requestCounter = new AtomicInteger(0);

    public boolean isLimitReached() {
        return requestCounter.incrementAndGet() > rateLimit;
    }

    @Scheduled(cron = "0 0 0 * * ?")
    private void clearRequestCounter() {
        requestCounter.set(0);
    }

}
