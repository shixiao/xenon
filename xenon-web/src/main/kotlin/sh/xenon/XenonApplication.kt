package sh.xenon

import io.dropwizard.Application
import io.dropwizard.setup.Environment

class XenonApplication : Application<XenonConfig>() {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            XenonApplication().run(*args)
        }
    }

    override fun getName(): String {
        return "Xenon"
    }

    override fun run(config: XenonConfig, environment: Environment) {
        TODO("not implemented")
    }
}

