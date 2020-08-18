package me.stefan923.PerfectShop.commands.type;

import me.stefan923.perfectshop.PerfectShop;
import me.stefan923.perfectshop.commands.AbstractCommand;
import me.stefan923.perfectshop.utils.MessageUtils;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.List;

public class CommandPerfectShop extends AbstractCommand implements MessageUtils {

    public CommandPerfectShop() {
        super(null, false, "perfectshop");
    }

    @Override
    protected ReturnType runCommand(PerfectShop instance, CommandSender sender, String... args) {
        sender.sendMessage(formatAll(" "));
        sendCenteredMessage(sender, formatAll("&8&m--+----------------------------------------+--&r"));
        sendCenteredMessage(sender, formatAll("&3&lPerfectShop &f&lv" + instance.getDescription().getVersion()));
        sendCenteredMessage(sender, formatAll("&8&l» &fPlugin author: &bStefan923"));
        sendCenteredMessage(sender, formatAll(" "));
        sendCenteredMessage(sender, formatAll("&8&l» &fAdds the afk status with customisable settings."));
        sendCenteredMessage(sender, formatAll("&8&m--+----------------------------------------+--&r"));
        sender.sendMessage(formatAll(" "));

        return ReturnType.SUCCESS;
    }

    @Override
    protected List<String> onTab(PerfectShop instance, CommandSender sender, String... args) {
        if (sender.hasPermission("perfectshop.admin"))
            return Arrays.asList("reload");
        return null;
    }

    @Override
    public String getPermissionNode() {
        return null;
    }

    @Override
    public String getSyntax() {
        return "/perfectshop";
    }

    @Override
    public String getDescription() {
        return "Displays plugin info";
    }

}
