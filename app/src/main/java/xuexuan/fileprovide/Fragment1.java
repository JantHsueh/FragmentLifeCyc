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

public class Fragment1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one, container, false);
    }


    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getContext(), "fragment1 onResume ", Toast.LENGTH_LONG).show();
        Log.d("fragment1", "fragment1  onResume");
    }


    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(getContext(), "fragment1 onPause", Toast.LENGTH_LONG).show();
        Log.d("fragment1", "fragment1 onPause" );
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);

        Toast.makeText(getContext(), "fragment1 onHiddenChanged is " + hidden, Toast.LENGTH_LONG).show();
        Log.d("fragment1", "fragment1 onHiddenChanged is " + hidden);

    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

       //getActivity().getApplicationContext()，不知道为什么
//        Toast.makeText(getActivity().getApplicationContext(), "fragment1 setUserVisibleHint is " + isVisibleToUser, Toast.LENGTH_LONG).show();
        Log.d("fragment1", "fragment1 setUserVisibleHint is " + isVisibleToUser);

    }
}
