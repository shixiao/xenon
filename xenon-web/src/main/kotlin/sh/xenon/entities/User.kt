package sh.xenon.entities

import org.jetbrains.annotations.Nullable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "users")
data class User (
        @Id
        @Column(length = 128)
        val handle: String = "",

        @Nullable
        @Column(length = 128)
        val password: String? = null
) {
}
