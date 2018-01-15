package xuexuan.fileprovide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/1/9.
 */

public class Fragment2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_two, container, false);
    }


    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getContext(), "fragment2 onResume ", Toast.LENGTH_LONG).show();
        Log.d("fragment2", "fragment2  onResume");
    }


    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(getContext(), "fragment2 onPause", Toast.LENGTH_LONG).show();
        Log.d("fragment2", "fragment2 onPause" );
    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);

        Toast.makeText(getContext(), "fragment2 onHiddenChanged is " + hidden, Toast.LENGTH_LONG).show();
        Log.d("fragment2", "fragment2 onHiddenChanged is " + hidden);

    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        //这里getContext获取不到context，不知道为什么
//        Toast.makeText(getContext(), "fragment2 setUserVisibleHint is " + isVisibleToUser, Toast.LENGTH_LONG).show();
        Log.d("fragment2", "fragment2 setUserVisibleHint is " + isVisibleToUser);

    }

}
