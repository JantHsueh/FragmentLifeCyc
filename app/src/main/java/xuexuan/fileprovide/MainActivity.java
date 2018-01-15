package xuexuan.fileprovide;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button mButton,mButton2,mButton3;

    private Fragment mFragment1;
    private Fragment mFragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.button);
        mButton2 = findViewById(R.id.button2);
        mButton3 = findViewById(R.id.button3);
        mFragment1 = new Fragment1();
        mFragment2 = new Fragment2();




        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
//
//                    ActivityCompat.requestPermissions(MainActivity.this,
//                            new String[]{android.Manifest.permission.CAMERA,
//                                    Manifest.permission.READ_EXTERNAL_STORAGE,
//                                    Manifest.permission.WRITE_EXTERNAL_STORAGE
//                            }, 1);
////                    FaceUtil.openCamera(MainActivity.this);
//                }else {
//                    FaceUtil.openCamera(MainActivity.this);
//
//                }

                FragmentManager lFragmentManager = getSupportFragmentManager();
                FragmentTransaction lFragmentTransaction = lFragmentManager.beginTransaction();

                //使用show和hide来切换fragment，可以通过onHidden来进行监听
//                lFragmentTransaction.show(mFragment1);
//                lFragmentTransaction.hide(mFragment2);
                //使用replace，来切换fragment，可以在fragment通过onResume和onPause来进行监听
                lFragmentTransaction.replace(R.id.frameLayout, mFragment1);
                lFragmentTransaction.commit();
                Log.d("fragment1", "fragment1 is"+mFragment1.toString() );
                Log.d("fragment2", "fragment2 is"+mFragment2.toString() );

            }
        });


        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager lFragmentManager = getSupportFragmentManager();
                FragmentTransaction lFragmentTransaction = lFragmentManager.beginTransaction();

//                lFragmentTransaction.show(mFragment2);
//                lFragmentTransaction.hide(mFragment1);
                lFragmentTransaction.replace(R.id.frameLayout, mFragment2);

                lFragmentTransaction.commit();
                Log.d("fragment1", "fragment1 is"+mFragment1.toString() );
                Log.d("fragment2", "fragment2 is"+mFragment2.toString() );
            }
        });


        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lIntent = new Intent(MainActivity.this,ViewPageActivity.class);
                startActivity(lIntent);
            }
        });

    }






    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    FaceUtil.openCamera(MainActivity.this);

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK) {
            return;
        }
        switch (requestCode) {
            case FaceUtil.REQUEST_PICTURE_CHOOSE:
                //从相册选取
                FaceUtil.dealPic(this, FaceUtil.REQUEST_PICTURE_CHOOSE, RESULT_OK, data);

                break;
            case FaceUtil.REQUEST_CAMERA_IMAGE:
                //拍照
                FaceUtil.dealPic(this, FaceUtil.REQUEST_CAMERA_IMAGE, RESULT_OK, data);

                break;
            case FaceUtil.REQUEST_CROP_IMAGE:
                //图片缩放完后
                Bundle extras = data.getExtras();
                String path = null;
                if (extras != null) {
                    path = FaceUtil.dealPic(this, FaceUtil.REQUEST_CROP_IMAGE, RESULT_OK, data);
                } else {
                    path = data.getData().getPath();
                }
                //注意这里没有break
                break;

            default:
                break;
        }

    }

}
