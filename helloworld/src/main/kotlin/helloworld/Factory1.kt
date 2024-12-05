package com.helloworld

import io.micronaut.context.annotation.Factory
import io.micronaut.core.annotation.Order
import java.time.Duration
import jakarta.inject.Singleton


class LowRateLimit(duration: Duration, limit: Int) {}

class HighRateLimit(duration: Duration, limit: Int) {}

@Factory
class RateLimitsFactory {

    @Singleton
    @Order(26)
    fun rateLimit2(): LowRateLimit {
        return LowRateLimit(Duration.ofMinutes(50), 500)
    }

    @Singleton
    @Order(10)
    fun rateLimit1(): HighRateLimit {
        return HighRateLimit(Duration.ofMinutes(50), 1000)
    }
}