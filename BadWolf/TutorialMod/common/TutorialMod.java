package BadWolf.TutorialMod.common;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.SidedProxy;
import BadWolf.TutorialMod.common.TutorialModCommonProxy;

@NetworkMod(clientSideRequired=true,serverSideRequired=true,
clientPacketHandlerSpec = @SidedPacketHandler(channels = {"TutorialMod"}, packetHandler = TutorialModClientPacketHandler.class),
serverPacketHandlerSpec = @SidedPacketHandler(channels = {"TutorialMod"}, packetHandler = TutorialModServerPacketHandler.class))

@Mod(modid="TutorialMod",name="Tutorial Mod",version="Alpha")

public class TutorialMod {

@Instance("TutorialMod")
public static TutorialMod instance = new TutorialMod();

@SidedProxy(clientSide = "BadWolf.TutorialMod.client.TutorialModClientProxy", serverSide = "BadWolf.TutorialMod.common.TutorialModCommonProxy") 
public static TutorialModCommonProxy proxy;

@PreInit
public void PreInit(FMLPreInitializationEvent e){

}

@Init
public void InitTutorialMod(FMLInitializationEvent event){

NetworkRegistry.instance().registerGuiHandler(this, proxy);

}
}
