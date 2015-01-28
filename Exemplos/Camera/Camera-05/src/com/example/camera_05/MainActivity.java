package com.example.camera_05;

import java.io.IOException;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Size;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

@SuppressLint("NewApi") 
public class MainActivity extends Activity 
{
    private Preview prvPreview;
    Camera cmrCamera;
    int iCameras;
    int iUsoCamera;
    int iCameraPadrao;

    @SuppressLint("NewApi") 
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        prvPreview = new Preview(this);
        setContentView(prvPreview);

        iCameras = Camera.getNumberOfCameras();
        CameraInfo cameraInfo = new CameraInfo();
        for (int i = 0; i < iCameras; i++) 
        {
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == CameraInfo.CAMERA_FACING_BACK) 
            {
                iCameraPadrao = i;
            }
        }
    }

    @Override
    protected void onResume() 
    {
        super.onResume();

        cmrCamera = Camera.open();
        iUsoCamera = iCameraPadrao;
        prvPreview.setCamera(cmrCamera);
    }

    @Override
    protected void onPause() 
    {
        super.onPause();

        if (cmrCamera != null) 
        {
            prvPreview.setCamera(null);
            cmrCamera.release();
            cmrCamera = null;
        }
    }
}

class Preview extends ViewGroup implements SurfaceHolder.Callback 
{
    private final String TAG = "Preview";

    SurfaceView mSurfaceView;
    SurfaceHolder mHolder;
    Size mPreviewSize;
    List<Size> mSupportedPreviewSizes;
    Camera mCamera;

    Preview(Context context) 
    {
        super(context);

        mSurfaceView = new SurfaceView(context);
        addView(mSurfaceView);

        mHolder = mSurfaceView.getHolder();
        mHolder.addCallback(this);
        mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }

    public void setCamera(Camera camera) 
    {
        mCamera = camera;
        if (mCamera != null) 
        {
            mSupportedPreviewSizes = mCamera.getParameters().getSupportedPreviewSizes();
            requestLayout();
        }
    }

    public void switchCamera(Camera camera) 
    {
       setCamera(camera);
       try 
       {
           camera.setPreviewDisplay(mHolder);
       } 
       catch (IOException exception) 
       {
           Log.e(TAG, "IOException caused by setPreviewDisplay()", exception);
       }
       
       Camera.Parameters parameters = camera.getParameters();
       parameters.setPreviewSize(mPreviewSize.width, mPreviewSize.height);
       requestLayout();

       camera.setParameters(parameters);
    }

    @Override
    protected void onMeasure(int iLarguraSpec, int iAlturaSpec) 
    {
        final int iLargura = resolveSize(getSuggestedMinimumWidth(), iLarguraSpec);
        final int iAltura = resolveSize(getSuggestedMinimumHeight(), iAlturaSpec);
        setMeasuredDimension(iLargura, iAltura);

        if (mSupportedPreviewSizes != null) 
        {
            mPreviewSize = getOptimalPreviewSize(mSupportedPreviewSizes, iLargura, iAltura);
        }
    }

    @Override
    protected void onLayout(boolean bMudanca, int iEsquerda, int iTopo, int iDireita, int iAbaixo) 
    {
        if (bMudanca && getChildCount() > 0) 
        {
            final View viwChild = getChildAt(0);

            final int iTamanhoLargura = iDireita - iEsquerda;
            final int iTamanhoAltura  = iAbaixo - iTopo;

            int iLarguraPreview = iTamanhoLargura;
            int iAlturaPreview  = iTamanhoAltura;
            if (mPreviewSize != null) 
            {
                iLarguraPreview = mPreviewSize.width;
                iAlturaPreview = mPreviewSize.height;
            }


            if (iTamanhoLargura * iAlturaPreview > iTamanhoAltura * iLarguraPreview) 
            {
                final int iLarguraChild = iLarguraPreview * iTamanhoAltura / iAlturaPreview;
                viwChild.layout((iTamanhoLargura - iLarguraChild) / 2, 0,(iTamanhoLargura + iLarguraChild) / 2, iTamanhoAltura);
            } 
            else 
            {
                final int iAlturaChild = iAlturaPreview * iTamanhoLargura / iLarguraPreview;
                viwChild.layout(0, (iTamanhoAltura - iAlturaChild) / 2,iTamanhoLargura, (iTamanhoAltura + iAlturaChild) / 2);
            }
        }
    }

    public void surfaceCreated(SurfaceHolder holder) 
    {
        try 
        {
            if (mCamera != null) 
            {
                mCamera.setPreviewDisplay(holder);
            }
        } 
        catch (IOException exception) 
        {
            Log.e(TAG, "Erro na Definicao do setPreviewDisplay()", exception);
        }
    }

    public void surfaceDestroyed(SurfaceHolder holder) 
    {
        if (mCamera != null) 
        {
            mCamera.stopPreview();
        }
    }


    private Size getOptimalPreviewSize(List<Size> sizes, int w, int h) 
    {
        final double ASPECT_TOLERANCE = 0.1;
        double targetRatio = (double) w / h;
        if (sizes == null) return null;

        Size optimalSize = null;
        double minDiff = Double.MAX_VALUE;

        int targetHeight = h;

        for (Size size : sizes) 
        {
            double ratio = (double) size.width / size.height;
            if (Math.abs(ratio - targetRatio) > ASPECT_TOLERANCE) continue;
            if (Math.abs(size.height - targetHeight) < minDiff) 
            {
                optimalSize = size;
                minDiff = Math.abs(size.height - targetHeight);
            }
        }

        if (optimalSize == null) 
        {
            minDiff = Double.MAX_VALUE;
            for (Size size : sizes) {
                if (Math.abs(size.height - targetHeight) < minDiff) 
                {
                    optimalSize = size;
                    minDiff = Math.abs(size.height - targetHeight);
                }
            }
        }
        return optimalSize;
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) 
    {
        Camera.Parameters parameters = mCamera.getParameters();
        parameters.setPreviewSize(mPreviewSize.width, mPreviewSize.height);
        requestLayout();

        mCamera.setParameters(parameters);
        mCamera.startPreview();
    }
}