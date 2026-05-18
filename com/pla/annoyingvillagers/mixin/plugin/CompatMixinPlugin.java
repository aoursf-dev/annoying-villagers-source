/*    */ package com.pla.annoyingvillagers.mixin.plugin;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import net.minecraftforge.fml.loading.FMLLoader;
/*    */ import net.minecraftforge.fml.loading.LoadingModList;
/*    */ import org.objectweb.asm.tree.ClassNode;
/*    */ import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
/*    */ import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
/*    */ 
/*    */ public final class CompatMixinPlugin implements IMixinConfigPlugin {
/*    */   private static final String EFN_COMPAT_PREFIX = "com.pla.annoyingvillagers.mixin.compat.efn.";
/*    */   
/*    */   private static boolean isEfnLoadedEarly() {
/* 15 */     LoadingModList list = FMLLoader.getLoadingModList();
/* 16 */     return (list != null && list.getModFileById("efn") != null);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void onLoad(String mixinPackage) {}
/*    */ 
/*    */   
/*    */   public String getRefMapperConfig() {
/* 25 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
/* 30 */     if (mixinClassName.startsWith("com.pla.annoyingvillagers.mixin.compat.efn.")) {
/* 31 */       return isEfnLoadedEarly();
/*    */     }
/* 33 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {}
/*    */ 
/*    */   
/*    */   public List<String> getMixins() {
/* 42 */     return null;
/*    */   }
/*    */   
/*    */   public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}
/*    */   
/*    */   public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mixin\plugin\CompatMixinPlugin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */