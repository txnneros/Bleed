import com.google.inject.Inject
import com.nukkitx.math.vector.Vector3f
import org.cloudburstmc.server.event.Listener
import org.cloudburstmc.server.event.entity.EntityDamageByEntityEvent
import org.cloudburstmc.server.event.entity.EntityDamageEvent
import org.cloudburstmc.server.event.server.ServerInitializationEvent
import org.cloudburstmc.server.level.Sound
import org.cloudburstmc.server.level.particle.RedstoneParticle
import org.cloudburstmc.server.player.Player
import org.cloudburstmc.server.plugin.Plugin
import org.cloudburstmc.server.plugin.PluginDescription
import org.slf4j.Logger

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
    }

    @Listener
    fun onDamage(e: EntityDamageEvent) {
        if(e is EntityDamageByEntityEvent) {
            if(e.entity is Player && e.damager is Player) {
                e.entity.level.addParticle(RedstoneParticle(Vector3f.from(e.entity.x, e.entity.y + 2, e.entity.z)))
                e.damager.level.addSound(Vector3f.from(e.damager.x, e.damager.y, e.damager.z), Sound.ITEM_TRIDENT_HIT)
            }
        }
    }
}