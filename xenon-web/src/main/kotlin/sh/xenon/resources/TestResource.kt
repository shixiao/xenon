package sh.xenon.resources

import kotlinx.coroutines.experimental.delay
import org.jooby.mvc.GET
import org.jooby.mvc.Path
import org.jooby.mvc.Produces
import sh.xenon.util.onCoroutine
import java.util.concurrent.TimeUnit

@Path("/test")
@Produces("application/json")
class TestResource {
    data class TestData(val content: String)

    @GET
    fun get() = onCoroutine {
        delay(40, TimeUnit.MILLISECONDS)
        TestData(content = "Hello World")
    }

    @Path("/test/2")
    @GET
    fun get2() = "hello"
}
