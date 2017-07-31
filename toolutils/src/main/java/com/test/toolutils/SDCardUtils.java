package com.test.toolutils;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;

import java.io.File;

/**
 * SD卡相关的辅助类
 */

public class SDCardUtils {

    /**
     * 判断SDCard是否可用
     *
     * @return
     */
    public static boolean isSDCardEnable()
    {
        return Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED);

    }

    /**
     * 获取SD卡路径
     *
     * @return
     */
    public static String getSDCardPath()
    {
        if(isSDCardEnable()){
            return Environment.getExternalStorageDirectory().getAbsolutePath()
                    + File.separator;
        }else {
            return null;
        }

    }

    /**
     * 获取SD卡DownloadCache路径
     * @return
     * SD卡存在返回正常路径；SD卡不存在返回null
     */
    public static String getSDCardDownloadCachePath(){
        if(isSDCardEnable()){
            return Environment.getDownloadCacheDirectory().getAbsolutePath() + File.separator;
        }else{
            return null;
        }
    }

    /**
     * 获取系统存储路径
     *
     * @return
     */
    public static String getRootDirectoryPath()
    {
        if(isSDCardEnable()){
            return Environment.getRootDirectory().getAbsolutePath() + File.separator;
        }else {
            return null;
        }
    }

    /**
     * 获取应用程序的/data/data目录
     * @param context
     * @return
     */
    public static String getDataFilePath(Context context){
        return context.getFilesDir().getAbsolutePath() + File.separator;
    }

    /**
     * /data/data/PackageName/cache的路径
     * @param context
     * @return
     */
    public static String getDataCachePath(Context context){
        return context.getCacheDir().getAbsolutePath() + File.separator;
    }

    /**
     * 获取SD卡大小
     * @return
     * SD卡存在返回大小；SD卡不存在返回-1
     */
    public static long getSDCardSize(){
        if(isSDCardEnable()){
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator);
            if(android.os.Build.VERSION.SDK_INT < 18){
                int blockSize = statFs.getBlockSize();
                int blockCount = statFs.getBlockCount();
                return blockCount * blockSize;
            }else{
                long blockSize = statFs.getBlockSizeLong();
                long blockCount = statFs.getBlockCountLong();
                return blockCount * blockSize;
            }
        }
        return -1;
    }

    /**
     * 获得手机内存总大小
     * @return
     */
    public long getRomTotalSize() {
        File path = Environment.getDataDirectory();
        StatFs statFs = new StatFs(path.getPath());
        if(android.os.Build.VERSION.SDK_INT < 18){
            int blockSize = statFs.getBlockSize();
            int blockCount = statFs.getAvailableBlocks();
            return blockCount * blockSize;
        }else{
            long blockSize = statFs.getBlockSizeLong();
            long blockCount = statFs.getAvailableBlocksLong();
            return blockCount * blockSize;
        }
    }

    /**
     * 获得手机可用内存
     * @return
     */
    public long getRomAvailableSize() {
        File path = Environment.getDataDirectory();
        StatFs statFs = new StatFs(path.getPath());
        if(android.os.Build.VERSION.SDK_INT < 18){
            int blockSize = statFs.getBlockSize();
            int blockCount = statFs.getAvailableBlocks();
            return blockCount * blockSize;
        }else{
            long blockSize = statFs.getBlockSizeLong();
            long blockCount = statFs.getAvailableBlocksLong();
            return blockCount * blockSize;
        }
    }

}
