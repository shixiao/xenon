package xenon

import io.vertx.core.Vertx
import io.vertx.ext.web.Router


object HelloWorld {

    @JvmStatic
    fun main(args: Array<String>) {
        val vertx = Vertx.vertx()
        val server = vertx.createHttpServer()
        val port = 8080
        val router = Router.router(vertx)
        router.get("/").handler { it.response().end("Hello world!") }

        // Create an HTTP server which simply returns "Hello World!" to each request.
        server.requestHandler { router.accept(it) }.listen(port) {
            if (it.succeeded()) {
                println("\nServer listening at $port...")
            } else {
                println(it.cause())
            }
        }
    }
}