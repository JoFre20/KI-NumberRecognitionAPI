package com.jojo.NumberRecognitionAPI.libary;

/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.FileNotFoundException;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.io.InputStreamReader;
/*    */ import java.nio.file.Files;
/*    */ import java.nio.file.Paths;
/*    */ import java.sql.Timestamp;
/*    */ import java.text.SimpleDateFormat;
/*    */ 
/*    */ 
/*    */ public class Server
/*    */ {
/*    */   private static File log;
/*    */   
/*    */   public static void println(String string) {
/* 21 */     String timeStamp = (new SimpleDateFormat("(yyyy-MM-dd|HH:mm.ss) ")).format(new Timestamp(System.currentTimeMillis()));
/* 22 */     System.out.println(timeStamp + string);
/* 23 */     writetolog(timeStamp + string);
/*    */   }

/*    */   public static void console(String string) {
/* 22 */     System.out.println(string);
/*    */   }
/*    */   
/*    */   public static void debug(String string) {
/* 27 */     String timeStamp = (new SimpleDateFormat("(yyyy-MM-dd|HH:mm.ss) ")).format(new Timestamp(System.currentTimeMillis()));
/* 28 */     System.out.println(timeStamp + "[DEBUG] " + string);
/*    */   }


/*    */   public static void warning(String string) {
/* 27 */     String timeStamp = (new SimpleDateFormat("(yyyy-MM-dd|HH:mm.ss) ")).format(new Timestamp(System.currentTimeMillis()));
/* 28 */     System.out.println(timeStamp + "\u001B[33m [Warning] " + string);
			 System.out.println("\u001B[0m");
/*    */   }


/*    */   public static void alert(String string) {
/* 27 */     String timeStamp = (new SimpleDateFormat("(yyyy-MM-dd|HH:mm.ss) ")).format(new Timestamp(System.currentTimeMillis()));
/* 28 */     System.out.println(timeStamp + "\u001B[31m [Alert] " + string);
             System.out.println("\u001B[0m");
/*    */   }

/*    */   public static void good(String string) {
/* 27 */     String timeStamp = (new SimpleDateFormat("(yyyy-MM-dd|HH:mm.ss) ")).format(new Timestamp(System.currentTimeMillis()));
/* 28 */     System.out.println(timeStamp + "\u001B[32m [Good] " + string);
             System.out.println("\u001B[0m");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static String getTimeStamp() {
/* 34 */     return (new SimpleDateFormat("[yyyy-MM-dd|HH:mm.ss]")).format(new Timestamp(System.currentTimeMillis()));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private static File getFolder() {
/* 40 */     File folder = new File("logs");
/* 41 */     folder.mkdirs();
/* 42 */     return folder;
/*    */   }
/*    */   
/*    */   public static void writetolog(String string) {
/* 46 */     String timeStamp = (new SimpleDateFormat("[yyyy-MM-dd#HH]")).format(new Timestamp(System.currentTimeMillis()));
/* 47 */     log = new File(getFolder(), timeStamp + ".log");
/* 48 */     if (!log.exists()) {
/*    */       try {
/* 50 */         log.createNewFile();
/* 51 */       } catch (IOException e) {
/*    */         
/* 53 */         e.printStackTrace();
/*    */       } 
/*    */     }
/* 56 */     String content = null;
/*    */     try {
/* 58 */       content = readFromInputStream(new FileInputStream(log)) + string;
/* 59 */     } catch (FileNotFoundException e1) {
/*    */       
/* 61 */       e1.printStackTrace();
/* 62 */     } catch (IOException e1) {
/*    */       
/* 64 */       e1.printStackTrace();
/*    */     } 
/*    */     try {
/* 67 */       Files.write(Paths.get(log.getAbsolutePath(), new String[0]), content.getBytes(), new java.nio.file.OpenOption[0]);
/* 68 */     } catch (IOException e) {
/*    */       
/* 70 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   private static String readFromInputStream(InputStream inputStream) throws IOException {
/* 76 */     StringBuilder resultStringBuilder = new StringBuilder();
/* 77 */     BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
/*    */     
/*    */     try { String line;
/* 80 */       while ((line = br.readLine()) != null) {
/* 81 */         resultStringBuilder.append(line).append("\n");
/*    */       }
/* 83 */       br.close(); } catch (Throwable throwable) { try { br.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  throw throwable; }
/* 84 */      return resultStringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Users\jonte\Desktop\AccountSystem\accountbackend.jar!\BOOT-INF\classes\com\jojo\accountbackend\libary\Server.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */