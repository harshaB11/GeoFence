package com.vuedata.assettracking;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.vuedata.assettracking.databinding.ActivityAdminBindingImpl;
import com.vuedata.assettracking.databinding.ActivityConfirmSignInBindingImpl;
import com.vuedata.assettracking.databinding.ActivityDeleteDeviceIdBindingImpl;
import com.vuedata.assettracking.databinding.ActivityListOfDeviceBindingImpl;
import com.vuedata.assettracking.databinding.ActivityLoginBindingImpl;
import com.vuedata.assettracking.databinding.ActivityRegistrationBindingImpl;
import com.vuedata.assettracking.databinding.ActivityTrackSingleDeviceBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYADMIN = 1;

  private static final int LAYOUT_ACTIVITYCONFIRMSIGNIN = 2;

  private static final int LAYOUT_ACTIVITYDELETEDEVICEID = 3;

  private static final int LAYOUT_ACTIVITYLISTOFDEVICE = 4;

  private static final int LAYOUT_ACTIVITYLOGIN = 5;

  private static final int LAYOUT_ACTIVITYREGISTRATION = 6;

  private static final int LAYOUT_ACTIVITYTRACKSINGLEDEVICE = 7;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(7);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.vuedata.assettracking.R.layout.activity_admin, LAYOUT_ACTIVITYADMIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.vuedata.assettracking.R.layout.activity_confirm_sign_in, LAYOUT_ACTIVITYCONFIRMSIGNIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.vuedata.assettracking.R.layout.activity_delete_device_id, LAYOUT_ACTIVITYDELETEDEVICEID);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.vuedata.assettracking.R.layout.activity_list_of_device, LAYOUT_ACTIVITYLISTOFDEVICE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.vuedata.assettracking.R.layout.activity_login, LAYOUT_ACTIVITYLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.vuedata.assettracking.R.layout.activity_registration, LAYOUT_ACTIVITYREGISTRATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.vuedata.assettracking.R.layout.activity_track_single_device, LAYOUT_ACTIVITYTRACKSINGLEDEVICE);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYADMIN: {
          if ("layout/activity_admin_0".equals(tag)) {
            return new ActivityAdminBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_admin is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYCONFIRMSIGNIN: {
          if ("layout/activity_confirm_sign_in_0".equals(tag)) {
            return new ActivityConfirmSignInBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_confirm_sign_in is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYDELETEDEVICEID: {
          if ("layout/activity_delete_device_id_0".equals(tag)) {
            return new ActivityDeleteDeviceIdBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_delete_device_id is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYLISTOFDEVICE: {
          if ("layout/activity_list_of_device_0".equals(tag)) {
            return new ActivityListOfDeviceBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_list_of_device is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYLOGIN: {
          if ("layout/activity_login_0".equals(tag)) {
            return new ActivityLoginBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_login is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYREGISTRATION: {
          if ("layout/activity_registration_0".equals(tag)) {
            return new ActivityRegistrationBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_registration is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYTRACKSINGLEDEVICE: {
          if ("layout/activity_track_single_device_0".equals(tag)) {
            return new ActivityTrackSingleDeviceBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_track_single_device is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(7);

    static {
      sKeys.put("layout/activity_admin_0", com.vuedata.assettracking.R.layout.activity_admin);
      sKeys.put("layout/activity_confirm_sign_in_0", com.vuedata.assettracking.R.layout.activity_confirm_sign_in);
      sKeys.put("layout/activity_delete_device_id_0", com.vuedata.assettracking.R.layout.activity_delete_device_id);
      sKeys.put("layout/activity_list_of_device_0", com.vuedata.assettracking.R.layout.activity_list_of_device);
      sKeys.put("layout/activity_login_0", com.vuedata.assettracking.R.layout.activity_login);
      sKeys.put("layout/activity_registration_0", com.vuedata.assettracking.R.layout.activity_registration);
      sKeys.put("layout/activity_track_single_device_0", com.vuedata.assettracking.R.layout.activity_track_single_device);
    }
  }
}
