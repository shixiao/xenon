package sh.xenon

import com.codahale.metrics.ConsoleReporter
import com.codahale.metrics.jvm.GarbageCollectorMetricSet
import com.codahale.metrics.jvm.MemoryUsageGaugeSet
import com.codahale.metrics.jvm.ThreadStatesGaugeSet
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.jooby.Kooby
import org.jooby.json.Jackson
import org.jooby.metrics.Metrics
import org.jooby.run
import org.jooby.scanner.Scanner
import java.util.concurrent.TimeUnit

class XenonApplication : Kooby({
    // Modules
    use(Jackson(jacksonObjectMapper()))
    use(Metrics()
            .metric("memory", MemoryUsageGaugeSet())
            .metric("threads", ThreadStatesGaugeSet())
            .metric("gc", GarbageCollectorMetricSet())
            .request()
            .reporter({ registry ->
                val reporter = ConsoleReporter.forRegistry(registry).build()
                reporter.start(1, TimeUnit.MINUTES)
                reporter
            })
    )
    use(Scanner())
}) {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            run(::XenonApplication, *args)
        }
    }
}

