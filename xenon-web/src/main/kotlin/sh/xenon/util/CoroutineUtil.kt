package sh.xenon.util

import kotlinx.coroutines.experimental.launch
import org.jooby.Deferred


/**
 * Runs a suspending block on the coroutine common pool and
 * resolves a Deferred value once the coroutine completes.
 *
 * Useful for a Jooby handler to run code on coroutines, e.g.
 *
 * @GET
 * @Path("/")
 * fun get() = onCoroutine {
 *   asyncFunction().await()
 * }
 *
 * @return An org.jooby.Deferred value that will be resolved when the coroutine
 *   block completes, or rejecting if the coroutine throws.
 */
fun onCoroutine(block: suspend () -> Any) = Deferred({ promise ->
    launch {
        try {
            promise.resolve(block())
        } catch (exc: Throwable) {
            promise.reject(exc)
        }
    }
})

