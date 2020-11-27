import com.nukkitx.math.vector.Vector3f
import org.cloudburstmc.server.event.Listener
import org.cloudburstmc.server.event.entity.EntityDamageByEntityEvent
import org.cloudburstmc.server.event.entity.EntityDamageEvent
import org.cloudburstmc.server.level.Sound
import org.cloudburstmc.server.level.particle.RedstoneParticle
import org.cloudburstmc.server.player.Player

class DamageListener {

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