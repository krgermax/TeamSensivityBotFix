package commands;

import commands.types.ServerCommand;
import main.Main;
import mysql.BotInfos;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import org.json.simple.parser.ParseException;

import java.awt.*;

public class SelectGames implements ServerCommand {
    @Override
    public void performCommand(Member m, TextChannel channel, Message message) throws ParseException {
        if(m.hasPermission(Permission.ADMINISTRATOR)){
            EmbedBuilder schritt1 = new EmbedBuilder();
            schritt1.setColor(Color.decode("#9914fa"));
            schritt1.setThumbnail(BotInfos.getBotInfos("logo_url"));
            schritt1.addField("Schritt 1:", "Klicke auf den Reiter 'Kanäle & Rollen'.", false);
            schritt1.setImage("https://sensivity.team/bot/img/anleitung/Schritt_1.png");
            schritt1.setTitle("Select Games");

            EmbedBuilder schritt2 = new EmbedBuilder();
            schritt2.setColor(Color.decode("#9914fa"));
            schritt2.setThumbnail(BotInfos.getBotInfos("logo_url"));
            schritt2.addField("Schritt 2:", "Hier kannst du nun die Games auswählen die du spielst.", false);
            schritt2.setImage("https://sensivity.team/bot/img/anleitung/Schritt_2.png");
            schritt2.setTitle("Select Games");

            channel.sendMessageEmbeds(schritt1.build()).queue();
            channel.sendMessageEmbeds(schritt2.build()).queue();
        }else {
            channel.sendMessageEmbeds(Main.INSTANCE.getEmbedMessages().getNoPermission()).queue();
        }
    }
}
