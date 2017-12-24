package sh.xenon

import com.fasterxml.jackson.annotation.JsonProperty
import io.dropwizard.Configuration
import org.hibernate.validator.constraints.NotEmpty

data class XenonConfig(
        @JsonProperty
        @NotEmpty
        var content: String = "Hello World!"
) : Configuration()
