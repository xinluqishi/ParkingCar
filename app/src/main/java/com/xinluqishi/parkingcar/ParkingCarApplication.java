package com.xinluqishi.parkingcar;

import com.xinluqishi.parkingcar.base.BaseApplication;
import com.xinluqishi.parkingcar.model.constant.IConstant;

/**
 * Created by shikeyue on 17/4/14.
 */

public class ParkingCarApplication extends BaseApplication {

   public ParkingCarApplication() {

   }

   @Override
   public String getApiUrl() {
      return IConstant.BASE.BASE_URL;
   }
}
