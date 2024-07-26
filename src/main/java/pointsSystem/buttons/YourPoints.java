package pointsSystem.buttons;

import types.ServerButton;
import mysql.dashboard.PlayerInfos;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;

import java.awt.*;

public class YourPoints implements ServerButton {
    @Override
    public void performCommand(ButtonInteractionEvent event) {
        EmbedBuilder builder = new EmbedBuilder();

        int punkte = Integer.parseInt(PlayerInfos.getInfo(event.getMember().getId(), "discord_id", "points", "users"));

        builder.setTitle(event.getMember().getEffectiveName() + "s Punkte");
        builder.setDescription("Du hast **" + punkte + " Punkte**.");
        builder.setColor(Color.decode("#2ecc71"));
        builder.setThumbnail(PlayerInfos.getInfo(event.getMember().getId(), "discord_id", "discord_pb", "users"));

        event.replyEmbeds(builder.build()).setEphemeral(true).queue();
    }
}
