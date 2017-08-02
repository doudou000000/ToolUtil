package com.test.toolutils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.FileDescriptor;

/**
 * 图片压缩
 */

public class ImageResizerUtils {

    public ImageResizerUtils(){}

    /**
     * 获取从resource取得的图片经过压缩之后的图片
     * @param resources
     * @param resId
     * @param reqWidth
     * @param reqHeight
     * @return
     */
    public static Bitmap decodeSampledBitmapFromResource(Resources resources,int resId,int reqWidth,int reqHeight){

        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;

        BitmapFactory.decodeResource(resources,resId,options);

        options.inSampleSize = calculateInSampleSize(options,reqWidth,reqHeight);

        options.inJustDecodeBounds = false;

        return BitmapFactory.decodeResource(resources,resId,options);

    }

    /**
     * 获取从FileDescriptor取得的图片经过压缩之后的图片。BitmapFactory.Options对FileStream文件流的缩放有问题
     * 因为FileStream文件流是一种有序的文件流，两次decodeStream调用影响文件的位置属性，所以通过FileStream.getFD()来
     * 获取文件描述符FileDescriptor，再通过BitmapFactory.decodeFileDescriptor方法加载缩略图
     * @param fileDescriptor
     * @param reqWidth
     * @param reqHeight
     * @return
     */
    public static Bitmap decodeSampledBitmapFromFileDescriptor(FileDescriptor fileDescriptor, int reqWidth, int reqHeight){

        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;

        BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);

        options.inSampleSize = calculateInSampleSize(options,reqWidth,reqHeight);

        options.inJustDecodeBounds = false;

        return BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);

    }

    /**
     * 获取图片的采样率inSampleSize
     * @param options
     * @param reqWidth
     * @param reqHeight
     * @return
     */
    private static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {

        if(reqWidth == 0 || reqHeight == 0){
            return 1;
        }

        int width = options.outWidth;

        int height = options.outHeight;

        int inSampleSize = 1;

        if(width > reqWidth || height > reqHeight){
            int halfWidth = width/2;
            int halfHeight = height/2;
            //循环获取inSampleSize的值
            while ((halfWidth/inSampleSize) >= reqWidth && (halfHeight/inSampleSize) >= reqHeight){

                inSampleSize *= 2;

            }
        }

        return inSampleSize;
    }

}
