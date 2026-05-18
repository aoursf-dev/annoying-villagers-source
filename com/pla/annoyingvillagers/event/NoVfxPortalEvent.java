/*     */ package com.pla.annoyingvillagers.event;
/*     */ 
/*     */ import com.mojang.blaze3d.vertex.PoseStack;
/*     */ import com.mojang.blaze3d.vertex.VertexConsumer;
/*     */ import com.mojang.math.Axis;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.LightTexture;
/*     */ import net.minecraft.client.renderer.MultiBufferSource;
/*     */ import net.minecraft.client.renderer.RenderType;
/*     */ import net.minecraft.client.renderer.texture.OverlayTexture;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraftforge.api.distmarker.Dist;
/*     */ import net.minecraftforge.client.event.RenderLevelStageEvent;
/*     */ import net.minecraftforge.event.TickEvent;
/*     */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*     */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*     */ import org.joml.Matrix4f;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @EventBusSubscriber(modid = "annoyingvillagers", value = {Dist.CLIENT})
/*     */ public final class NoVfxPortalEvent
/*     */ {
/*  30 */   private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/entities/portal.png");
/*  31 */   private static final RenderType PORTAL_TYPE = RenderType.m_110473_(TEXTURE);
/*     */   
/*  33 */   private static final int FULL_BRIGHT_LIGHT = LightTexture.m_109885_(15, 15);
/*     */   
/*     */   private static final float PORTAL_HALF_SIZE = 2.5F;
/*     */   
/*     */   private static final int GROW_TICKS = 20;
/*     */   private static final int SHRINK_TICKS = 20;
/*  39 */   private static final List<PortalInstance> ACTIVE = new ArrayList<>();
/*     */ 
/*     */ 
/*     */   
/*     */   public static void spawn(Vec3 pos, int holdTicks) {
/*  44 */     Minecraft mc = Minecraft.m_91087_();
/*  45 */     if (mc.f_91073_ == null)
/*  46 */       return;  ACTIVE.add(new PortalInstance(pos, mc.f_91073_.m_46467_(), holdTicks));
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void onClientTick(TickEvent.ClientTickEvent e) {
/*  51 */     if (e.phase != TickEvent.Phase.END)
/*     */       return; 
/*  53 */     Minecraft mc = Minecraft.m_91087_();
/*  54 */     if (mc.f_91073_ == null) {
/*  55 */       ACTIVE.clear();
/*     */       
/*     */       return;
/*     */     } 
/*  59 */     long nowTick = mc.f_91073_.m_46467_();
/*  60 */     Iterator<PortalInstance> it = ACTIVE.iterator();
/*  61 */     while (it.hasNext()) {
/*  62 */       PortalInstance p = it.next();
/*  63 */       if (p.isExpired(nowTick)) it.remove();
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void onRenderLevel(RenderLevelStageEvent e) {
/*  70 */     if (e.getStage() != RenderLevelStageEvent.Stage.AFTER_PARTICLES)
/*     */       return; 
/*  72 */     Minecraft mc = Minecraft.m_91087_();
/*  73 */     if (mc.f_91073_ == null || ACTIVE.isEmpty())
/*     */       return; 
/*  75 */     PoseStack poseStack = e.getPoseStack();
/*  76 */     Vec3 cam = e.getCamera().m_90583_();
/*  77 */     float partial = e.getPartialTick();
/*     */     
/*  79 */     poseStack.m_85836_();
/*  80 */     poseStack.m_85837_(-cam.f_82479_, -cam.f_82480_, -cam.f_82481_);
/*     */     
/*  82 */     MultiBufferSource.BufferSource buffer = mc.m_91269_().m_110104_();
/*     */     
/*  84 */     long nowTick = mc.f_91073_.m_46467_();
/*  85 */     for (PortalInstance p : ACTIVE) {
/*  86 */       float time = (float)(nowTick - p.startTick) + partial;
/*  87 */       renderPortal(poseStack, (MultiBufferSource)buffer, p.pos, time, p.holdTicks);
/*     */     } 
/*     */     
/*  90 */     buffer.m_109912_(PORTAL_TYPE);
/*     */     
/*  92 */     poseStack.m_85849_();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void renderPortal(PoseStack poseStack, MultiBufferSource bufferSource, Vec3 basePos, float animationTime, int holdTicks) {
/* 101 */     float rotationDegrees = animationTime * Mth.m_14036_(animationTime / 30.0F, 1.0F, 10.0F);
/*     */     
/* 103 */     float scale = computeScale(animationTime, holdTicks);
/* 104 */     scale = Math.max(0.001F, scale);
/*     */     
/* 106 */     int alpha = Mth.m_14045_((int)(255.0F * Mth.m_14036_(scale * 1.1F, 0.0F, 1.0F)), 0, 255);
/*     */     
/* 108 */     poseStack.m_85836_();
/*     */     
/* 110 */     poseStack.m_85837_(basePos.f_82479_, basePos.f_82480_ + 0.015D, basePos.f_82481_);
/* 111 */     poseStack.m_252781_(Axis.f_252436_.m_252977_(rotationDegrees));
/* 112 */     poseStack.m_85841_(scale, 1.0F, scale);
/*     */     
/* 114 */     PoseStack.Pose pose = poseStack.m_85850_();
/* 115 */     Matrix4f mat = pose.m_252922_();
/* 116 */     VertexConsumer vc = bufferSource.m_6299_(PORTAL_TYPE);
/*     */     
/* 118 */     int r = 255, g = 255, b = 255, a = alpha;
/*     */     
/* 120 */     vc.m_252986_(mat, -2.5F, 0.0F, -2.5F)
/* 121 */       .m_6122_(r, g, b, a).m_7421_(0.0F, 0.0F)
/* 122 */       .m_86008_(OverlayTexture.f_118083_).m_85969_(FULL_BRIGHT_LIGHT)
/* 123 */       .m_252939_(pose.m_252943_(), 0.0F, 1.0F, 0.0F).m_5752_();
/*     */     
/* 125 */     vc.m_252986_(mat, 2.5F, 0.0F, -2.5F)
/* 126 */       .m_6122_(r, g, b, a).m_7421_(1.0F, 0.0F)
/* 127 */       .m_86008_(OverlayTexture.f_118083_).m_85969_(FULL_BRIGHT_LIGHT)
/* 128 */       .m_252939_(pose.m_252943_(), 0.0F, 1.0F, 0.0F).m_5752_();
/*     */     
/* 130 */     vc.m_252986_(mat, 2.5F, 0.0F, 2.5F)
/* 131 */       .m_6122_(r, g, b, a).m_7421_(1.0F, 1.0F)
/* 132 */       .m_86008_(OverlayTexture.f_118083_).m_85969_(FULL_BRIGHT_LIGHT)
/* 133 */       .m_252939_(pose.m_252943_(), 0.0F, 1.0F, 0.0F).m_5752_();
/*     */     
/* 135 */     vc.m_252986_(mat, -2.5F, 0.0F, 2.5F)
/* 136 */       .m_6122_(r, g, b, a).m_7421_(0.0F, 1.0F)
/* 137 */       .m_86008_(OverlayTexture.f_118083_).m_85969_(FULL_BRIGHT_LIGHT)
/* 138 */       .m_252939_(pose.m_252943_(), 0.0F, 1.0F, 0.0F).m_5752_();
/*     */     
/* 140 */     poseStack.m_85849_();
/*     */   }
/*     */   
/*     */   private static float computeScale(float t, int holdTicks) {
/* 144 */     if (t <= 20.0F) {
/* 145 */       float p = t / 20.0F;
/* 146 */       return easeOutCubic(p);
/*     */     } 
/* 148 */     float shrinkProgress = (t - 20.0F - holdTicks) / 20.0F;
/* 149 */     return 1.0F - easeInCubic(Mth.m_14036_(shrinkProgress, 0.0F, 1.0F));
/*     */   }
/*     */   
/* 152 */   private static float easeOutCubic(float x) { return 1.0F - (float)Math.pow((1.0F - x), 3.0D); } private static float easeInCubic(float x) {
/* 153 */     return x * x * x;
/*     */   }
/*     */   
/*     */   private static final class PortalInstance { final Vec3 pos;
/*     */     final long startTick;
/*     */     final int holdTicks;
/*     */     final int durationTicks;
/*     */     
/*     */     PortalInstance(Vec3 pos, long startTick, int holdTicks) {
/* 162 */       this.pos = pos;
/* 163 */       this.startTick = startTick;
/* 164 */       this.holdTicks = holdTicks;
/* 165 */       this.durationTicks = 20 + holdTicks + 20;
/*     */     }
/*     */     
/*     */     boolean isExpired(long nowTick) {
/* 169 */       return (nowTick - this.startTick > this.durationTicks);
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\event\NoVfxPortalEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */