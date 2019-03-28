package com.example.censorapps;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private TextView txSensor;

    private TextView txSensorProximity;
    private TextView txSensorAccelero;
    private TextView txSensorGravity;
    private TextView txSensorHumid;
    private TextView txSensorGyroscope;
    private TextView txSensorMagnetic;

    private Sensor sensorProximity;
    private Sensor sensorAccelero;
    private Sensor sensorGravity;
    private Sensor sensorHumid;
    private Sensor sensorGyroscope;
    private Sensor sensorMagnetic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // txSensor=(TextView)findViewById(R.id.sensor_list);
        txSensorProximity=(TextView)findViewById(R.id.sensor_proximity);
        txSensorAccelero=(TextView)findViewById(R.id.sensor_accelerometer);
        txSensorGravity=(TextView)findViewById(R.id.sensor_gravity);
        txSensorHumid=(TextView)findViewById(R.id.sensor_humidity);
        txSensorGyroscope=(TextView)findViewById(R.id.sensor_gyroscope);
        txSensorMagnetic=(TextView)findViewById(R.id.sensor_magnetic);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
//        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
//
//        StringBuilder sensorText = new StringBuilder();
//        for(Sensor sensor:sensorList){
//            sensorText.append(sensor.getName())
//                    .append(System.getProperty("Line.separator"));
//        }
//        txSensor.setText(sensorText);

        sensorProximity = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        if(sensorProximity==null){
            txSensorProximity.setText("No Sensor");
        }

        sensorAccelero = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if(sensorAccelero==null){
            txSensorAccelero.setText("No Sensor");
        }

        sensorGravity = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        if(sensorGravity==null){
            txSensorGravity.setText("No Sensor");
        }

        sensorHumid = sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        if(sensorHumid==null){
            txSensorHumid.setText("No Sensor");
        }

        sensorGyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        if(sensorGyroscope==null){
            txSensorGyroscope.setText("No Sensor");
        }

        sensorMagnetic = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        if(sensorMagnetic==null){
            txSensorMagnetic.setText("No Sensor");
        }
    }

    protected void onStart() {
        super.onStart();
        if(sensorProximity!=null){
            sensorManager.registerListener(this, sensorProximity,
            SensorManager.SENSOR_DELAY_NORMAL);
        }
        if(sensorAccelero!=null){
            sensorManager.registerListener(this, sensorAccelero,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
        if(sensorGravity!=null){
            sensorManager.registerListener(this, sensorGravity,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
        if(sensorHumid!=null){
            sensorManager.registerListener(this, sensorHumid,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
        if(sensorGyroscope!=null){
            sensorManager.registerListener(this, sensorGyroscope,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
        if(sensorMagnetic!=null){
            sensorManager.registerListener(this, sensorMagnetic,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    protected void onStop() {
        super.onStop();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        int sensorType = sensorEvent.sensor.getType();
        float value = sensorEvent.values[0];
        if(sensorType==Sensor.TYPE_PROXIMITY){
            txSensorProximity.setText("Proximity Sensor " + value);
        }
        if(sensorType==Sensor.TYPE_ACCELEROMETER){
            txSensorAccelero.setText("Accelerometer Sensor " + value);
        }
        if(sensorType==Sensor.TYPE_GRAVITY){
            txSensorGravity.setText("Gravity Sensor " + value);
        }
        if(sensorType==Sensor.TYPE_RELATIVE_HUMIDITY){
            txSensorHumid.setText("Humid Sensor " + value);
        }
        if(sensorType==Sensor.TYPE_GYROSCOPE){
            txSensorGyroscope.setText("Gyroscope Sensor " + value);
        }
        if(sensorType==Sensor.TYPE_MAGNETIC_FIELD){
            txSensorMagnetic.setText("MagneticField Sensor " + value);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


}
