package com.liubz.androidtea.sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

import static android.util.Half.EPSILON;

/**
 * @Desc:
 * @Author: liubaozhu02
 * @Date: 2022/4/11 3:17 PM
 */
public class GyroSensorListener implements SensorEventListener {
    private static final String TAG = "GyroSensorListener";

    // Create a constant to convert nanoseconds to seconds.
    private static final float NS2S = 1.0f / 1000000000.0f;
    private final float[] deltaRotationVector = new float[4];
    private float[] values = new float[3];
    private float timestamp;
    double mDegreeZ, mDegreeX, mDegreeY;
    private float mAngle[] = new float[3]; // 记录xyz三个方向上的旋转角度

    public void onSensorChanged(SensorEvent event) {
        // This timestep's delta rotation to be multiplied by the current rotation
        // after computing it from the gyro sample data.
        if (timestamp != 0) {
            final float dT = (event.timestamp - timestamp) * NS2S;
            // Axis of the rotation sample, not normalized yet.
            float axisX = event.values[0];
            float axisY = event.values[1];
            float axisZ = event.values[2];

            // Calculate the angular speed of the sample
            float omegaMagnitude = (float) Math.sqrt(axisX * axisX + axisY * axisY + axisZ * axisZ);

            // Normalize the rotation vector if it's big enough to get the axis
            // (that is, EPSILON should represent your maximum allowable margin of error)
            if (omegaMagnitude > EPSILON) {
                axisX /= omegaMagnitude;
                axisY /= omegaMagnitude;
                axisZ /= omegaMagnitude;
            }

            // Integrate around this axis with the angular speed by the timestep
            // in order to get a delta rotation from this sample over the timestep
            // We will convert this axis-angle representation of the delta rotation
            // into a quaternion before turning it into the rotation matrix.

            mAngle[0] += event.values[0] * dT;
            mAngle[1] += event.values[1] * dT;
            mAngle[2] += event.values[2] * dT;
            // x轴的旋转角度，手机平放桌上，然后绕侧边转动
            float angleX = (float) Math.toDegrees(mAngle[0]);
            // y轴的旋转角度，手机平放桌上，然后绕底边转动
            float angleY = (float) Math.toDegrees(mAngle[1]);
            // z轴的旋转角度，手机平放桌上，然后水平旋转
            float angleZ = (float) Math.toDegrees(mAngle[2]);
            Log.i(TAG, "onSensorChanged: angleX: " + angleX + ", angleY: " + angleY
                    + ", angleZ: " + angleZ);

//            float thetaOverTwo = omegaMagnitude * dT / 2.0f;
//            float sinThetaOverTwo = (float) Math.sin(thetaOverTwo);
//            float cosThetaOverTwo = (float) Math.cos(thetaOverTwo);
//            deltaRotationVector[0] = sinThetaOverTwo * axisX;
//            deltaRotationVector[1] = sinThetaOverTwo * axisY;
//            deltaRotationVector[2] = sinThetaOverTwo * axisZ;
//            deltaRotationVector[3] = cosThetaOverTwo;
        }
        timestamp = event.timestamp;
//        float[] deltaRotationMatrix = new float[9];
//        SensorManager.getRotationMatrixFromVector(deltaRotationMatrix, deltaRotationVector);
//        SensorManager.getOrientation(deltaRotationMatrix, values);
//        //提取数据
//        mDegreeZ = Math.toDegrees(values[0]);
//        mDegreeX = Math.toDegrees(values[1]);
//        mDegreeY = Math.toDegrees(values[2]);
//        Log.i(TAG, "onSensorChanged: mDegreeX: " + mDegreeX + ", mDegreeY: " + mDegreeY
//                + ", mDegreeZ: " + mDegreeZ);
        // User code should concatenate the delta rotation we computed with the current rotation
        // in order to get the updated rotation.
        // rotationCurrent = rotationCurrent * deltaRotationMatrix;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
