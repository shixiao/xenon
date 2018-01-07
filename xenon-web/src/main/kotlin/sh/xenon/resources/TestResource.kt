package sh.xenon.resources

import org.jooby.mvc.GET
import org.jooby.mvc.POST
import org.jooby.mvc.Path
import org.jooby.mvc.Produces
import sh.xenon.entities.User
import sh.xenon.util.withTransaction
import javax.inject.Inject
import javax.persistence.EntityManager

@Path("/test")
@Produces("application/json")
class TestResource @Inject constructor(
    private val entityManager: EntityManager
) {
    @GET
    fun get(): List<User> {
        return entityManager
                .createQuery("SELECT f FROM User user", User::class.java)
                .resultList
    }

    @Path("/2")
    @GET
    fun getWithDsl(): List<User> {
        return listOf()
    }

    @Path("/create")
    @POST
    fun create(): User {
        return entityManager.withTransaction {
            val newUser = User(handle = "scott")
            entityManager.persist(newUser)
            newUser
        }
    }
}
