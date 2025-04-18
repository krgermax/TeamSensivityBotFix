package listeners.interactions;

import main.Start;
import net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class UserContextInteraction extends ListenerAdapter {
    @Override
    public void onUserContextInteraction(UserContextInteractionEvent event) {
        if (!Start.INSTANCE.getUserManager().perform(event.getFullCommandName(), event)) {
            event.reply("Unbekannter Button").setEphemeral(true).queue();
        }
    }
}
