package me.stefan923.perfectshop.commands.type;

import me.stefan923.perfectshop.PerfectShop;
import me.stefan923.perfectshop.utils.MessageUtils;
import me.stefan923.perfectshop.commands.AbstractCommand;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.List;

public class CommandReload extends AbstractCommand implements MessageUtils {

    public CommandReload(AbstractCommand abstractCommand) {
        super(abstractCommand, false, "reload");
    }

    @Override
    protected ReturnType runCommand(PerfectShop instance, CommandSender sender, String... args) {
        if (args.length != 2)
            return ReturnType.SYNTAX_ERROR;

        if (args[1].equalsIgnoreCase("all")) {
            instance.reloadSettingManager();
            instance.reloadLanguageManager();
            sender.sendMessage(formatAll("&8[&3PerfectShop&8] &fYou have successfully reloaded &ball &fmodules!"));
            return ReturnType.SUCCESS;
        }

        if (args[1].equalsIgnoreCase("settings")) {
            instance.reloadSettingManager();
            sender.sendMessage(formatAll("&8[&3PerfectShop&8] &fYou have successfully reloaded &bsettings &fmodule!"));
            return ReturnType.SUCCESS;
        }

        if (args[1].equalsIgnoreCase("languages")) {
            instance.reloadLanguageManager();
            sender.sendMessage(formatAll("&8[&3PerfectShop&8] &fYou have successfully reloaded &blanguages &fmodule!"));
            return ReturnType.SUCCESS;
        }

        return ReturnType.SYNTAX_ERROR;
    }

    @Override
    protected List<String> onTab(PerfectShop instance, CommandSender sender, String... args) {
        if (sender.hasPermission("perfectshop.admin"))
            return Arrays.asList("settings", "languages", "all");
        return null;
    }

    @Override
    public String getPermissionNode() {
        return "perfectshop.admin";
    }

    @Override
    public String getSyntax() {
        return "/perfectshop reload <all|settings|language>";
    }

    @Override
    public String getDescription() {
        return "Reloads plugin settings.";
    }

}
