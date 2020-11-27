import com.google.inject.Inject
import org.cloudburstmc.server.Server
import org.cloudburstmc.server.event.Listener
import org.cloudburstmc.server.event.server.ServerInitializationEvent
import org.cloudburstmc.server.plugin.Plugin
import org.cloudburstmc.server.plugin.PluginContainer
import org.cloudburstmc.server.plugin.PluginDescription
import org.slf4j.Logger
import java.util.*


@Plugin(id = "bleedx", name = "Bleed", version = "1.0.0")
class Main {

    /**
     * I have yet to test anything out in
     * this plugin as I'm just playing around
     * with Cloudburst Server plugins in Kotlin.
     * If the code works, anyone is more than welcome
     * to use it at their own free-will.
     */

    private lateinit var description: PluginDescription
    private lateinit var logger: Logger

    @Inject
    fun Main(description: PluginDescription, logger: Logger) {
        this.description = description
        this.logger = logger
    }

    @Listener
    fun onInitialize(e: ServerInitializationEvent) {
        logger.info(description.name + " version " + description.version + " initialized!")
        Server.getInstance().eventManager.registerListeners(this, DamageListener())
    }
}