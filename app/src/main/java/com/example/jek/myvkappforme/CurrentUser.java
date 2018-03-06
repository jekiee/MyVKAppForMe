package com.example.jek.myvkappforme;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKSdk;

/**
 * Created by jek on 26.02.2018.
 */

public class CurrentUser {
    public static String getAccessToken() {
        if (VKAccessToken.currentToken() == null) {
            return null;
        }
        return VKAccessToken.currentToken().accessToken;
    }

    public static String getId(){
        if(VKAccessToken.currentToken() == null){
            return null;
        }
        return VKAccessToken.currentToken().userId;
    }

    public static boolean authorized(){
        return VKSdk.isLoggedIn()
                && VKAccessToken.currentToken() != null
                && !VKAccessToken.currentToken().isExpired();
    }
}
