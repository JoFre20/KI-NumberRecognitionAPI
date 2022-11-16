package com.jojo.NumberRecognitionAPI.libary;

/*    */ 
/*    */ import java.io.File;
/*    */ 
/*    */ public enum OSHelper
/*    */ {
/*  7 */   WINDOWS("AppData" + File.separator + "Roaming" + File.separator + ".minecraft"),
/*  8 */   MAC("Library" + File.separator + "Application Support" + File.separator + "minecraft"),
/*  9 */   LINUX(".minecraft");
/*    */   private final String mc;
/*    */   
/*    */   OSHelper(String mc) {
/* 13 */     this.mc = File.separator + mc + File.separator;
/*    */   }
/*    */   
/*    */   public String getMc() {
/* 17 */     return System.getProperty("user.home") + this.mc;
/*    */   }
/*    */   
/*    */   public static boolean isOnPC() {
/* 21 */     String currentOS = System.getProperty("os.name").toLowerCase();
/* 22 */     if (currentOS.startsWith("windows")) {
/* 23 */       return true;
/*    */     }
/* 25 */     if (currentOS.startsWith("mac")) {
/* 26 */       return true;
/*    */     }
/* 28 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public static final OSHelper getOS() {
/* 33 */     String currentOS = System.getProperty("os.name").toLowerCase();
/* 34 */     if (currentOS.startsWith("windows")) {
/* 35 */       return WINDOWS;
/*    */     }
/* 37 */     if (currentOS.startsWith("mac")) {
/* 38 */       return MAC;
/*    */     }
/* 40 */     return LINUX;
/*    */   }
/*    */ 
/*    */   
/*    */   public static final String getOSString() {
/* 45 */     String currentOS = System.getProperty("os.name").toLowerCase();
/* 46 */     if (currentOS.startsWith("windows")) {
/* 47 */       return "Windows";
/*    */     }
/* 49 */     if (currentOS.startsWith("mac")) {
/* 50 */       return "Mac";
/*    */     }
/* 52 */     return "Diverses";
/*    */   }
/*    */ }


/* Location:              C:\Users\jonte\Desktop\AccountSystem\accountbackend.jar!\BOOT-INF\classes\com\jojo\accountbackend\libary\OSHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */