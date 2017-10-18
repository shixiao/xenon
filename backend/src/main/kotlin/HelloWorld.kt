package xenon

import dagger.Component
import io.vertx.core.Vertx
import io.vertx.ext.auth.oauth2.OAuth2Auth
import io.vertx.ext.auth.oauth2.OAuth2ClientOptions
import io.vertx.ext.auth.oauth2.OAuth2FlowType
import io.vertx.ext.auth.oauth2.providers.GithubAuth
import io.vertx.ext.web.Router
import io.vertx.kotlin.core.json.json
import io.vertx.kotlin.core.json.obj
import io.vertx.kotlin.ext.auth.oauth2.OAuth2ClientOptions
import org.apache.logging.log4j.LogManager
import xenon.toy.ToyMaker
import xenon.toy.ToyModule
import javax.inject.Singleton


object HelloWorld {
    private val logger = LogManager.getLogger("HelloWorld")

    @Singleton
    @Component(modules = arrayOf(ToyModule::class))
    interface ToyComponent {
        fun maker(): ToyMaker
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val toyMaker = DaggerHelloWorld_ToyComponent.builder().build().maker()
        toyMaker.make()
        logger.error("Testing log4j.")
        println("Hello, World! farewell, and thanks for all the fish.");

        val vertx = Vertx.vertx()
        val server = vertx.createHttpServer()
        val port = 8081
        val router = Router.router(vertx)
        router.get("/").handler { it.response().end("Hello world!") }
        router.get("/oauthtmp").handler { it.response().end("Try to authenticate via Github...") }
        router.get("/callback").handler { it.response().end("calledback...") }

        var oauth2 = OAuth2Auth.create(vertx, OAuth2FlowType.AUTH_CODE, OAuth2ClientOptions(
                clientID = "YOUR_CLIENT_ID",
                clientSecret = "YOUR_CLIENT_SECRET",
                site = "https://github.com/login",
                tokenPath = "/oauth/access_token",
                authorizationPath = "/oauth/authorize"))

// when there is a need to access a protected resource or call a protected method,
// call the authZ url for a challenge

        var authorization_uri = oauth2.authorizeURL(json {
            obj(
                    "redirect_uri" to "http://localhost:8081/callback",
                    "scope" to "notifications",
                    "state" to "3(#0/!~"
            )
        })

// when working with web application use the above string as a redirect url

// in this case GitHub will call you back in the callback uri one should now complete the handshake as:


        var code = "xxxxxxxxxxxxxxxxxxxxxxxx"

        oauth2.authenticate(json {
            obj(
                    "code" to code,
                    "redirect_uri" to "http://localhost:8081/callback"
            )
        }, { res ->
            if (res.failed()) {
                // error, the code provided is not valid
                println("Failed" + res.cause().message)
            } else {
                // save the token and continue...
                println("Succeeded" + res.result().toString())
            }
        })

        server.requestHandler { router.accept(it) }.listen(port) {
            if (it.succeeded()) {
                println("\nServer listening at $port")
            } else {
                println(it.cause())
            }
        }
    }
}


