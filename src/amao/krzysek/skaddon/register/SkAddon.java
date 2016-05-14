package amao.krzysek.skaddon.register;

import amao.krzysek.skaddon.register.conditions.files.FileExists;
import amao.krzysek.skaddon.register.conditions.folders.FolderExists;
import amao.krzysek.skaddon.register.conditions.players.*;
import amao.krzysek.skaddon.register.effects.files.CreateFile;
import amao.krzysek.skaddon.register.effects.files.DeleteFile;
import amao.krzysek.skaddon.register.effects.folders.CreateFolder;
import amao.krzysek.skaddon.register.effects.folders.DeleteFolder;
import amao.krzysek.skaddon.register.effects.mysql.Disconnect;
import amao.krzysek.skaddon.register.effects.mysql.OpenConnection;
import amao.krzysek.skaddon.register.effects.mysql.SendQuery;
import amao.krzysek.skaddon.register.effects.mysql.SendUpdate;
import amao.krzysek.skaddon.register.effects.players.*;
import amao.krzysek.skaddon.register.effects.servers.Shutdown;
import amao.krzysek.skaddon.register.effects.worlds.CreateWorld;
import amao.krzysek.skaddon.register.expressions.players.*;
import amao.krzysek.skaddon.register.expressions.strings.*;
import ch.njol.skript.Skript;
import ch.njol.skript.lang.ExpressionType;

public class SkAddon {

    public String getVersion() {
        return "0.0.1";
    }

    public SkAddon() {}

    public void register() {
        //Effects (18)
        Skript.registerEffect(CreateFile.class, new String[] {"(create|make) file %string%"});
        Skript.registerEffect(DeleteFile.class, new String[] {"(delete|remove) file %string%"});
        Skript.registerEffect(CreateFolder.class, new String[] {"(create|make) (folder|directory) %string%"});
        Skript.registerEffect(DeleteFolder.class, new String[] {"(delete|remove) (folder|directory) %string%"});
        Skript.registerEffect(CreateWorld.class, new String[] {"(create|make|generate) world with name %string%"});
        Skript.registerEffect(OpenAnvil.class, new String[] {"(open|show) anvil (to|for) %player%"});
        Skript.registerEffect(OpenBrewing.class, new String[] {"(open|show) brewing[stand] (to|for) %player%"});
        Skript.registerEffect(OpenCrafting.class, new String[] {"(open|show) crafting[ (bench|table)] (to|for) %player%"});
        Skript.registerEffect(OpenEnderchest.class, new String[] {"(open|show) enderchest (to|for) %player%"});
        Skript.registerEffect(OpenFurnace.class, new String[] {"(open|show) furnace (to|for) %player%"});
        Skript.registerEffect(OpenEnchant.class, new String[] {"(open|show) enchant[(ing|ing table)] (to|for) %player%"});
        Skript.registerEffect(OpenCreative.class, new String[] {"(open|show) creative (to|for) %player%"});
        Skript.registerEffect(Shutdown.class, new String[] {"shutdown server[ with message %string%]"});
        Skript.registerEffect(TeleportToWorld.class, new String[] {"teleport %player% to world %string%[ and location-in %location%]"});
        Skript.registerEffect(OpenConnection.class, new String[] {"(open|make) mysql connection h=%string% p=%string% d=%string% u=%string% p=%string%}"});
        Skript.registerEffect(SendQuery.class, new String[] {"(send|make|execute) mysql query %string%"});
        Skript.registerEffect(SendUpdate.class, new String[] {"(send|make|execute) mysql update %string%"});
        Skript.registerEffect(Disconnect.class, new String[] {"break mysql connection"});

        //Expressions (12)
        Skript.registerExpression(RandomLetter.class, String.class, ExpressionType.SIMPLE, new String[] {"random letter between %string% and %string%"});
        Skript.registerExpression(RandomLetterFromAlphabet.class, String.class, ExpressionType.SIMPLE, new String[] {"random letter from[ whole] alphabet"});
        Skript.registerExpression(RandomLetterFromString.class, String.class, ExpressionType.SIMPLE, new String[] {"random letter from[ whole] string %string%"});
        Skript.registerExpression(SkAddonVersion.class, String.class, ExpressionType.SIMPLE, new String[] {"SkAddon version"});
        Skript.registerExpression(UrlContent.class, String.class, ExpressionType.SIMPLE, new String[] {"content from (url|site|website|link|address) %string%"});
        Skript.registerExpression(InWorld.class, String.class, ExpressionType.SIMPLE, new String[] {"[all ]players (in|at|on) world %string%"});
        Skript.registerExpression(Pitch.class, Float.class, ExpressionType.SIMPLE, new String[] {"pitch of %player%"});
        Skript.registerExpression(Yaw.class, Float.class, ExpressionType.SIMPLE, new String[] {"yaw of %player%"});
        Skript.registerExpression(Ping.class, Integer.class, ExpressionType.SIMPLE, new String[] {"(ping of %player%|%player%'s ping)"});
        Skript.registerExpression(EnabledScripts.class, String.class, ExpressionType.SIMPLE, new String[] {"all (enabled|not disabled) scripts"});
        Skript.registerExpression(DisabledScripts.class, String.class, ExpressionType.SIMPLE, new String[] {"all (disabled|not enabled) scripts"});
        Skript.registerExpression(LastModificationTime.class, String.class, ExpressionType.SIMPLE, new String[] {"last modification time of file %string%"});

        //Conditions (8)
        Skript.registerCondition(FileExists.class, "file %string% [already ]exists");
        Skript.registerCondition(FolderExists.class, "(folder|directory) %string% [already ]exists");
        Skript.registerCondition(IsInWorld.class, "%player% is (in|at|on) world %string%");
        Skript.registerCondition(InventoryTypeAnvil.class, "%player%'s opened inventory type is anvil");
        Skript.registerCondition(InventoryTypeBrewing.class, "%player%'s opened inventory type is brewing[stand]");
        Skript.registerCondition(InventoryTypeCrafting.class, "%player%'s opened inventory type is crafting[ (bench|table)]");
        Skript.registerCondition(InventoryTypeEnderchest.class, "%player%'s opened inventory type is enderchest");
        Skript.registerCondition(InventoryTypeFurnace.class, "%player%'s opened inventory type is furnace");
    }

}
