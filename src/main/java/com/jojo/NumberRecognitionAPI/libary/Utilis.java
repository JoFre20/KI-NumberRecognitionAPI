package com.jojo.NumberRecognitionAPI.libary;

/*    */ import java.sql.Timestamp;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.zip.CRC32;
/*    */ import java.util.zip.Checksum;
/*    */ 
/*    */ 
/*    */ public class Utilis
/*    */ {
/*    */   public static long getCRC32Checksum(byte[] bytes) {
/* 14 */     Checksum crc32 = new CRC32();
/* 15 */     crc32.update(bytes, 0, bytes.length);
/* 16 */     return crc32.getValue();
/*    */   }
/*    */   
/*    */   public static String getTimeStamp() {
/* 25 */     SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
/* 26 */     Timestamp timestamp = new Timestamp(System.currentTimeMillis());
/* 27 */     return sdf1.format(timestamp);
/*    */   }

/*    */ }