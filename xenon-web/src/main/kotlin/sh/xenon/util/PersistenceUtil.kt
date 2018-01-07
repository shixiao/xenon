package sh.xenon.util

import javax.persistence.EntityManager
import javax.persistence.TypedQuery
import javax.persistence.criteria.CriteriaQuery

fun <T> EntityManager.withTransaction(block: () -> T): T {
    transaction.begin()
    try {
        val retn = block()
        transaction.commit()
        return retn
    } catch (exception: Exception) {
        transaction.rollback()
        throw exception
    }
}

fun <T> EntityManager.buildQuery(
        classType: Class<T>,
        block: CriteriaQuery<T>.() -> CriteriaQuery<T>
): TypedQuery<T> {
    val query: CriteriaQuery<T> = criteriaBuilder.createQuery(classType)
    val evaluated = block.invoke(query)
    return createQuery(evaluated)
}

