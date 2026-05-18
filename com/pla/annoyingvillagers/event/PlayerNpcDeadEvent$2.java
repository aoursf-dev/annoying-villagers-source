/*     */ package com.pla.annoyingvillagers.event;
/*     */ 
/*     */ import com.pla.annoyingvillagers.task.DelayedTask;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EquipmentSlot;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.item.ItemEntity;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.Items;
/*     */ import net.minecraft.world.level.ItemLike;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.LevelAccessor;
/*     */ import net.minecraft.world.level.block.Blocks;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends DelayedTask
/*     */ {
/*     */   null(int waitTicks) {
/* 198 */     super(waitTicks);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() {
/* 205 */     if (!entity.getPersistentData().m_128471_("die_by_possess")) {
/* 206 */       LevelAccessor levelAccessor = levelaccessor;
/* 207 */       LivingEntity livingentity = (LivingEntity)entity;
/*     */ 
/*     */       
/* 210 */       if (levelAccessor instanceof Level) {
/* 211 */         Level level = (Level)levelAccessor;
/* 212 */         if (!level.m_5776_()) {
/* 213 */           ItemStack itemstack; if (entity instanceof LivingEntity) {
/* 214 */             itemstack = livingentity.m_6844_(EquipmentSlot.FEET);
/*     */           } else {
/* 216 */             itemstack = ItemStack.f_41583_;
/*     */           } 
/*     */           
/* 219 */           ItemEntity itementity = new ItemEntity(level, d0, d1 + 1.0D, d2, itemstack);
/* 220 */           itementity.m_32010_(10);
/* 221 */           level.m_7967_((Entity)itementity);
/*     */         } 
/*     */       } 
/*     */       
/* 225 */       levelAccessor = levelaccessor;
/* 226 */       if (levelAccessor instanceof Level) {
/* 227 */         Level level = (Level)levelAccessor;
/* 228 */         if (!level.m_5776_()) {
/* 229 */           ItemStack itemstack; if (entity instanceof LivingEntity) {
/* 230 */             itemstack = livingentity.m_6844_(EquipmentSlot.LEGS);
/*     */           } else {
/* 232 */             itemstack = ItemStack.f_41583_;
/*     */           } 
/*     */           
/* 235 */           ItemEntity itementity = new ItemEntity(level, d0, d1 + 1.0D, d2, itemstack);
/* 236 */           itementity.m_32010_(10);
/* 237 */           level.m_7967_((Entity)itementity);
/*     */         } 
/*     */       } 
/*     */       
/* 241 */       levelAccessor = levelaccessor;
/* 242 */       if (levelAccessor instanceof Level) {
/* 243 */         Level level = (Level)levelAccessor;
/* 244 */         if (!level.m_5776_()) {
/* 245 */           ItemStack itemstack; if (entity instanceof LivingEntity) {
/* 246 */             itemstack = livingentity.m_6844_(EquipmentSlot.CHEST);
/*     */           } else {
/* 248 */             itemstack = ItemStack.f_41583_;
/*     */           } 
/*     */           
/* 251 */           ItemEntity itementity = new ItemEntity(level, d0, d1 + 1.0D, d2, itemstack);
/* 252 */           itementity.m_32010_(10);
/* 253 */           level.m_7967_((Entity)itementity);
/*     */         } 
/*     */       } 
/*     */       
/* 257 */       levelAccessor = levelaccessor;
/* 258 */       if (levelAccessor instanceof Level) {
/* 259 */         Level level = (Level)levelAccessor;
/* 260 */         if (!level.m_5776_()) {
/* 261 */           ItemStack itemstack; if (entity instanceof LivingEntity) {
/* 262 */             itemstack = livingentity.m_6844_(EquipmentSlot.HEAD);
/*     */           } else {
/* 264 */             itemstack = ItemStack.f_41583_;
/*     */           } 
/*     */           
/* 267 */           ItemEntity itementity = new ItemEntity(level, d0, d1 + 1.0D, d2, itemstack);
/* 268 */           itementity.m_32010_(10);
/* 269 */           level.m_7967_((Entity)itementity);
/*     */         } 
/*     */       } 
/*     */       
/* 273 */       levelAccessor = levelaccessor;
/* 274 */       if (levelAccessor instanceof Level) {
/* 275 */         Level level = (Level)levelAccessor;
/* 276 */         if (!level.m_5776_()) {
/* 277 */           ItemStack itemstack; if (entity instanceof LivingEntity) {
/* 278 */             itemstack = livingentity.m_21205_();
/*     */           } else {
/* 280 */             itemstack = ItemStack.f_41583_;
/*     */           } 
/*     */           
/* 283 */           ItemEntity itementity = new ItemEntity(level, d0, d1 + 1.0D, d2, itemstack);
/* 284 */           itementity.m_32010_(10);
/* 285 */           level.m_7967_((Entity)itementity);
/*     */         } 
/*     */       } 
/*     */       
/* 289 */       levelAccessor = levelaccessor;
/* 290 */       if (levelAccessor instanceof Level) {
/* 291 */         Level level = (Level)levelAccessor;
/* 292 */         if (!level.m_5776_()) {
/* 293 */           ItemStack itemstack; if (entity instanceof LivingEntity) {
/* 294 */             itemstack = livingentity.m_21206_();
/*     */           } else {
/* 296 */             itemstack = ItemStack.f_41583_;
/*     */           } 
/*     */           
/* 299 */           ItemEntity itementity = new ItemEntity(level, d0, d1 + 1.0D, d2, itemstack);
/* 300 */           itementity.m_32010_(10);
/* 301 */           level.m_7967_((Entity)itementity);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 306 */     LevelAccessor levelaccessor1 = levelaccessor;
/* 307 */     if (levelaccessor1 instanceof Level) {
/* 308 */       Level level = (Level)levelaccessor1;
/* 309 */       if (!level.m_5776_()) {
/* 310 */         ItemEntity itementity = new ItemEntity(level, d0, d1 + 1.0D, d2, new ItemStack((ItemLike)Blocks.f_50705_));
/* 311 */         itementity.m_32010_(10);
/* 312 */         level.m_7967_((Entity)itementity);
/*     */       } 
/*     */     } 
/*     */     
/* 316 */     levelaccessor1 = levelaccessor;
/* 317 */     if (levelaccessor1 instanceof Level) {
/* 318 */       Level level = (Level)levelaccessor1;
/* 319 */       if (!level.m_5776_()) {
/* 320 */         ItemEntity itementity = new ItemEntity(level, d0, d1 + 1.0D, d2, new ItemStack((ItemLike)Blocks.f_50705_));
/* 321 */         itementity.m_32010_(10);
/* 322 */         level.m_7967_((Entity)itementity);
/*     */       } 
/*     */     } 
/*     */     
/* 326 */     levelaccessor1 = levelaccessor;
/* 327 */     if (levelaccessor1 instanceof Level) {
/* 328 */       Level level = (Level)levelaccessor1;
/* 329 */       if (!level.m_5776_()) {
/* 330 */         ItemEntity itementity = new ItemEntity(level, d0, d1 + 1.0D, d2, new ItemStack((ItemLike)Items.f_42411_));
/* 331 */         itementity.m_32010_(10);
/* 332 */         level.m_7967_((Entity)itementity);
/*     */       } 
/*     */     } 
/*     */     
/* 336 */     levelaccessor1 = levelaccessor;
/* 337 */     if (levelaccessor1 instanceof Level) {
/* 338 */       Level level = (Level)levelaccessor1;
/* 339 */       if (!level.m_5776_()) {
/* 340 */         ItemEntity itementity = new ItemEntity(level, d0, d1 + 1.0D, d2, new ItemStack((ItemLike)Items.f_42412_));
/* 341 */         itementity.m_32010_(10);
/* 342 */         level.m_7967_((Entity)itementity);
/*     */       } 
/*     */     } 
/*     */     
/* 346 */     levelaccessor1 = levelaccessor;
/* 347 */     if (levelaccessor1 instanceof Level) {
/* 348 */       Level level = (Level)levelaccessor1;
/* 349 */       if (!level.m_5776_()) {
/* 350 */         ItemEntity itementity = new ItemEntity(level, d0, d1 + 1.0D, d2, new ItemStack((ItemLike)Items.f_42412_));
/* 351 */         itementity.m_32010_(10);
/* 352 */         level.m_7967_((Entity)itementity);
/*     */       } 
/*     */     } 
/*     */     
/* 356 */     levelaccessor1 = levelaccessor;
/* 357 */     if (levelaccessor1 instanceof Level) {
/* 358 */       Level level = (Level)levelaccessor1;
/* 359 */       if (!level.m_5776_()) {
/* 360 */         ItemEntity itementity = new ItemEntity(level, d0, d1 + 1.0D, d2, new ItemStack((ItemLike)Items.f_42412_));
/* 361 */         itementity.m_32010_(10);
/* 362 */         level.m_7967_((Entity)itementity);
/*     */       } 
/*     */     } 
/*     */     
/* 366 */     levelaccessor1 = levelaccessor;
/* 367 */     if (levelaccessor1 instanceof Level) {
/* 368 */       Level level = (Level)levelaccessor1;
/* 369 */       if (!level.m_5776_()) {
/* 370 */         ItemEntity itementity = new ItemEntity(level, d0, d1 + 1.0D, d2, new ItemStack((ItemLike)Items.f_42412_));
/* 371 */         itementity.m_32010_(10);
/* 372 */         level.m_7967_((Entity)itementity);
/*     */       } 
/*     */     } 
/*     */     
/* 376 */     levelaccessor1 = levelaccessor;
/* 377 */     if (levelaccessor1 instanceof Level) {
/* 378 */       Level level = (Level)levelaccessor1;
/* 379 */       if (!level.m_5776_()) {
/* 380 */         ItemEntity itementity = new ItemEntity(level, d0, d1 + 1.0D, d2, new ItemStack((ItemLike)Items.f_42584_));
/* 381 */         itementity.m_32010_(10);
/* 382 */         level.m_7967_((Entity)itementity);
/*     */       } 
/*     */     } 
/*     */     
/* 386 */     levelaccessor1 = levelaccessor;
/* 387 */     if (levelaccessor1 instanceof Level) {
/* 388 */       Level level = (Level)levelaccessor1;
/* 389 */       if (!level.m_5776_()) {
/* 390 */         ItemEntity itementity = new ItemEntity(level, d0, d1 + 1.0D, d2, new ItemStack((ItemLike)Items.f_42584_));
/* 391 */         itementity.m_32010_(10);
/* 392 */         level.m_7967_((Entity)itementity);
/*     */       } 
/*     */     } 
/*     */     
/* 396 */     levelaccessor1 = levelaccessor;
/* 397 */     if (levelaccessor1 instanceof Level) {
/* 398 */       Level level = (Level)levelaccessor1;
/* 399 */       if (!level.m_5776_()) {
/* 400 */         ItemEntity itementity = new ItemEntity(level, d0, d1 + 1.0D, d2, new ItemStack((ItemLike)Items.f_42436_));
/* 401 */         itementity.m_32010_(10);
/* 402 */         level.m_7967_((Entity)itementity);
/*     */       } 
/*     */     } 
/*     */     
/* 406 */     levelaccessor1 = levelaccessor;
/* 407 */     if (levelaccessor1 instanceof Level) {
/* 408 */       Level level = (Level)levelaccessor1;
/* 409 */       if (!level.m_5776_()) {
/* 410 */         ItemEntity itementity = new ItemEntity(level, d0, d1 + 1.0D, d2, new ItemStack((ItemLike)Items.f_42436_));
/* 411 */         itementity.m_32010_(10);
/* 412 */         level.m_7967_((Entity)itementity);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\event\PlayerNpcDeadEvent$2.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */