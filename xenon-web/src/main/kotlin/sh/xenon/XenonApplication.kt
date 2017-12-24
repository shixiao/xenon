package sh.xenon

import co.paralleluniverse.fibers.dropwizard.FiberApplication
import io.dropwizard.setup.Environment

class XenonApplication : FiberApplication<XenonConfig>() {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            XenonApplication().run(*args)
        }
    }

    override fun getName(): String {
        return "Xenon"
    }

    override fun fiberRun(config: XenonConfig, environment: Environment) {
    }
}

