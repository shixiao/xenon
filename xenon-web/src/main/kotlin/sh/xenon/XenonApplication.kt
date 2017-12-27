package sh.xenon

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.jooby.Kooby
import org.jooby.json.Jackson
import org.jooby.run
import sh.xenon.resources.TestResource

class XenonApplication : Kooby({
    // Modules
    use(Jackson(jacksonObjectMapper()))

    // Resources
    use(TestResource::class)
}) {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            run(::XenonApplication, *args)
        }
    }
}

